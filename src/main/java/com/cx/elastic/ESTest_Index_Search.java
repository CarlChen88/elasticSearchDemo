package com.cx.elastic;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 查询索引
 * @createTime 2022-05-22 08:45:45
 */
public class ESTest_Index_Search {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        //查询索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("user");
        GetIndexResponse response = client.indices().get(getIndexRequest, RequestOptions.DEFAULT);
        //响应状态
        System.out.println(response.getAliases());
        System.out.println(response.getSettings());
        client.close();
    }
}
