package com.mqxu.sm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: mqxu
 * @create: 2020-11-26 11:59
 **/
public class FormatUtil {
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String formatGender(short gender) {
        if (gender == 0) {
            return "保密";
        } else if (gender == 1) {
            return "男";
        } else {
            return "女";
        }
    }
}
