package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leeem on 2018-11-17.
 */

public class TeamCalendarActivity extends AppCompatActivity {




    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamcalendar);


        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button chatting = (Button) findViewById(R.id.chatting);

        recruitment.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        mypage.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        myteam.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        teamcalendar.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        chatting.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());


    }


    private class MyOnClickListener3 implements View.OnClickListener {
        @SuppressLint("ResourceAsColor")
        public void onClick(View view) {
            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                setContentView(R.layout.activity_main);
            }else if(view.getId()==R.id.mypage){
                setContentView(R.layout.activity_mypage);

            }else if(view.getId()==R.id.myteam){
                setContentView(R.layout.activity_myteam);

            }else if(view.getId()==R.id.teamcalendar){
                setContentView(R.layout.activity_teamcalendar);

            }else if(view.getId()==R.id.chatting) {

            }



        }
    }
}
