package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by leeem on 2018-11-17.
 */

public class MypageActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button chatting = (Button) findViewById(R.id.chatting);


        recruitment.setOnClickListener(new MyOnClickListener3());
        mypage.setOnClickListener(new MyOnClickListener3());
        myteam.setOnClickListener(new MyOnClickListener3());
        teamcalendar.setOnClickListener(new MyOnClickListener3());
        chatting.setOnClickListener(new MyOnClickListener3());


    }


    private class MyOnClickListener3 implements View.OnClickListener {

        public void onClick(View view) {


            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                setContentView(R.layout.activity_main);
            }if(view.getId()==R.id.mypage){
                setContentView(R.layout.activity_mypage);

            }if(view.getId()==R.id.myteam){
                setContentView(R.layout.activity_myteam);

            }if(view.getId()==R.id.teamcalendar){
                setContentView(R.layout.activity_teamcalendar);

            }if(view.getId()==R.id.chatting) {

            }

            ListView txtList = (ListView) findViewById(R.id.txtList);
            txtList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Adapter adapter = adapterView.getAdapter();
                    JSONObject postDataParam = new JSONObject();
                    try {
                        postDataParam.put("userName", ((Regist)adapter.getItem(i)).userName);
                        postDataParam.put("userId", ((Regist)adapter.getItem(i)).userId);
                        postDataParam.put("userPw", ((Regist)adapter.getItem(i)).userPw);
                        postDataParam.put("major", ((Regist)adapter.getItem(i)).major);
                        postDataParam.put("admissionYear", ((Regist)adapter.getItem(i)).admissionYear);
                    } catch (JSONException e) {
                        //Log.e(TAG, "JSONEXception");
                    }
                    new GetData(MypageActivity.this).execute();
                }
            });

        }
    }


}
