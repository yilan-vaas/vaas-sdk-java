package com.vaas.example.channel;

import java.util.List;

import com.vaas.api.entity.Channel;
import com.vaas.api.VaaSClient;

public class GetChannelDemo {

    public static void main(String[] args) {
        VaaSClient client = new VaaSClient("df757f33b10f142596106bb451fa2187", 5, "tv.yilan.qianpai.app");
        // call below method if you dont set access_key and access_token in vaas-sdk-java/src/main/resources/application.properties
//        client.setAccessKey("your access_key");
//        client.setAccessToken("your access_token");
        List<Channel> data = client.channel().getChannel();
        System.out.println("channel data: ");
        for (Channel ch: data) {
            System.out.println(ch.toString());
        }
    }
}
