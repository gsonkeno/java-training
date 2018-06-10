package com.gsonkeno.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ) throws IOException {
        //大码女装
        String url = "https://www.vvic.com/gz/search/index.html?q=%E5%A4%A7%E7%A0%81%E5%A5%B3%E8%A3%85&merge=1";
       //String url = "https://blog.csdn.net/river_continent/article/details/74177781";
        Document doc = Jsoup.connect(url).get();
//        Element goodsListElem = doc.getElementsByClass("goods-list").get(0);
//        Elements lis = goodsListElem.getElementsByTag("li");
//
//        for (Element li : lis) {
//            Elements pic = li.getElementsByClass("pic");
//            Element picTarget = pic.select("a[vda]").get(0);
//            String href = picTarget.attr("href");
//            System.out.println(href);
//        }

        Map<String,Integer> shopNameItemsCountMap = new HashMap<>();
        //处理的是第一页置顶广告以及一般商品的统计(不包含档口广告)
        Elements elements = doc.select(".vam.pos-shop-name");


        for (Element element : elements) {
            String shopName = element.attr("title").trim();
            String vda = element.attr("vda");
            String href = element.attr("href");
            String shopId = href.substring(href.lastIndexOf("/") + 1);
            System.out.println("店名:" + shopName + " 商店id:" + shopId +    " vda:" + vda);
            putShopNameItemCount(shopNameItemsCountMap, shopName);
        }
        
        //档口广告
        Elements shopElem = doc.select(".item.item-hot.j-item-hot");
        Elements aElem = shopElem.select("a[vda]");
        String href = aElem.attr("href");
        String shopId = href.substring(href.lastIndexOf("/") + 1);

        String shopName = shopElem.select(".shop-name").text();

        putShopNameItemCount(shopNameItemsCountMap, shopName);
        System.out.println(shopNameItemsCountMap);
    }

    private static void putShopNameItemCount(Map<String,Integer> shopNameItemsCountMap, String shopName){
        if (shopNameItemsCountMap.containsKey(shopName)){
            shopNameItemsCountMap.put(shopName, shopNameItemsCountMap.get(shopName) + 1);
        }else {
            shopNameItemsCountMap.put(shopName,1);
        }
    }
}
