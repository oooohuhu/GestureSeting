package com.wangy.wiperswitch.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xhb on 2016/9/14.
 */
public class StringUtils {
        public StringUtils() {
        }

        public static boolean isEmpty(String str) {
            return str == null || str.length() == 0;
        }

        public static boolean equals(String str1, String str2) {
            return str1 == null?str2 == null:str1.equals(str2);
        }

        public static boolean equalsIgnoreCase(String str1, String str2) {
            return str1 == null?str2 == null:str1.equalsIgnoreCase(str2);
        }

        public static boolean gbk(String str) {
            int count = 0;
            String regEx = "[\\u4e00-\\u9fa5]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);

            while(m.find()) {
                for(int i = 0; i <= m.groupCount(); ++i) {
                    ++count;
                }
            }

            if(count > 0) {
                return true;
            } else {
                return false;
            }
        }
    }


