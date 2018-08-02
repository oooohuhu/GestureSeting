package com.wangy.wiperswitch;

import android.app.Instrumentation;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_gesture;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private  void init(){
        btn_gesture = (Button)findViewById(R.id.btn_gesture);
        btn_gesture.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_gesture:{
                Intent intent=new Intent(MainActivity.this,GestureSetingActivity.class);
                startActivityForResult(intent,RESULT_OK);
//                finish();
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RESULT_OK){
            if (data!=null){
                Bundle bundle = data.getExtras();
                if (bundle!=null){
                    Boolean isOk=bundle.getBoolean("isOk");
                    if (isOk){
                        password = bundle.getString("password");
                    }else {
                        Toast.makeText(MainActivity.this,"您两次输入的手势密码不相同，设置失败！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}
