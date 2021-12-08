package io.github.xy.client;


import io.github.xy.model.constant.RequestMethod;
import io.github.xy.model.request.TagCommonRequest;
import io.github.xy.model.request.UploadRequest;
import io.github.xy.model.response.CommonResponse;
import io.github.xy.util.GsonUtil;
import io.github.xy.util.HttpUtil;

import java.io.IOException;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class Pro {

    /**
     * tagAdd
     */
    private static final String tagAdd = "/api/tag/add";

    /**
     * tagList
     */
    private static final String tagList = "/api/tag/list";

    /**
     * tagSet
     */
    private static final String tagSet = "/api/tag/set";

    /**
     * tagDelete
     */
    private static final String tagDelete = "/api/tag/delete";

    /**
     * tagClear
     */
    private static final String tagClear = "/api/tag/clear";


    private final PushClient pushClient;

    public Pro(PushClient pushClient) {
        this.pushClient = pushClient;
    }


    public CommonResponse tagAdd(TagCommonRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(tagAdd, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CommonResponse.class, this.pushClient.getConfig());
    }

    public CommonResponse tagList(TagCommonRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(tagList, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CommonResponse.class, this.pushClient.getConfig());
    }

    public CommonResponse tagSet(TagCommonRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(tagSet, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CommonResponse.class, this.pushClient.getConfig());
    }

    public CommonResponse tagDelete(TagCommonRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(tagDelete, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CommonResponse.class, this.pushClient.getConfig());
    }

    public CommonResponse tagClear(TagCommonRequest request) throws IOException {
        this.pushClient.setNecessaryParams(request);
        String requestBody = GsonUtil.toJson(request, UploadRequest.class);
        String url = this.pushClient.getWholeUrl(tagClear, RequestMethod.POST, requestBody);
        return HttpUtil.post(url, requestBody, CommonResponse.class, this.pushClient.getConfig());
    }


}
