package io.github.xy.model.request.send.android;


import io.github.xy.model.request.send.AndroidNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class AndroidUnicast extends AndroidNotification {
    public AndroidUnicast() throws Exception {
        this.setPredefinedKeyValue("type", "unicast");
    }

    public void setDeviceToken(String token) throws Exception {
        setPredefinedKeyValue("device_tokens", token);
    }

}