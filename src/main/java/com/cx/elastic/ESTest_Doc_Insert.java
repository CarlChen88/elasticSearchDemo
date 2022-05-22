package com.cx.elastic;

import com.alibaba.fastjson.JSONObject;
import com.cx.elastic.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 插入文档
 * @createTime 2022-05-22 08:45:45
 */
public class ESTest_Doc_Insert {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        IndexRequest indexRequest = new IndexRequest();
        User user = new User();
        user.setName("zhangsan");
        user.setSex("男的");
        user.setAge(30);
        indexRequest.index("user").id("1001").source(JSONObject.toJSONString(user), XContentType.JSON);
        IndexResponse response = client.index(indexRequest, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = response.getResult();
        System.out.println(result);
        client.close();
    }
}
