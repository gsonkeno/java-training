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
public class SolrCloud1Test {

    private CloudSolrClient client;
    @Before
    public void initClient(){
        client = new CloudSolrClient.Builder().withZkHost("116.62.108.90:2181/sc").build();
        client.setDefaultCollection("vvic_item");
    }

    @Test
    public void testFilter() throws IOException, SolrServerException {

        SolrQuery query = new SolrQuery();
        //query.set("fq", "vcid:(20000364 OR 20000370)");
        query.setQuery("*:*");
        query.set("fq", "vcid :(20000364)");
        query.setStart(0);
        query.setRows(10);
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
