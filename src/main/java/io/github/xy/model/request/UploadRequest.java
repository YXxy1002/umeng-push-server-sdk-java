package io.github.xy.model.request;

import com.google.gson.annotations.SerializedName;

public class UploadRequest extends CommonRequest {
    @SerializedName("content")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
