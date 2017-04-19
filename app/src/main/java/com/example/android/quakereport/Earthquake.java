package com.example.android.quakereport;

/**
 * Created by My__Boo on 4/16/2017.
 */

public class Earthquake {

    /** Magnitude of the earthquake*/
    private double mMagnitude;

    /** Location of the earthquake */
    private String mLocation;

    /** Date of the earthquake */
    private long mTimeInMilliseconds;

    /** url of the earthquake */
    private String mUrl;


    /**
     *  Construct a new earthquake object
     * @param magnitude
     * @param location
     * @param timeInMilliseconds
     *
     */
    public Earthquake(Double magnitude, String location, long timeInMilliseconds, String url){
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;

    }

    /**
     *  retunt url of the earthquake
     * @return
     */
    public String getmUrl(){
        return mUrl;
    }

    /**
     *  return the magnitude of the earthquake
     * @return
     */
    public double getmMagnitude(){
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
    public  long getmTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }
}
