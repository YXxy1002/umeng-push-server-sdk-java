package io.github.xy.model.request;

import com.google.gson.annotations.SerializedName;

public class TagCommonRequest extends CommonRequest {
    @SerializedName("device_tokens")
    private String deviceTokens;

    @SerializedName("tag")
    private String tag;

    public String getDeviceTokens() {
        return deviceTokens;
    }

    public void setDeviceTokens(String deviceTokens) {
        this.deviceTokens = deviceTokens;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
