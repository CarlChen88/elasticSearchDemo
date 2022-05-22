package com.cx.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 连接es服务器
 * @createTime 2022-05-21 21:41:41
 */
public class ESTest_Client {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        System.out.println("ddddddddddddd");
        client.close();
    }
}
