package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tosignin = (TextView) findViewById(R.id.tosignin);
        tosignin.setOnClickListener(new MyOnClickListener1());

        TextView tosignup = (TextView) findViewById(R.id.tosignup);
        tosignup.setOnClickListener(new MyOnClickListener2());

        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button chatting = (Button) findViewById(R.id.chatting);




    }

    private class MyOnClickListener1 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "로그인 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_signin);
        }
    }

    private class MyOnClickListener2 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "회원가입 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_register);
        }
    }

    private class MyOnClickListener3 implements View.OnClickListener {
        @SuppressLint("ResourceAsColor")
        public void onClick(View view) {
            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                view.setBackgroundColor(R.color.white);  //layout의 배경을 R.color.red에서 지정한 컬러로 변경
            }else if(view.getId()==R.id.mypage){
                view.setBackgroundResource(R.color.white);
            }else if(view.getId()==R.id.myteam){
                view.setBackgroundResource(R.color.white);
            }else if(view.getId()==R.id.teamcalendar){
                view.setBackgroundResource(R.color.white);
            }else if(view.getId()==R.id.chatting) {
                view.setBackgroundResource(R.color.white);
            }



        }
    }


}
