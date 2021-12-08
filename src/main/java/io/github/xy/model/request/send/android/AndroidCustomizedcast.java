package io.github.xy.model.request.send.android;


import io.github.xy.model.request.send.AndroidNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class AndroidCustomizedcast extends AndroidNotification {
    public AndroidCustomizedcast() throws Exception {
        this.setPredefinedKeyValue("type", "customizedcast");
    }

    public void setAlias(String alias, String aliasType) throws Exception {
        setPredefinedKeyValue("alias", alias);
        setPredefinedKeyValue("alias_type", aliasType);
    }

    public void setFileId(String fileId, String aliasType) throws Exception {
        setPredefinedKeyValue("file_id", fileId);
        setPredefinedKeyValue("alias_type", aliasType);
    }

}
