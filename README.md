# VaaS SDK for Java

## 概述

这是 VaaS API 的 Java 版本封装开发包，是由一览云官方提供的，一般支持最新的 API 功能。

对应的 REST API 文档：<http://doc.yilan.tv/feedv2/server/api/video_flow>

## 安装

### maven 方式（推荐）
对于普通用户建议直接依赖打包好的新版 VaaS sdk 使用
在项目的 pom.xml 文件中加入如下的依赖即可使用：
```
<repositories>
    ...
    <repository>
        <id>maven-releases</id>
        <url>http://nexus.1lan.tv/repository/maven-releases</url>
    </repository>
    ...
</repositories>

<dependencies>
    ...
    <dependency>
        <groupId>com.vaas</groupId>
        <artifactId>vaas-sdk-java</artifactId>
        <version>最新版本</version>
    </dependency>
    ...
</dependencies>
```
最新的版本请在  查看

有对 sdk 内部的逻辑有改造需求的用户可以参考源码进行修改

* 采用 `git clone https://github.com/yilanyun/vaas-sdk-java.git` 命令下载源码
* 如果不使用git，请到 [github](https://github.com/yilanyun/vaas-sdk-java.git) 下载源码包并解压


## 关于 access_key / access_token

### access_key / access_token 注册申请流程

1.使用帐号/密码登录 [控制台](https://console.vaas.cn/login) 创建所属应用；

2.创建完成后，等待应用审核。一览将在3个工作日内审核完成。应用创建后分配 access key 和 access token。

### access_key / access_token 在 sdk 中的使用

- (option 1) 放在项目配置文件 example/src/main/resources/application.properties，格式为：
```
  ACCESS_KEY = "your access_key"
  ACCESS_TOKEN = "your access_token"
```

- (option 2) 在代码里显示调用方法 setAccessKey / setAccessToken，例：
```
  VaaSClient client = new VaaSClient();
  client.setAccessKey("your access_key");
  client.setAccessToken("your access_token");
```

## 使用样例

> 以下片断来自项目代码里的文件：com.vaas.example.channel.GetChannelDemo

### 服务域名设置说明

- (option 1) 放在配置文件 example/src/main/resources/application.properties，格式为：
```
  HOST_VIDEO = https://api.yilanvaas.cn
  HOST_PLAY = https://play.yilanvaas.cn
  HOST_DATA = http://data.1lan.tv
```

- (option 2) 在代码里显式调用方法 setVideoHost / setPlayHost / setDataHost，例：
```
  VaaSClient client = new VaaSClient();
  client.setVideoHost("your video_host");
  client.setPlayHost("your play_host");
  client.setDataHost("your data_host");
```

### 公共参数设置说明

- (option 1) 放在配置文件 example/src/main/resources/application.properties，格式为：
```
  PKG_NAME = your pkg_name
  PLATFORM = your platform
```

- (option 2) 在代码里显式调用方法 setPackageName / setPlatform，例：
```
  VaaSClient client = new VaaSClient();
  client.setPackageName("your pkg_name");
  client.setPlatform("your platform");
```

注：udid 参数仅支持显式调用设置
```
  client.setUdid("your udid");
```

## Examples

```
  VaaSClient client = new VaaSClient();
  client.setUdid("df757f33b10f142596106bb451fa2187");
  List<Channel> data = client.channel().getChannel(1);
  System.out.println("channel data: ");
  for (Channel ch : data) {
      System.out.println(ch.toString());
  }
```
