package com.hansung.android.studyhelper;

/**
 * Created by leeem on 2018-12-17.
 */

public class Cafe {


    int cafeIndex;
    double latitude;
    double longitude;
    String cafeName;
    String cafePhone;

    public Cafe(int cafeIndex, double latitude,  double longitude, String cafeName, String cafePhone){
        this.cafeIndex=cafeIndex;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cafeName = cafeName;
        this.cafePhone = cafePhone;
    }

    public String toString() {
        return String.format("cafeIndex = %d \n latitude = %d \n longitude = %d \n cafeName = %s \n cafePhone = %s",cafeIndex, latitude,longitude,cafeName, cafePhone);
    }
}
