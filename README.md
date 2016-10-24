项目介绍：

* 根据[V2EX](https://www.v2ex.com)官方提供的API写了一个[最新话题]的简易阅读客户端。

项目概况：

* 数据流已经走通了，写这个项目的主要目的还是将最近Android开源社区上比较火的项目运动到自己的项目中，主要开始学习开源项目的使用以及设计方式。

项目总结：

* 使用RxJava和Retrofit结合向服务器请求数据以及解析返回的json数据，并且使用Gson来解析，封装成bean用集合封装。 
* 使用Recyclerview展示的数据内容。 
* 使用Fresco的Image Pipeline 模块负责从网络和本地文件系统以及资源文件系统中加载图片，为了节省空间和CPU的运算时间，它含有3级缓存设计。 
* 使用了WebView来显示讨论区中的内容，为了解决WebView中图片显示过大的问题，引入了JsGroup第三方库，将WebView中的图片与手机的屏幕自动适配。 
