package com.hansung.android.studyhelper;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import static com.hansung.android.studyhelper.GetCafeIndex.cafein;

/**
 * Created by leeem on 2018-12-10.
 */

public class ReservationActivity extends AppCompatActivity {

    final static String defaultUrl = "http://54.180.105.16:80/cafebooks";
    static int cyear;
    static int cmonth;
    static int cday;

    static int shour;
    static int smin;

    static int ehour;
    static int emin;
    static Button cafedatee;
    static Button stimee;
    static Button etimee;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        new GetCafeIndex(ReservationActivity.this).execute();
        Button cafesub = (Button)findViewById(R.id.cafesub);
        cafedatee = (Button)findViewById(R.id.cafedatee);
        stimee = (Button)findViewById(R.id.stimee);
        etimee = (Button)findViewById(R.id.etimee);

        cafesub.setOnClickListener(new MyOnClickListener11());
        cafedatee.setOnClickListener(new MyOnClickListener22());
        stimee.setOnClickListener(new MyOnClickListener33());
        etimee.setOnClickListener(new MyOnClickListener44());


    }




    private class MyOnClickListener22 implements View.OnClickListener {
        public void onClick(View view) {

            //noinspection deprecation
            showDialog(0);
        }
    }
    @SuppressWarnings("deprecation")
    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        if(id==0) {
            return new DatePickerDialog(this, Dlistener, 2018, 11, 18);
        }

        else if(id==1) {
            return new TimePickerDialog(this, Slistener, 12, 00,true);
        } else{
            return new TimePickerDialog(this, Elistener, 12, 00, true);
        }
    }


    private DatePickerDialog.OnDateSetListener Dlistener = new DatePickerDialog.OnDateSetListener() {

        @Override

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

            cyear = year;
            cmonth = monthOfYear+1;
            cday = dayOfMonth;
           // Toast.makeText(getApplicationContext(), year + "년" + monthOfYear+1 + "월" + dayOfMonth +"일", Toast.LENGTH_SHORT).show();
            cafedatee.setText(cyear + "년" + cmonth + "월" + cday +"일");
        }

    };


    private class MyOnClickListener33 implements View.OnClickListener {
        public void onClick(View view) {
            //noinspection deprecation
            showDialog(1);
        }
    }
    private TimePickerDialog.OnTimeSetListener Slistener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            shour = i;
            smin = i1;
            // Toast.makeText(getApplicationContext(), year + "년" + monthOfYear+1 + "월" + dayOfMonth +"일", Toast.LENGTH_SHORT).show();
            stimee.setText(shour + "시" + smin + "분");
        }

    };



    private class MyOnClickListener44 implements View.OnClickListener {
        public void onClick(View view) {
            //noinspection deprecation
            showDialog(2);
        }
    }
    private TimePickerDialog.OnTimeSetListener Elistener = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            ehour = i;
            emin = i1;
            // Toast.makeText(getApplicationContext(), year + "년" + monthOfYear+1 + "월" + dayOfMonth +"일", Toast.LENGTH_SHORT).show();
            etimee.setText(ehour + "시" + emin + "분");
        }

    };

    private class MyOnClickListener11 implements View.OnClickListener {
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),
                    "예약이 완료되었습니다.",
                    Toast.LENGTH_SHORT).show();

            JSONObject postDataParam2 = new JSONObject();
            try {
                postDataParam2.put("cafebookIndex", 0);
                postDataParam2.put("cafeIndex",cafein );
                postDataParam2.put("cafeBookUserId", localstorage.ID);
                postDataParam2.put("cafeBookDate", cyear+"-"+cmonth + "-" + cday);
                postDataParam2.put("cafeBookBeginTime", shour+":"+smin );
                postDataParam2.put("cafeBookEndTime", ehour+":"+emin );
                MainActivity.flag = 32;

            } catch (JSONException e) {
                //Log.e(TAG, "JSONEXception");
            }
            new InsertData(ReservationActivity.this).execute(postDataParam2);
            Intent intent = new Intent(getApplicationContext(), ResCheckActivity.class);
            startActivity(intent);

        }
    }

        }

