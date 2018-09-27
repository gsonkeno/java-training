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
        client.setDefaultCollection("item_v");
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

    @Test
    public void testQueryOr() throws IOException, SolrServerException {

        SolrQuery query = new SolrQuery();
        query.setQuery("shop_name:(搜款网 AND 饺子)"); //搜索
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

    @Test
    public void testQueryAnd() throws IOException, SolrServerException {

        SolrQuery query = new SolrQuery();
        String url = "https://www.vvic.com/uploads/user/394107/WANE1461073413806284077.jpg";
        url = url.replaceAll("//", "");
        url = url.replaceAll(":", "\\:");
        System.out.println(url);
        query.setQuery("item_title:毛领毛呢外套女中长款2018韩版新款秋冬学生加厚过膝双面呢子大衣 OR img_url:" + url); //搜索
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

    @Test
    public void testReplaceAll(){
        String url = "https://www.vvic.com/uploads/user/394107/WANE1461073413806284077.jpg";
        System.out.println(url);
        url = url.replaceAll("//", "");
        url = url.replaceAll(":", "\\\\\\\\:");
        System.out.println(url);
    }
}
