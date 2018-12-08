package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by leeem on 2018-11-17.
 */

public class TeamCalendarActivity extends AppCompatActivity {
   // int year = 0;
   // int month=0;
   // int day=0;
    String value="";



    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamcalendar);
       // Day_data = new ArrayList<DayData>();


        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button studycafe = (Button) findViewById(R.id.studycafe);

        recruitment.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        mypage.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        myteam.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        teamcalendar.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());
        studycafe.setOnClickListener(new TeamCalendarActivity.MyOnClickListener3());

        CalendarView CV = (CalendarView)findViewById(R.id.calendarView);


        CV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                int Syear = year;
                int Smonth = month+1;
                int Sday = day;

                System.out.println("eunmi"+Syear +Smonth + Sday);
                AlertDialog.Builder ad = new AlertDialog.Builder(TeamCalendarActivity.this);
                ad.setTitle("Schedule");
                final EditText et = new EditText(TeamCalendarActivity.this);
                ad.setView(et);
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Log.v(TAG,"No Btn Click");
                        dialog.dismiss();     //닫기
                        // Event
                    }
                });
                ad.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        value = et.getText().toString();

                        dialog.dismiss();

                        TextView schedule =(TextView) findViewById(R.id.schedule);
                        schedule.setText(value);
                    }
                });

                ad.show();



            }
        });
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
            } if(view.getId()==R.id.studycafe) {
                Intent intent = new Intent(getApplicationContext(), StudyCafeActivity.class);
                startActivity(intent);
            }



        }
    }
}
