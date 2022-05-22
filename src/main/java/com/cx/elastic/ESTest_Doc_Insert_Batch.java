package com.cx.elastic;

import com.alibaba.fastjson.JSONObject;
import com.cx.elastic.vo.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author chenxiang
 * @vesion 1.0
 * @Description 批量插入文档
 * @createTime 2022-05-22 08:45:45
 */
public class ESTest_Doc_Insert_Batch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON,"name","zhangsan","sex","男的","age",29));
        bulkRequest.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON,"name","lisi","sex","女的","age",31));
        bulkRequest.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON,"name","wuwang","sex","男的","age",30));
        BulkResponse responses = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(responses.getIngestTook());
        client.close();
    }
}
