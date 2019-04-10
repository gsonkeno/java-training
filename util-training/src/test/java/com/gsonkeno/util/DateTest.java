package com.gsonkeno.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class DateTest {

    @Test
    public void test() throws ParseException {
        Date date = DateUtils.parseDate("2018-10-23 100:02:03", "yyyy-MM-dd HH:mm:ss");
        //date = DateUtils.parseDateStrictly("2018-10-23 100:02:03","yyyy-MM-dd HH:mm:ss");
        System.out.println(date);

        String s = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
        System.out.println(s);
    }
}
