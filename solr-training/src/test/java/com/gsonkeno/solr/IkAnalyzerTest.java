package com.gsonkeno.solr;

import org.junit.Test;

public class IkAnalyzerTest {
    @Test
    public void testAnalyzer() {
        //ik分词器会过滤字符串中最前面特殊字符
        System.out.println(IkAnalyzerUtils.analyzer("-716-"));
        System.out.println(IkAnalyzerUtils.analyzer("+716+"));
        System.out.println(IkAnalyzerUtils.analyzer("$716$"));
        System.out.println(IkAnalyzerUtils.analyzer("^716^"));
    }
}
