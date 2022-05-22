package com.cx.elastic;

import com.alibaba.fastjson.JSONObject;
import com.cx.elastic.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 修改文档
 * @createTime 2022-05-22 08:45:45
 */
public class ESTest_Doc_Update {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("user").id("1001");
        updateRequest.doc(XContentType.JSON,"sex","女的");
        client.update(updateRequest,RequestOptions.DEFAULT);
        client.close();
    }
}
