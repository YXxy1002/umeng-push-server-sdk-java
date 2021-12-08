package io.github.xy.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class GsonUtil {

    private static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static String toJson(Object obj, Type type) {
        return gson.toJson(obj, type);
    }

    public static <T> T fromJson(String str, Class<T> cls) {
        return gson.fromJson(str, cls);
    }
}
