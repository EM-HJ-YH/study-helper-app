package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by leeem on 2018-11-17.
 */

public class MyTeamActivity extends AppCompatActivity  {


    static  ListView myteamview;
    final static String defaultUrl = "http://54.180.105.16:80/groups";

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myteam);
        new GetTeam(MyTeamActivity.this).execute();
        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button studycafe = (Button) findViewById(R.id.studycafe);

        recruitment.setOnClickListener(new MyTeamActivity.MyOnClickListener3());
        mypage.setOnClickListener(new MyTeamActivity.MyOnClickListener3());
        myteam.setOnClickListener(new MyTeamActivity.MyOnClickListener3());
        teamcalendar.setOnClickListener(new MyTeamActivity.MyOnClickListener3());
        studycafe.setOnClickListener(new MyTeamActivity.MyOnClickListener3());

        myteamview = (ListView)findViewById(R.id.myteamview);
    }


    private class MyOnClickListener3 implements View.OnClickListener {
        @SuppressLint("ResourceAsColor")
        public void onClick(View view) {
            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }if(view.getId()==R.id.mypage){
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);

            }if(view.getId()==R.id.myteam){
                Intent intent = new Intent(getApplicationContext(), MyTeamActivity.class);
                startActivity(intent);

            }if(view.getId()==R.id.teamcalendar){
                Intent intent = new Intent(getApplicationContext(), TeamCalendarActivity.class);
                startActivity(intent);
            }if(view.getId()==R.id.studycafe) {
                Intent intent = new Intent(getApplicationContext(), StudyCafeActivity.class);
                startActivity(intent);
            }



        }
    }
}
