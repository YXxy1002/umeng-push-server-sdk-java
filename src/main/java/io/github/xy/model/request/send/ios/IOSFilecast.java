package io.github.xy.model.request.send.ios;


import io.github.xy.model.request.send.IOSNotification;

/**
 * @author xy
 * @since 2021-12-4 14:47:20
 */
public class IOSFilecast extends IOSNotification {
    public IOSFilecast() throws Exception {
        this.setPredefinedKeyValue("type", "filecast");
    }

    public void setFileId(String fileId) throws Exception {
        setPredefinedKeyValue("file_id", fileId);
    }
}
