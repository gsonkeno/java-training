package com.gsonkeno;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) throws DocumentException {
        String text = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><response><result><errmsg>Success.</errmsg><code>0</code></result><algorithmResults><algorithmResult><result><errmsg>Success</errmsg><code>0</code></result><alrogithmCode>0104000100</alrogithmCode><peoples><people><bornTime>2013-03-09</bornTime><creatTime>1520564700974</creatTime><credentialNO>422533199307092871</credentialNO><credentialType>0</credentialType><description>{\"PIC\":\"http://172.16.58.249:8088/g1/M00/00000000/00000002/rBA6-VqiYx2AIabxAAHVqAUP-z4436.JPG\",\"ARCHIVE_PRIMARY_KEY\":289348893978676736}</description><domicile>110101</domicile><gender>1</gender><id>5aa1f9dc1860c61315012c3f</id><libraryId>5aa12ef51860c651a082f983</libraryId><name>&#38472;&#26195;&#29831;</name><pictures><picture><featureList><algorithmCode>0104000100</algorithmCode><faceState>0</faceState><featureId>439050775398309398</featureId><similarity>98</similarity></featureList><featureList><algorithmCode>0404000100</algorithmCode><faceState>0</faceState><featureId>938950334036434178</featureId></featureList><fileId>5aa1f9dd1860c6e96ab4e92b</fileId></picture></pictures><presentPlace>120101</presentPlace></people></peoples><total>1</total></algorithmResult><algorithmResult><result><errmsg>Success</errmsg><code>0</code></result><alrogithmCode>0404000100</alrogithmCode><peoples><people><bornTime>2013-03-09</bornTime><creatTime>1520564700974</creatTime><credentialNO>422533199307092871</credentialNO><credentialType>0</credentialType><description>{\"PIC\":\"http://172.16.58.249:8088/g1/M00/00000000/00000002/rBA6-VqiYx2AIabxAAHVqAUP-z4436.JPG\",\"ARCHIVE_PRIMARY_KEY\":289348893978676736}</description><domicile>110101</domicile><gender>1</gender><id>5aa1f9dc1860c61315012c3f</id><libraryId>5aa12ef51860c651a082f983</libraryId><name>&#38472;&#26195;&#29831;</name><pictures><picture><featureList><algorithmCode>0104000100</algorithmCode><faceState>0</faceState><featureId>439050775398309398</featureId></featureList><featureList><algorithmCode>0404000100</algorithmCode><faceState>0</faceState><featureId>938950334036434178</featureId><similarity>96</similarity></featureList><fileId>5aa1f9dd1860c6e96ab4e92b</fileId></picture></pictures><presentPlace>120101</presentPlace></people></peoples><total>1</total></algorithmResult></algorithmResults></response>";
        Document doc = DocumentHelper.parseText(text);

        Element root = doc.getRootElement();

        Element algorithmResultsElem = root.element("algorithmResults");

        List<Element> algorithmResultElemList = algorithmResultsElem.elements();


        for (Element algorithmResultElem : algorithmResultElemList) {
            long algorithmResultElemCode = Long.valueOf(algorithmResultElem.element("result").element("code").getText());

            List<Map<String, Object>> personList = new ArrayList<Map<String, Object>>();
            if (algorithmResultElemCode == 0) {
                String alrogithmCode = algorithmResultElem.element("alrogithmCode").getText();
                List<Element> peoplesList = algorithmResultElem.element("peoples").elements();

                for (Element aPeople : peoplesList) {

                    if (aPeople.element("pictures") != null) {
                        List<Element> pictureInfos = aPeople.element("pictures").elements();// 人员图片Id，最多5张
                        for (Element picture : pictureInfos) {
                            if (picture != null) {
                                List<Element> featureListElems = picture.elements();

                                for (Element featureElem : featureListElems) {

                                    System.out.println(featureElem.asXML());


                                    if (featureElem.element("algorithmCode") != null){
                                        System.out.println(featureElem.element("algorithmCode").getText());
                                       // System.out.println(featureElem.element("similarity").getText());
                                    }

                                    System.out.println();
//                                    String algorithmCode = featureElem.element("algorithmCode").getText();
//                                    if (algorithmCode.equals(alrogithmCode)) {
//                                        String similarity = featureElem.element("similarity").getText();
//                                    }
                                }

                            }
                        }
                    }
                }

            }
        }
    }
}
