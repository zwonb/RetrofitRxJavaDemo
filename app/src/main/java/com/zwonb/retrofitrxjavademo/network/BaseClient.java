package com.zwonb.retrofitrxjavademo.network;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.zwonb.retrofitrxjavademo.security.AppSafety;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 配置OkHttpClient
 * Created by zwonb on 2017/11/14.
 */

public class BaseClient {

    private volatile static BaseClient mBaseClient;
    private OkHttpClient mClient;

    private BaseClient() {
    }

    public static BaseClient getInstance() {
        if (mBaseClient == null) {
            synchronized (BaseClient.class) {
                if (mBaseClient == null) {
                    mBaseClient = new BaseClient();
                }
            }
        }
        return mBaseClient;
    }

    public OkHttpClient getClient() {
        if (mClient == null) {
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(@NonNull Chain chain) throws IOException {
                            String time = AppSafety.getTime();


                            Request original = chain.request();

                            //添加公司统一参数配置
                            Request.Builder requestBuilder = original.newBuilder()
                                    .addHeader("key", AppSafety.getKey(time))
                                    .addHeader("clueid", AppSafety.getClueid(time));


                            HashMap<String, Object> hashMap = new HashMap<>();

                            Request request = null;

                            if ("POST".equals(original.method())) {


                                //请求体定制：统一添加sign参数
                                if (original.body() instanceof FormBody) {
                                    FormBody.Builder newFormBody = new FormBody.Builder();
                                    FormBody oidFormBody = (FormBody) original.body();

                                    for (int i = 0; i < oidFormBody.size(); i++) {
                                        String name = oidFormBody.name(i);
                                        String value = oidFormBody.value(i);
                                        hashMap.put(name, value);
                                        newFormBody.addEncoded(name, value);


                                    }

                                    hashMap.put(AlActValue.Imei, AlAccountUtil.getInstance().getPhoneImei());

                                    newFormBody.addEncoded(AlActValue.Imei, AlAccountUtil.getInstance().getPhoneImei());

                                    if (!hashMap.containsKey(AlActValue.Account) && !TextUtils.isEmpty(AlAccountUtil.getInstance().getEecodeAccount())) {
                                        hashMap.put(AlActValue.Account, AlAccountUtil.getInstance().getEecodeAccount());
                                        newFormBody.addEncoded(AlActValue.Account, AlAccountUtil.getInstance().getEecodeAccount());
                                    }


                                    newFormBody.add(AlActValue.ACCESSSIGN, AppSafety.getParams(hashMap, original));

                                    requestBuilder.method(original.method(), newFormBody.build());
                                    request = requestBuilder.build();
                                } else if (original.body() instanceof MultipartBody) {

                                    request = requestBuilder.build();
                                }
                            } else if ("GET".equals(original.method())) {

                                Iterator<String> iterator = original.url().queryParameterNames().iterator();
                                while (iterator.hasNext()) {
                                    String key = iterator.next();
                                    String value = original.url().queryParameter(key);
                                    hashMap.put(key, value);
                                }


                                HttpUrl.Builder builder = original.url().newBuilder();

                                hashMap.put(AlActValue.Imei, AlAccountUtil.getInstance().getPhoneImei());

                                builder.addQueryParameter(AlActValue.Imei, AlAccountUtil.getInstance().getPhoneImei());


                                if (!hashMap.containsKey(AlActValue.Account) && !TextUtils.isEmpty(AlAccountUtil.getInstance().getEecodeAccount())) {
                                    hashMap.put(AlActValue.Account, AlAccountUtil.getInstance().getEecodeAccount());
                                    builder.addQueryParameter(AlActValue.Account, AlAccountUtil.getInstance().getEecodeAccount());
                                }

                                builder.addQueryParameter(AlActValue.ACCESSSIGN, AppSafety.getParams(hashMap, original));

                                HttpUrl accessSign = builder.build();

                                request = requestBuilder.url(accessSign).build();
                            }
                            return chain.proceed(request);
                        }
                    })
                    .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(@NonNull String message) {
                            Log.e("binbin", "OkHttpLog: " + message);
                        }
                    }).setLevel(HttpLoggingInterceptor.Level.BASIC))
                    .build();
        }
        return mClient;
    }
}
