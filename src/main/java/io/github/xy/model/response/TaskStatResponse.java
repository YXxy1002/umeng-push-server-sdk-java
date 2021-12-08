package io.github.xy.model.response;


import com.google.gson.annotations.SerializedName;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class TaskStatResponse {
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

    public static class Data {
        @SerializedName("arrive_count")
        private Integer arriveCount;
        @SerializedName("accept_count")
        private Integer acceptCount;
        @SerializedName("open_count")
        private Integer openCount;
        @SerializedName("task_id")
        private String taskId;
        @SerializedName("dismiss_rate")
        private String dismissRate;
        @SerializedName("sent_count")
        private Integer sentCount;
        @SerializedName("dismiss_count")
        private Integer dismissCount;
        @SerializedName("open_rate")
        private String openRate;

        public Integer getArriveCount() {
            return arriveCount;
        }

        public void setArriveCount(Integer arriveCount) {
            this.arriveCount = arriveCount;
        }

        public Integer getAcceptCount() {
            return acceptCount;
        }

        public void setAcceptCount(Integer acceptCount) {
            this.acceptCount = acceptCount;
        }

        public Integer getOpenCount() {
            return openCount;
        }

        public void setOpenCount(Integer openCount) {
            this.openCount = openCount;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getDismissRate() {
            return dismissRate;
        }

        public void setDismissRate(String dismissRate) {
            this.dismissRate = dismissRate;
        }

        public Integer getSentCount() {
            return sentCount;
        }

        public void setSentCount(Integer sentCount) {
            this.sentCount = sentCount;
        }

        public Integer getDismissCount() {
            return dismissCount;
        }

        public void setDismissCount(Integer dismissCount) {
            this.dismissCount = dismissCount;
        }

        public String getOpenRate() {
            return openRate;
        }

        public void setOpenRate(String openRate) {
            this.openRate = openRate;
        }
    }
}
