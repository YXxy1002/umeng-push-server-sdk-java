package io.github.xy.model.request.send.ios;


import io.github.xy.model.request.send.IOSNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class IOSBroadcast extends IOSNotification {
    public IOSBroadcast() throws Exception {
        this.setPredefinedKeyValue("type", "broadcast");
    }
}
