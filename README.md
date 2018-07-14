# Californium Observer Demo

分为两个部分，server和client，使用了Californium的观察者设计模式。

## 服务器

运行Server类的主函数即可启动服务端，这个服务器中包含一个可观察资源（/obs），每5秒推送一次更新（内容为当前系统时间），所有观察该资源（也就是已经与服务器建立连接）的客户端可以收到一个响应。

## 客户端

使用observe方法与服务器建立一个连接，接收服务器的定时推送。

## 相关文档

* 观察者设计模式 http://blog.sina.com.cn/s/blog_5c2e98bf0101dc45.html

* CoAP测试服务器 wsncoap.org 源码中可观察资源的实现方式 https://github.com/xukai871105/wsncoap_org_plugtest/blob/master/plugtest-server/src/org/wsncoap/embedded/resources/Observe.java

