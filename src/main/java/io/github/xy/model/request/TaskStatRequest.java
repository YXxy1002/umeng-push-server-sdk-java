package io.github.xy.model.request;

import com.google.gson.annotations.SerializedName;

public class TaskStatRequest extends CommonRequest {
    @SerializedName("task_id")
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
