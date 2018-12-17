package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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



public class MainActivity extends AppCompatActivity {

     static int flag = 0;
    static int login=0;
    static  ListView teamview;

    static int a = 0;
    static String b= null;
    static String c= null;
    static String d= null;
    static String e= null;
    static String f= null;
    static boolean g= true;
    static String h;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetRecruiment(MainActivity.this).execute();

        setContentView(R.layout.activity_main);
        TextView tosignin = (TextView) findViewById(R.id.tosignin);
        tosignin.setOnClickListener(new MyOnClickListener1());

        TextView tosignup = (TextView) findViewById(R.id.tosignup);
        tosignup.setOnClickListener(new MyOnClickListener2());

        if(login>=3){
            tosignin.setVisibility(View.INVISIBLE);
            tosignup.setVisibility(View.INVISIBLE);

            login=4;
        }

        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button studycafe = (Button) findViewById(R.id.studycafe);


        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new MyOnClickListener4());
        recruitment.setOnClickListener(new MyOnClickListener3());
        mypage.setOnClickListener(new MyOnClickListener3());
        myteam.setOnClickListener(new MyOnClickListener3());
        teamcalendar.setOnClickListener(new MyOnClickListener3());
        studycafe.setOnClickListener(new MyOnClickListener3());


         teamview = (ListView)findViewById(R.id.teamview);
        teamview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Adapter adapter = adapterView.getAdapter();

                JSONObject postDataParam = new JSONObject();

                    a =((Write)adapter.getItem(i)).boardIndex;
                    b = ((Write)adapter.getItem(i)).boardTitle;
                    c = ((Write)adapter.getItem(i)).userId;
                    d = ((Write)adapter.getItem(i)).boardContent;
                    e = ((Write)adapter.getItem(i)).boardDate;
                    f =  String.valueOf(((Write)adapter.getItem(i)).memberCount);
                    g = ((Write)adapter.getItem(i)).isRecruiting;
                    h = ((Write) adapter.getItem(i)).members;
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(intent);

            }
        });
    }

    private class MyOnClickListener1 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "로그인 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            Intent intent2 = new Intent(getApplicationContext(), SignInActivity.class);
            startActivity(intent2);
        }
    }

    private class MyOnClickListener2 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "회원가입 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        }
    }

    private class MyOnClickListener4 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "모집 글 등록 페이지로 이동합니다.",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), WriteActivity.class);
            startActivity(intent);
        }
    }

    public class MyOnClickListener3 implements View.OnClickListener {
        @SuppressLint("ResourceAsColor")
        public void onClick(View view) {
            System.out.print(view.getId());
            if(view.getId()==R.id.recruitment){  //클릭한 버튼의 아이디가 R.id.bt_red일때
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }if(view.getId()==R.id.mypage){
                //new GetData(MainActivity.this).execute();
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



