package io.github.xy.util;

import io.github.xy.client.ClientConfiguration;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class HttpUtil {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private static final ClientConfiguration DEFAULT_CONFIG = new ClientConfiguration();

    private static final OkHttpClient DEFAULT_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_CONFIG.getConnectTimeout(), TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_CONFIG.getReadTimeout(), TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_CONFIG.getWriteTimeout(), TimeUnit.MILLISECONDS)
            .retryOnConnectionFailure(false)
            .addInterceptor(new RetryInterceptor(DEFAULT_CONFIG.getMaxRetries()))
            .build();

    private HttpUtil() {

    }

    public static <T> T post(String url, String json, Class<T> cls) throws IOException {
        String result = post(url, json, DEFAULT_CONFIG);
        return GsonUtil.fromJson(result, cls);
    }

    public static <T> T post(String url, String json, Class<T> cls, ClientConfiguration config) throws IOException {
        String result = post(url, json, config);
        return GsonUtil.fromJson(result, cls);
    }

    public static String post(String url, String json, ClientConfiguration config) throws IOException {
        OkHttpClient httpClient = DEFAULT_CLIENT;
        if (config != null) {
            httpClient = new OkHttpClient.Builder()
                    .connectTimeout(config.getConnectTimeout(), TimeUnit.MILLISECONDS)
                    .readTimeout(config.getReadTimeout(), TimeUnit.MILLISECONDS)
                    .writeTimeout(config.getWriteTimeout(), TimeUnit.MILLISECONDS)
                    .retryOnConnectionFailure(false)
                    .addInterceptor(new RetryInterceptor(config.getMaxRetries()))
                    .build();
        }
        return post(url, json, httpClient, null);
    }

    public static String post(String url, String json, OkHttpClient httpClient, Map<String, String> headers) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Headers.Builder hb = new Headers.Builder();
        if (headers != null && !headers.isEmpty()) {
            headers.forEach(hb::add);
        }
        Request request = new Request.Builder()
                .url(url)
                .headers(hb.build())
                .post(body)
                .build();
        try (Response response = httpClient.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = DEFAULT_CLIENT.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }
}

class RetryInterceptor implements Interceptor {
    private int maxRetry;

    RetryInterceptor(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    public int getMaxRetry() {
        return maxRetry;
    }

    public void setMaxRetry(int maxRetry) {
        this.maxRetry = maxRetry;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        for (int i = 0; i < maxRetry && !response.isSuccessful(); ++i) {
            response.close();
            response = chain.proceed(request);
        }
        return response;
    }
}
