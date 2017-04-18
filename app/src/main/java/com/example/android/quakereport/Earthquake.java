package com.example.android.quakereport;

/**
 * Created by My__Boo on 4/16/2017.
 */

public class Earthquake {

    /** Magnitude of the earthquake*/
    private String mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private String mDate;

    /**
     *  Construct a new earthquake object
     * @param magnitude
     * @param location
     * @param date
     */
    public Earthquake(String magnitude, String location, String date){
        mMagnitude = magnitude;
        mLocation = location;
        mDate = date;

    }

    /**
     *  return the magnitude of the earthquake
     * @return
     */
    public String getmMagnitude(){
        return  mMagnitude;
    }

    /**
     *  retutn the location of the earthquake
     * @return
     */
    public  String getmLocation(){
        return  mLocation;
    }

    /**
     *  return the date of the earthquake
     * @return
     */
    public  String getmDate(){
        return mDate;
    }
}
