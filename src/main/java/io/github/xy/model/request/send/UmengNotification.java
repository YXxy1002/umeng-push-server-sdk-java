package io.github.xy.model.request.send;

import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public abstract class UmengNotification {
    // This JSONObject is used for constructing the whole request string.
    protected final JSONObject rootJson = new JSONObject();


    // Keys can be set in the root level
    protected static final HashSet<String> ROOT_KEYS = new HashSet<String>(Arrays.asList("type", "device_tokens", "alias", "alias_type", "file_id",
            "filter", "production_mode", "feedback", "description", "thirdparty_id", "mipush", "mi_activity", "channel_properties", "receipt_url", "receipt_type"));

    // Keys can be set in the policy level
    protected static final HashSet<String> POLICY_KEYS = new HashSet<String>(Arrays.asList("start_time", "expire_time", "max_send_num"));

    // Set predefined keys in the rootJson, for extra keys(Android) or customized keys(IOS) please
    // refer to corresponding methods in the subclass.
    public abstract boolean setPredefinedKeyValue(String key, Object value) throws Exception;

    public void setNecessaryParams(String appKey, String timestamp) {
        rootJson.put("appkey", appKey);
        rootJson.put("timestamp", timestamp);
    }

    public String getPostBody() {
        return rootJson.toString();
    }

    protected void setProductionMode(Boolean prod) throws Exception {
        setPredefinedKeyValue("production_mode", prod.toString());
    }

    ///正式模式
    public void setProductionMode() throws Exception {
        setProductionMode(true);
    }

    ///测试模式
    public void setTestMode() throws Exception {
        setProductionMode(false);
    }

    ///发送消息描述，建议填写。
    public void setDescription(String description) throws Exception {
        setPredefinedKeyValue("description", description);
    }

    ///定时发送时间，若不填写表示立即发送。格式: "YYYY-MM-DD hh:mm:ss"。
    public void setStartTime(String startTime) throws Exception {
        setPredefinedKeyValue("start_time", startTime);
    }

    ///消息过期时间,格式: "YYYY-MM-DD hh:mm:ss"。
    public void setExpireTime(String expireTime) throws Exception {
        setPredefinedKeyValue("expire_time", expireTime);
    }

    ///发送限速，每秒发送的最大条数。
    public void setMaxSendNum(Integer num) throws Exception {
        setPredefinedKeyValue("max_send_num", num);
    }

    //厂商弹窗activity
    public void setChannelActivity(String activity) throws Exception {
        setPredefinedKeyValue("mipush", "true");
        setPredefinedKeyValue("mi_activity", activity);
    }

    //厂商属性配置
    public void setChannelProperties(String xiaoMiChannelId) throws Exception {
        JSONObject object = new JSONObject();
        object.put("xiaomi_channel_id", xiaoMiChannelId);
        setPredefinedKeyValue("channel_properties", object);
    }

    /**
     * 设置消息回执
     *
     * @param receiptUrl  接收数据的地址
     * @param receiptType 回执数据类型 1：送达回执；2：点击回执；3：送达和点击/忽略回执。默认为3
     * @throws Exception
     */
    public void setReceipt(String receiptUrl, String receiptType) throws Exception {
        setPredefinedKeyValue("receipt_url", receiptUrl);
        setPredefinedKeyValue("receipt_type", receiptType);
    }

}
