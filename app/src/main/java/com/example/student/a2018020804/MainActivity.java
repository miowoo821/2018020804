package com.example.student.a2018020804;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyReceiver receiver;//新增這個剛剛創出來的廣播物件類別

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver=new MyReceiver();//新增這個剛剛創出來的廣播物件類別
    }

    public void click_regist(View v){//廣播接收器動態註冊
        IntentFilter filter=new IntentFilter();//新增IntentFilter來放
        filter.addAction(Intent.ACTION_SCREEN_ON);//填入要監聽的東西(要接收的廣播的action)
        filter.setPriority(500);
        registerReceiver(receiver,filter);
    }
    public void click_release(View v){
        unregisterReceiver(receiver);
    }
    public void click1(View v){
        Intent intent=new Intent("myaction");//填入要給Intent處理的東西
        sendBroadcast(intent);
    }


}
