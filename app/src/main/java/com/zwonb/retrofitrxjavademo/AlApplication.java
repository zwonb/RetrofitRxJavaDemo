package com.zwonb.retrofitrxjavademo;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/**
 * APPLICATION
 */
public class AlApplication extends Application {

    public static int statusHeight = -1;
    private static Context baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            statusHeight = StatusBarHeightUtil.getStatusBarH(this);
//        }

//        ComLog.E("初始化成功");
    }

    public static Context getAppContext() {


        return baseApplication;
    }

//    public static void getAppContext(Context context) {
//
//
//        baseApplication = context;
//
//    }

    public static String getAgaintsId(Context context) {
        String agaent = "yidont_1";
        ApplicationInfo appInfo = null;
        try {
            appInfo = context.getPackageManager()
                    .getApplicationInfo(context.getPackageName(),
                            PackageManager.GET_META_DATA);

            agaent = appInfo.metaData.getString("UMENG_CHANNEL");


            if (!TextUtils.isEmpty(agaent)) {
                agaent = agaent.substring(agaent.lastIndexOf("_") + 1, agaent.length());
            }

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return agaent;

    }

//    public static Resources getAppResources() {
//        return baseApplication.getResources();
//    }

//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//    }
//
//    /**
//     * 分包
//     * @param base
//     */
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//
//    }

}
