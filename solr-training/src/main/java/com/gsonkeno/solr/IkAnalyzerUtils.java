package com.gsonkeno.solr;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class IkAnalyzerUtils {

    public static List<String> analyzer(String text){
        List<String> list = new ArrayList<String>();
        try {
            //创建分词对象
            Analyzer anal = new IKAnalyzer(true);
            StringReader reader = new StringReader(text);

            //分词
            TokenStream ts = anal.tokenStream("", reader);
            CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
            ts.reset();

            //遍历分词数据
            while (ts.incrementToken()) {
                list.add(term.toString());
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

       return list;
    }
}
