# HttpPartition
    HttpPartition是隔离第三方网络框架和主题业务代码的库。
    Android应用开发中总是要集成一些第三方的访问网络请求的框架，第三方的网络框架有很多，如Volley、Okhttp、Retrofit等等，可是更换网络框架造成代码大量修改也是个体力活，如果以后又推出了更强的框架是不是又要修改呢？我很喜欢Retrofit的调用方式，代码比较简洁，于是参考Retrofit手写了一个用来隔离第三方网络框架和主体业务代码的隔离库，使用方式和Retrofit差不多，自己也拓展了一些东西，如每个请求可以设置一个私有的convert用来解析转化比较特殊的json数据，返回你想要的那部分信息即可。
    使用起来十分简单，详细请看“app”module的使用。
    目前基本网络请求流程已实现，请求完回调可以直接更新UI，但很多东西仍需完善。最近一段时间比较忙，有时间了再继续补充。
	
