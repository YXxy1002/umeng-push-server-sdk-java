package io.github.xy.model.response;

import com.google.gson.annotations.SerializedName;
import io.github.xy.model.request.CommonRequest;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class UploadResponse {
    @SerializedName("ret")
    private String ret;
    @SerializedName("data")
    private Data data;

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data extends CommonResponse {
        @SerializedName("file_id")
        private String fileId;

        public String getFileId() {
            return fileId;
        }

        public void setFileId(String fileId) {
            this.fileId = fileId;
        }
    }
}
