package io.github.xy.model.request.send.android;


import io.github.xy.model.request.send.AndroidNotification;
import org.json.JSONObject;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class AndroidGroupcast extends AndroidNotification {
    public AndroidGroupcast() throws Exception {
        this.setPredefinedKeyValue("type", "groupcast");
    }

    public void setFilter(JSONObject filter) throws Exception {
        setPredefinedKeyValue("filter", filter);
    }
}
