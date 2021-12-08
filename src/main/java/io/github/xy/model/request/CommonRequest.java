package io.github.xy.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class CommonRequest {
    @SerializedName("appkey")
    private String appKey;
    @SerializedName("timestamp")
    private String timestamp;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
