# 友盟推送 Upush Java SDK
基于官方demo改造，优化内存及http请求，支持自定义http配置，可用于生产环境。
### Maven Dependencies
```xml
<dependency>
    <groupId>io.github.YXxy1002</groupId>
    <artifactId>umeng-push-server-sdk-java</artifactId>
    <version>1.1.0</version>
</dependency>d
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
