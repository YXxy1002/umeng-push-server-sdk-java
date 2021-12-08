package io.github.xy.model.response;


import com.google.gson.annotations.SerializedName;
import io.github.xy.model.request.CommonRequest;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class CommonResponse {
    @SerializedName("error_code")
    private String errorCode;
    @SerializedName("error_msg")
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
