package com.zwonb.retrofitrxjavademo.network;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.zwonb.retrofitrxjavademo.AlApplication;
import com.zwonb.retrofitrxjavademo.security.SafetyThreeDes;


/**
 * Created by li4236 on 16/6/17.
 * li4236@aliyun.com
 * 保存账号和第一 是否打开的处理
 */
public class AlAccountUtil {

    private static SharedPreferences mShare;

    private static SharedPreferences.Editor editor;

    private static AlAccountUtil gainAccount = null;


    public static AlAccountUtil getInstance(Context context) {
        if (gainAccount == null) {
            synchronized (AlAccountUtil.class) {
                if (gainAccount == null) {
                    gainAccount = new AlAccountUtil(context);
                }
            }
        }

        return gainAccount;
    }

    public static AlAccountUtil getInstance() {


        if (gainAccount == null)
        {
            getInstance(AlApplication.getAppContext());
        }

        return gainAccount;
    }

    private AlAccountUtil(Context context) {

        mShare = context.getSharedPreferences(AlActValue.Account, Context.MODE_PRIVATE);

        editor = mShare.edit();
    }


    /**
     * 获取到的账号是解密之后的账号
     * 例如：13824797046
     */
    public String getAccount() {


        String mPhone = mShare.getString(AlActValue.Account, "");
        if (TextUtils.isEmpty(mPhone))
            return "";

        try {

            return SafetyThreeDes.decode(mPhone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 保存手机号码,自动加密
     */
    public void setAccount(String phone) {

        try {
            editor.putString(AlActValue.Account, SafetyThreeDes.encode(phone));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }

    /**
     * 获取加密的手机号码
     */
    public String getEecodeAccount() {

        try {
            return mShare.getString(AlActValue.Account, "");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }


    //删除手机号码
    public void removeAccount() {
        editor.remove(AlActValue.Account);
        editor.remove(AlActValue.PushUid);
        editor.remove(AlActValue.PushYidont);
        editor.remove(AlActValue.ShopsId);
        editor.remove(AlActValue.DeliverId);
        editor.commit();

    }

    //删除手机号码
    public void removeSigleAccount() {
        editor.remove(AlActValue.Account);

        editor.commit();

    }


    //版本是否是第一次打开（导航）
    public void setIsFirst(Boolean url) {

        editor.putBoolean(AlActValue.IsOpen, url);

        editor.commit();


    }

    public Boolean getIsFirst() {
        return mShare.getBoolean(AlActValue.IsOpen, true);
    }


    /**
     * 获取到推送的UId
     */
    public String getPushUid() {


        String mPhone = mShare.getString(AlActValue.PushUid, "");
        if (TextUtils.isEmpty(mPhone))
            return "";

        try {

            return SafetyThreeDes.decode(mPhone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setPushId(String pushId) {

        try {
            editor.putString(AlActValue.PushUid, SafetyThreeDes.encode(pushId));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }


    public String getYidontPushId() {


        String mPhone = mShare.getString(AlActValue.PushYidont, "");
        if (TextUtils.isEmpty(mPhone))
            return "";

        try {

            return SafetyThreeDes.decode(mPhone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setYidontPushId(String phone) {

        try {
            editor.putString(AlActValue.PushYidont, SafetyThreeDes.encode(phone));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }


    public String getAgentsId() {


        String mPhone = mShare.getString(AlActValue.AgentsId, "");
        if (TextUtils.isEmpty(mPhone))
            return "";

        try {

            return SafetyThreeDes.decode(mPhone);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setAgentsId(String phone) {

        try {
            editor.putString(AlActValue.AgentsId, SafetyThreeDes.encode(phone));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }

    public String getShopsId() {


        String ShopsId = mShare.getString(AlActValue.ShopsId, "");
        if (TextUtils.isEmpty(ShopsId))
            return "";

        try {

            return SafetyThreeDes.decode(ShopsId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setShopsId(String ShopsId) {

        try {
            editor.putString(AlActValue.ShopsId, SafetyThreeDes.encode(ShopsId));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }


    public String getDeliverId() {


        String ShopsId = mShare.getString(AlActValue.DeliverId, "");
        if (TextUtils.isEmpty(ShopsId))
            return "";

        try {

            return SafetyThreeDes.decode(ShopsId);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setDeliverId(String DeliverId) {

        try {
            editor.putString(DeliverId, SafetyThreeDes.encode(DeliverId));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }

    /**
     * @return 获取到时加密之后的数据
     */
    public String getPhoneImei() {


        String ShopsId = mShare.getString(AlActValue.Imei, "");
        if (TextUtils.isEmpty(ShopsId))
            return "";

        try {

            return ShopsId;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public void setPhoneImei(String imei) {



        try {

            editor.putString(AlActValue.Imei, SafetyThreeDes.encode(imei));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        editor.commit();
    }


    /**
     * 获取来电秀秀设置的id
     * @return
     */
    public String getCallShowId() {

        return  mShare.getString(AlActValue.CallShowId, "");
    }


    /**
     * 来电秀秀设置的id
     * @param callShowId
     */
    public void setCallShowId(String callShowId) {

        editor.putString(AlActValue.CallShowId, callShowId);
        editor.commit();
    }

    /**
     * //0没有，大于0则提示欠费多少）
     */
    public int getCallArre() {

        return mShare.getInt(ActValue.CallArre, 0);
    }


    /**
     * //0没有，大于0则提示欠费多少）
     */
    public void setCallArre(int phone) {


        editor.putInt(ActValue.CallArre, phone);

        editor.commit();
    }

}
