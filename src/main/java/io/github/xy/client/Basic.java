package io.github.xy.client;


import io.github.xy.model.constant.RequestMethod;
import io.github.xy.model.request.*;
import io.github.xy.model.request.send.UmengNotification;
import io.github.xy.model.response.*;
import io.github.xy.util.GsonUtil;
import io.github.xy.util.HttpUtil;

import java.io.IOException;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class Basic {

    /**
     * send
     */
    private static final String send = "/api/send";

    /**
     * status
     */
    private static final String status = "/api/status";

    /**
     * taskStat
     */
    private static final String taskStat = "/api/task/stat";

    /**
     * cancel
     */
    private static final String cancel = "/api/cancel";

    /**
     * upload
     */
    private static final String upload = "/upload";


    private final PushClient pushClient;

    public Basic(PushClient pushClient) {
        this.pushClient = pushClient;
    }


    public SendResponse send(UmengNotification umengNotification) throws IOException {
        umengNotification.setNecessaryParams(this.pushClient.getAppKey(), Long.toString(System.currentTimeMillis()));
        String requestBody = umengNotification.getPostBody();
        String url = this.pushClient.getWholeUrl(send, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, SendResponse.class, this.pushClient.getConfig());
    }

    public StatusResponse status(StatusRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, StatusRequest.class);
        String url = this.pushClient.getWholeUrl(status, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, StatusResponse.class, this.pushClient.getConfig());
    }

    public TaskStatResponse taskStat(TaskStatRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, TaskStatRequest.class);
        String url = this.pushClient.getWholeUrl(taskStat, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, TaskStatResponse.class, this.pushClient.getConfig());
    }

    public CancelResponse cancel(CancelRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, CancelRequest.class);
        String url = this.pushClient.getWholeUrl(cancel, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CancelResponse.class, this.pushClient.getConfig());
    }

    public UploadResponse upload(UploadRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(upload, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, UploadResponse.class, this.pushClient.getConfig());
    }
}
