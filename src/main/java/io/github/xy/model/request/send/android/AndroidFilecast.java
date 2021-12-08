package io.github.xy.model.request.send.android;


import io.github.xy.model.request.send.AndroidNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class AndroidFilecast extends AndroidNotification {
    public AndroidFilecast() throws Exception {
        this.setPredefinedKeyValue("type", "filecast");
    }

    public void setFileId(String fileId) throws Exception {
        setPredefinedKeyValue("file_id", fileId);
    }
}