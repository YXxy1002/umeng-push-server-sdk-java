package io.github.xy;

import io.github.xy.client.PushClient;
import io.github.xy.model.request.StatusRequest;
import io.github.xy.model.request.send.AndroidNotification;
import io.github.xy.model.request.send.android.AndroidUnicast;
import io.github.xy.model.response.SendResponse;
import io.github.xy.model.response.StatusResponse;
import io.github.xy.util.GsonUtil;
import org.junit.Test;

/**
 * @author xy
 * @since 2021/7/30 16:17
 */
public class PushTest {

    @Test
    public void send() throws Exception {
        AndroidUnicast unicast = new AndroidUnicast();
        unicast.setDeviceToken("111");
        unicast.setTitle("中文的title");
        unicast.setText("Android unicast text");
        unicast.goAppAfterOpen();
        unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
        unicast.setTestMode();
        unicast.setExtraField("test", "helloworld");
        unicast.setChannelActivity("com.xxx");
        unicast.setChannelProperties("test_channel_id");
        SendResponse send = PushClient.getInstance("111", "111").basic.send(unicast);
        System.out.println(GsonUtil.toJson(send, SendResponse.class));
    }

    @Test
    public void status() throws Exception {
        StatusRequest statusRequest = new StatusRequest();
        statusRequest.setTaskId("uuel83i163875941165901");
        StatusResponse rixjyxdpnyp9r3bvsqfl8gh2xlghcmth = PushClient.getInstance("111", "111").basic.status(statusRequest);
        System.out.println(GsonUtil.toJson(rixjyxdpnyp9r3bvsqfl8gh2xlghcmth, StatusResponse.class));
    }

}
