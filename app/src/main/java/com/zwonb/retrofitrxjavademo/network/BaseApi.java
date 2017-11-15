package com.zwonb.retrofitrxjavademo.network;

import com.zwonb.retrofitrxjavademo.bean.IndexInfo;
import com.zwonb.retrofitrxjavademo.bean.InfoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Created by zwonb on 2017/11/14.
 */

public interface BaseApi {

//    http://ttyw.yidont.com/?s=api/getTypeList

    @GET("{arg}")
    Call<BaseBean<InfoBean>> getPath(@Path("arg") String arg, @QueryMap Map<String, String> map);


    @FormUrlEncoded
    @POST("userview/")
    Call<BaseBean<IndexInfo>> postPath(/*@Path("arg") String arg, */@FieldMap Map<String, Object> map);


    @FormUrlEncoded
    @POST("userview/")
    Observable<BaseBean<IndexInfo>> post(/*@Path("arg") String arg, */@FieldMap Map<String, Object> map);

}
