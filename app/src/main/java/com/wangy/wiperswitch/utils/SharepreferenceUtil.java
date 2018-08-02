package com.wangy.wiperswitch.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by xhb on 2016/9/18.
 */
public class SharepreferenceUtil {
        private static final String   name="cogi";
        public static  boolean getboolean(Context con,String key,boolean defaultValues){
            SharedPreferences sp=con.getSharedPreferences(name
                    ,Context.MODE_PRIVATE);
            return sp.getBoolean(key, defaultValues);
        }

        public static void putboolean(Context con,String key,boolean values){
            SharedPreferences sp=con.getSharedPreferences(name,Context.MODE_PRIVATE);
            sp.edit().putBoolean(key, values).commit();
        }

        public static  String getstring(Context con,String key,String defaultValues){
            SharedPreferences sp=con.getSharedPreferences(name
                    ,Context.MODE_PRIVATE);
            return sp.getString(key, defaultValues);
        }

        public static void setstring(Context con,String key,String values){
            SharedPreferences sp=con.getSharedPreferences(name,Context.MODE_PRIVATE);
            sp.edit().putString(key, values).commit();
        }
    }

