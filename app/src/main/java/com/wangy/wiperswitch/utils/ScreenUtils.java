package com.wangy.wiperswitch.utils;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by xhb on 2016/9/14.
 */
public class ScreenUtils {
    @SuppressWarnings("deprecation")
    public static int[] getScreenDispaly(Context context){
        WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        int width=wm.getDefaultDisplay().getWidth();//手机屏幕的宽度
        int height=wm.getDefaultDisplay().getHeight();//手机屏幕的高度
        int result[] = {width,height};
        return result;

    }
}
