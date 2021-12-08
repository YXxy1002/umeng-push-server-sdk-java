package io.github.xy.model.request.send.ios;


import io.github.xy.model.request.send.IOSNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class IOSUnicast extends IOSNotification {
    public IOSUnicast() throws Exception {
        this.setPredefinedKeyValue("type", "unicast");
    }

    public void setDeviceToken(String token) throws Exception {
        setPredefinedKeyValue("device_tokens", token);
    }
}
