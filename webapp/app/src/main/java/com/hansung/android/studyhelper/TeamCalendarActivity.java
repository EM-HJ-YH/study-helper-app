package com.hansung.android.studyhelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.hansung.android.studyhelper.MyTeamActivity.a2;

/**
 * Created by leeem on 2018-11-17.
 */

public class TeamCalendarActivity extends AppCompatActivity {
   // int year = 0;
   // int month=0;
   // int day=0;
    static String value=null;
    static String value2=null;
    static ListView schedulelist;
    static int gindex=0;
    final static String defaultUrl = "http://54.180.105.16:80/schedules";
    //Context mContext = TeamCalendarActivity;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamcalendar);
       // Day_data = new ArrayList<DayData>();
        new GetTeam(TeamCalendarActivity.this).execute();
        new GetSchedules(TeamCalendarActivity.this).execute();
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

        schedulelist = (ListView)findViewById(R.id.schedulelist);

        CalendarView CV = (CalendarView)findViewById(R.id.calendarView);


        CV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                final int Syear = year;
                final int Smonth = month+1;
                final int Sday = day;


                System.out.println("eunmi"+Syear +Smonth + Sday);

                AlertDialog.Builder builder = new AlertDialog.Builder(TeamCalendarActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog, null);
                builder.setView(view);
                final EditText et2 = (EditText) view.findViewById(R.id.et2);
                final EditText groupnames2 = (EditText) view.findViewById(R.id.groupnames2);
                final Button submit = (Button) view.findViewById(R.id.buttonSubmit);
                final AlertDialog dialog = builder.create();

                submit.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        //System.out.println("lal" +groupnames2.getText().toString());
                        value2 =  groupnames2.getText().toString();
                        value = et2.getText().toString();
                        //value2 =  groupnames2.getText().toString();

                        dialog.dismiss();

                        TextView schedule =(TextView) findViewById(R.id.schedule);
                        TextView groupnames = (TextView)findViewById(R.id.groupnames);
                        schedule.setText(value);
                        groupnames.setText(value2);

                        JSONObject postDataParam3 = new JSONObject();
                        try {
                            postDataParam3.put("scheduleIndex", 0);
                            postDataParam3.put("scheduleYear", String.valueOf(Syear));
                            postDataParam3.put("scheduleMonth",String.valueOf(Smonth));
                            postDataParam3.put("scheduleDay", String.valueOf(Sday));
                            postDataParam3.put("scheduleContent",value) ;
                            postDataParam3.put("groupIndex", gindex);
                            postDataParam3.put("groupName", value2);
                            postDataParam3.put("posterId", localstorage.ID);

                            MainActivity.flag = 13;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        new InsertData(TeamCalendarActivity.this).execute(postDataParam3);
                        //new GetTeamBoard(GroupBoardWriteActivity.this).execute();

                    }
                });

                dialog.show();
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
