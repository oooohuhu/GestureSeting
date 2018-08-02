package com.wangy.wiperswitch;

import android.content.Context;
import android.content.Intent;
import android.gesture.Gesture;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.wangy.wiperswitch.Custom.Drawl;
import com.wangy.wiperswitch.Custom.GestureView;
import com.wangy.wiperswitch.R;
import com.wangy.wiperswitch.utils.SharepreferenceUtil;

/**
 * Created by xhb on 2016/9/13.
 */
public class GestureSetingActivity extends AppCompatActivity {

    private FrameLayout boby_layout;
    private String pass;
    private GestureView content;
    private int time=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gesture_setting_layout);
        init();
    }
    protected void init(){
        pass = "";
        boby_layout = (FrameLayout)findViewById(R.id.body_layout);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay();
        content = new GestureView(this, pass, d.getWidth(), new Drawl.GestureCallBack() {
            @Override
            public void checkedSuccess(String s) {
                if (s.length()<3){
                    Toast.makeText(GestureSetingActivity.this,"手势密码最少是3个！",Toast.LENGTH_SHORT).show();
                }else {
                    if (time==0){
                        Toast.makeText(GestureSetingActivity.this,"请再输入一次！",Toast.LENGTH_SHORT).show();
                        time++;
                        pass=s;//将第一次输入的密码与第二次输入的密码比较是否一致
                         }else {
                        if (pass.equals(s)){
                            Toast.makeText(GestureSetingActivity.this,"设置成功！手势密码为："+s,Toast.LENGTH_SHORT).show();
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("isOk",true);
                            bundle.putString("password", s);
                            Intent intent = new Intent();
                            intent.putExtras(bundle);
                            setResult(RESULT_OK, intent);
                            SharepreferenceUtil.setstring(GestureSetingActivity.this,"pass",s);
                            finish();
                        }else {
                            Bundle bundle = new Bundle();
                            bundle.putBoolean("isOk", false);
                            Intent intent = new Intent();
                            intent.putExtras(bundle);
                            setResult(RESULT_OK, intent);
                            finish();
                        }
                    }
                }
            }

            @Override
            public void checkedFail() {
                Toast.makeText(GestureSetingActivity.this,"校验失败！",Toast.LENGTH_SHORT).show();
            }
        });

        //设置手势解锁显示到哪个布局里面
        content.setParentView(boby_layout);
    }
}

