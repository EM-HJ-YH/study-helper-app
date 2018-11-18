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

    Button recruitment = (Button) findViewById(R.id.recruitment);
    Button mypage = (Button) findViewById(R.id.mypage);
    Button myteam = (Button) findViewById(R.id.myteam);
    Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
    Button chatting = (Button) findViewById(R.id.chatting);

    TextView a1 = (TextView) findViewById(R.id.a1);
    TextView a2 = (TextView) findViewById(R.id.a2);
    TextView a3 = (TextView) findViewById(R.id.a3);
    TextView a4 = (TextView) findViewById(R.id.a4);

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tosignin = (TextView) findViewById(R.id.tosignin);
        tosignin.setOnClickListener(new MyOnClickListener1());

        TextView tosignup = (TextView) findViewById(R.id.tosignup);
        tosignup.setOnClickListener(new MyOnClickListener2());

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new MyOnClickListener4());
        recruitment.setOnClickListener(new MyOnClickListener3());
        mypage.setOnClickListener(new MyOnClickListener3());
        myteam.setOnClickListener(new MyOnClickListener3());
        teamcalendar.setOnClickListener(new MyOnClickListener3());
        chatting.setOnClickListener(new MyOnClickListener3());

        a1.setOnClickListener(new MyOnClickListener5());


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

    private class MyOnClickListener4 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "모집 글 등록 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_write);
        }
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
    private class MyOnClickListener5 implements View.OnClickListener {
        public void onClick(View view) {
            if(view.getId()==R.id.a1){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                setContentView(R.layout.activity_detail);
            }else if(view.getId()==R.id.a2){
                setContentView(R.layout.activity_detail);

            }else if(view.getId()==R.id.a3){
                setContentView(R.layout.activity_detail);

            }else if(view.getId()==R.id.a4){
                setContentView(R.layout.activity_detail);

            }



        }
    }


}
