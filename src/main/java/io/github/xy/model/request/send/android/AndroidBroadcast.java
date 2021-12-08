package io.github.xy.model.request.send.android;


import io.github.xy.model.request.send.AndroidNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class AndroidBroadcast extends AndroidNotification {
    public AndroidBroadcast() throws Exception {
        this.setPredefinedKeyValue("type", "broadcast");
    }
}
