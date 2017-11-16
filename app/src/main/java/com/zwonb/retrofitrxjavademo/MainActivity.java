package com.zwonb.retrofitrxjavademo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.widget.TextView;

import com.zwonb.retrofitrxjavademo.base.BaseToolbarActivity;
import com.zwonb.retrofitrxjavademo.bean.IndexInfo;
import com.zwonb.retrofitrxjavademo.network.ActValue;
import com.zwonb.retrofitrxjavademo.network.AlAccountUtil;
import com.zwonb.retrofitrxjavademo.network.BaseApi;
import com.zwonb.retrofitrxjavademo.network.BaseObserver;
import com.zwonb.retrofitrxjavademo.network.BaseRetrofit;

import java.util.HashMap;

public class MainActivity extends BaseToolbarActivity {

    /**
     * Hello World!
     */
    private TextView mMainText;

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        AlAccountUtil.getInstance().setPhoneImei(getIMEI(getBaseContext()));
        initView();
    }

    /**
     * 手机的IMEI
     */
    public static String getIMEI(Context mContext) {

        TelephonyManager mTelephonyMgr = (TelephonyManager) mContext
                .getSystemService(Context.TELEPHONY_SERVICE);

        String IMEI = mTelephonyMgr.getDeviceId();

//        ComLog.E("Imei+"+IMEI);

        return "yidont/" + IMEI;

    }

    private void initView() {
        mMainText = findViewById(R.id.main_text);
        mMainText.setOnClickListener(v ->
                startActivity(new Intent(this, Main2Activity.class)));
    }

    private void request() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(ActValue.Act, ActValue.ElifeFirst);
        map.put(ActValue.AgentId, "1" + "");
        map.put(ActValue.VersionCode, "1.0");
        map.put(ActValue.Lat, "");
        map.put(ActValue.Lon, "");
        map.put(ActValue.Model, Build.MODEL + "");

        BaseRetrofit.SUBSCRIBE(BaseRetrofit.HTTPS(BaseApi.class).post(map),
                new BaseObserver<IndexInfo>(mLoading) {
                    @Override
                    protected void onSuccess(IndexInfo indexInfo) {
                        mMainText.setText(indexInfo.getUserGiftText2());
                    }
                }
        );
    }

    @Override
    public void onRequestAgain() {
        request();
    }
}
