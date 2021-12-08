# umeng-push-server-sdk-java
### Maven Dependencies
```xml
To be uploaded
```
### Getting Started
```java
AndroidUnicast unicast = new AndroidUnicast();
unicast.setDeviceToken("devicetoken");
unicast.setTitle("title");
unicast.setText("text");
unicast.goAppAfterOpen();
unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
unicast.setExtraField("key", "value");
unicast.setChannelActivity("com.xxx");
unicast.setChannelProperties("channel_id");
SendResponse send = PushClient.getInstance("appKey", "appSecret").basic.send(unicast);
```
