package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import static com.hansung.android.studyhelper.GetData.admissionyear;
import static com.hansung.android.studyhelper.localstorage.ID;
import static com.hansung.android.studyhelper.localstorage.Name;
import static com.hansung.android.studyhelper.localstorage.Major;
import static com.hansung.android.studyhelper.localstorage.AdmissionYear;

/**
 * Created by leeem on 2018-11-17.
 */

public class MypageActivity extends AppCompatActivity {
    static ListView txtview;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        //new GetData(MypageActivity.this).execute();

        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button studycafe = (Button) findViewById(R.id.studycafe);


        recruitment.setOnClickListener(new MyOnClickListener3());
        mypage.setOnClickListener(new MyOnClickListener3());
        myteam.setOnClickListener(new MyOnClickListener3());
        teamcalendar.setOnClickListener(new MyOnClickListener3());
        studycafe.setOnClickListener(new MyOnClickListener3());

        Button editinfo = (Button) findViewById(R.id.editinfo);

        editinfo.setOnClickListener(new MyOnClickListener44());
       TextView idview = (TextView) findViewById(R.id.idview);
        TextView nameview = (TextView) findViewById(R.id.nameview);
        TextView pwview = (TextView) findViewById(R.id.pwview);
        TextView majorview = (TextView) findViewById(R.id.majorview);
        TextView adview = (TextView) findViewById(R.id.adview);

        idview.setText("ID : " + localstorage.ID);
        nameview.setText("이름 : " + localstorage.Name);
        pwview.setText("비밀번호 : " +localstorage.PW);
        majorview.setText("전공 : "+localstorage.Major);
        adview.setText("학년 : "+localstorage.AdmissionYear);
    }

    private class MyOnClickListener44 implements View.OnClickListener {

        public void onClick(View view) {

        }
    }



    private class MyOnClickListener3 implements View.OnClickListener {

        public void onClick(View view) {


            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }if(view.getId()==R.id.mypage){
                //new GetData(MypageActivity.this).execute();
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
