package com.gsonkeno.solr;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.NamedList;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by gaosong on 2018-05-22
 */
public class SolrCloudTest {

    private CloudSolrClient client;
    @Before
    public void initClient(){
        client = new CloudSolrClient.Builder().withZkHost("127.0.0.1:2181/rc").build();
        client.setDefaultCollection("item_collection");
    }

    public static void main(String[] args) throws IOException, SolrServerException {
        CloudSolrClient cloudSolrClient= new CloudSolrClient.Builder().withZkHost("127.0.0.1:2181/rc").build();
        cloudSolrClient.setDefaultCollection("item_collection");
        SolrQuery query = new SolrQuery();
        query.setQuery("*:*"); //搜索
        QueryResponse response = cloudSolrClient.query(query);

        System.out.println(response.toString() + "\n");

        SolrDocumentList docs = response.getResults();
        NamedList<Object> header = response.getHeader();
        System.out.println("文档个数：" + docs.getNumFound());
        System.out.println("查询时间：" + response.getQTime());
        for (SolrDocument doc : docs) {
            System.out.println(doc.getFieldValueMap());
            //System.out.println("id: " + doc.getFieldValue("id") + "      content: " + doc.getFieldValue("content_test"));
        }

        System.out.println(header.get("params"));
    }

    @Test
    public void testOr() throws IOException, SolrServerException {

        SolrQuery query = new SolrQuery();
        query.setQuery("type:1 OR type:2"); //搜索
        query.set("q.op", "AND");
        QueryResponse response = client.query(query);

        System.out.println(response.toString() + "\n");

        SolrDocumentList docs = response.getResults();
        NamedList<Object> header = response.getHeader();
        for (SolrDocument doc : docs) {
            System.out.println(doc.getFieldValueMap());
        }
        System.out.println(header.get("params"));
    }
}
