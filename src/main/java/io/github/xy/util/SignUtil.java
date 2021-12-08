package io.github.xy.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class SignUtil {
    /**
     * @param method          request method
     * @param url             request url
     * @param requestBody     request body
     * @param appMasterSecret umeng appMasterSecret
     * @return
     */
    public static String getSign(String method, String url, String requestBody, String appMasterSecret) {
        return DigestUtils.md5Hex(method + url + requestBody + appMasterSecret);
    }
}
