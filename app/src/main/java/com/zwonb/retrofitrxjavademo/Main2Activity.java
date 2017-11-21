package com.zwonb.retrofitrxjavademo;

import com.zwonb.retrofitrxjavademo.base.BaseToolbarActivity;
import com.zwonb.retrofitrxjavademo.bean.NovelBookBean;
import com.zwonb.retrofitrxjavademo.network.BaseApi;
import com.zwonb.retrofitrxjavademo.network.BaseObserver;
import com.zwonb.retrofitrxjavademo.network.BaseRetrofit;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends BaseToolbarActivity {

    @Override
    protected int setContentLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void init() {
        setTitle("第二个");
        request();

    }

    private void request() {
        Map<String,Object> map = new HashMap<>();
        map.put("act","indexList");
        mLoading.setShowLoad(false);
        mLoading.setLoadLayout(findViewById(R.id.load_layout));
        BaseRetrofit.SUBSCRIBE(BaseRetrofit.HTTP(BaseApi.class).get(map),
                new BaseObserver<NovelBookBean>(mLoading) {
                    @Override
                    protected void onSuccess(NovelBookBean novelBookBean) {

                    }
                });
    }

    @Override
    public void onRequestAgain() {
        request();
    }
}
