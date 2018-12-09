package com.hansung.android.studyhelper;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by leeem on 2018-12-08.
 */

public class StudyCafeActivity extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap mGoogleMap = null;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studycafe);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button recruitment = (Button) findViewById(R.id.recruitment);
        Button mypage = (Button) findViewById(R.id.mypage);
        Button myteam = (Button) findViewById(R.id.myteam);
        Button teamcalendar = (Button) findViewById(R.id.teamcalendar);
        Button studycafe = (Button) findViewById(R.id.studycafe);

        recruitment.setOnClickListener(new StudyCafeActivity.MyOnClickListener5());
        mypage.setOnClickListener(new StudyCafeActivity.MyOnClickListener5());
        myteam.setOnClickListener(new StudyCafeActivity.MyOnClickListener5());
        teamcalendar.setOnClickListener(new StudyCafeActivity.MyOnClickListener5());
        studycafe.setOnClickListener(new StudyCafeActivity.MyOnClickListener5());


    }


    boolean search =false;
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
        //makerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

            LatLng sc1 = new LatLng(37.586663, 127.013624);
            googleMap.addMarker(
                    new MarkerOptions().
                            position(sc1).
                            icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).
                            title("study cafe1"));

        LatLng sc2 = new LatLng(37.582852, 127.011716);
        googleMap.addMarker(
                new MarkerOptions().
                        position(sc2).
                        icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)).
                        title("study cafe1"));


        LatLng hansung = new LatLng(37.5817891, 127.009854);
        googleMap.addMarker(
                new MarkerOptions().
                        position(hansung).
                        title("현재 위치"));

        // move the camera
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hansung,15));



        mGoogleMap.setOnMarkerClickListener(new MyMarkerClickListener());
    }

    class MyMarkerClickListener implements GoogleMap.OnMarkerClickListener {

        @Override
        public boolean onMarkerClick(Marker marker) {
            if (marker.getTitle().equals("현재 위치")) {
                Toast.makeText(getApplicationContext(),"현재 위치 입니다.", Toast.LENGTH_SHORT).show();
            }

            else if(marker.getTitle().equals("study cafe1")){
                Toast.makeText(getApplicationContext(),"Study Cafe1에 예약합니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), ReservationActivity.class);
                startActivity(intent);

            }
            return false;
        }
    }



    private class MyOnClickListener5 implements View.OnClickListener {
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
