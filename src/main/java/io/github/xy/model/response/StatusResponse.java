package io.github.xy.model.response;


import com.google.gson.annotations.SerializedName;
import io.github.xy.model.request.CommonRequest;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class StatusResponse {
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
        @SerializedName("task_id")
        private String taskId;
        @SerializedName("status")
        private Integer status;
        @SerializedName("sent_count")
        private Integer sentCount;
        @SerializedName("open_count")
        private Integer openCount;
        @SerializedName("dismiss_count")
        private Integer dismissCount;
        @SerializedName("total_count")
        private Integer totalCount;

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getSentCount() {
            return sentCount;
        }

        public void setSentCount(Integer sentCount) {
            this.sentCount = sentCount;
        }

        public Integer getOpenCount() {
            return openCount;
        }

        public void setOpenCount(Integer openCount) {
            this.openCount = openCount;
        }

        public Integer getDismissCount() {
            return dismissCount;
        }

        public void setDismissCount(Integer dismissCount) {
            this.dismissCount = dismissCount;
        }

        public Integer getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
        }

    }
}
