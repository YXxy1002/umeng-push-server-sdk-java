package io.github.xy.client;


import io.github.xy.model.request.CommonRequest;
import io.github.xy.util.SignUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class PushClient {

    private static final ConcurrentHashMap<String, PushClient> pushClientMap = new ConcurrentHashMap<>();

    /**
     * host
     */
    private static final String host = "http://msg.umeng.com";

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


    private String appKey;

    private String appMasterSecret;

    public Basic basic;

    public Pro pro;

    private ClientConfiguration config;

    private PushClient() {
    }

    public PushClient(String appKey, String appMasterSecret) {
        this.appKey = appKey;
        this.appMasterSecret = appMasterSecret;
        this.basic = new Basic(this);
        this.pro = new Pro(this);
    }

    public PushClient(String appKey, String appMasterSecret, ClientConfiguration clientConfiguration) {
        this.appKey = appKey;
        this.appMasterSecret = appMasterSecret;
        this.config = clientConfiguration;
        this.basic = new Basic(this);
    }

    public static PushClient getInstance(String appKey, String appMasterSecret) {
        if (pushClientMap.get(appKey) == null) {
            PushClient pushClient = new PushClient(appKey, appMasterSecret);
            pushClientMap.putIfAbsent(appKey, pushClient);
            return pushClient;
        }
        return pushClientMap.get(appKey);
    }

    public static PushClient getInstance(String appKey, String appMasterSecret, ClientConfiguration clientConfiguration) {
        if (pushClientMap.get(appKey) == null) {
            PushClient pushClient = new PushClient(appKey, appMasterSecret);
            pushClientMap.putIfAbsent(appKey, pushClient);
            return pushClient;
        }
        PushClient pushClient = pushClientMap.get(appKey);
        if (clientConfiguration != null && !clientConfiguration.equals(pushClient.getConfig())) {
            pushClient.setConfig(clientConfiguration);
        }
        return pushClient;
    }


    public String getWholeUrl(String url, String requestMethod, String requestBody) {
        String wholeUrl = host + url;
        String sign = SignUtil.getSign(requestMethod, wholeUrl, requestBody, this.getAppMasterSecret());
        return wholeUrl + "?sign=" + sign;
    }

    public void setNecessaryParams(CommonRequest request) {
        request.setAppKey(this.getAppKey());
        request.setTimestamp(Long.toString(System.currentTimeMillis()));
    }


    public String getAppKey() {
        return appKey;
    }

    public String getAppMasterSecret() {
        return appMasterSecret;
    }

    public ClientConfiguration getConfig() {
        return config;
    }

    public void setConfig(ClientConfiguration config) {
        this.config = config;
    }
}

