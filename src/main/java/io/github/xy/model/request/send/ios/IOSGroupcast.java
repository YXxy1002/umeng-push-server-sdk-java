package io.github.xy.model.request.send.ios;

import io.github.xy.model.request.send.IOSNotification;
import org.json.JSONObject;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class IOSGroupcast extends IOSNotification {
    public IOSGroupcast() throws Exception {
        this.setPredefinedKeyValue("type", "groupcast");
    }

    public void setFilter(JSONObject filter) throws Exception {
        setPredefinedKeyValue("filter", filter);
    }
}
