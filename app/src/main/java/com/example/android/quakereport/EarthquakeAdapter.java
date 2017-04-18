package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *  A EarthquakeAdapter knows how to create a list of item layout for each earthquake
 *  in the data source
 *
 *  These list item layout will be provided to an adapter view like ListView
 *  to be displayed to the user.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     *  Contruct a new EarthquakeAdapter
     * @param context
     * @param earthquakes
     */
    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView  = convertView;
        //check if we can use a recycle view
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        // find the earthquake of the given position in the list
        Earthquake currentEarthquake =  getItem(position);

        // assign the location of the current earthquake to String originalLocation
        String originalLocation = currentEarthquake.getmLocation();

        //declared primaryLocation variable
        String primaryLocation;

        //declared locationOffset variable
        String locationOffset;

        if(originalLocation.contains(LOCATION_SEPARATOR)){
            String[] parts  = originalLocation.split(LOCATION_SEPARATOR);
            primaryLocation = parts[1];
            locationOffset = parts[0] + LOCATION_SEPARATOR;
        }else{
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        //find the TextView with the view ID of primaryLocation
        TextView primeLocationView  =  (TextView) listItemView.findViewById(R.id.primary_location);

        //set the text to the textview
        primeLocationView.setText(primaryLocation);

        //find the TextView with the view ID of primaryLocation
        TextView locationOffsetView  =  (TextView) listItemView.findViewById(R.id.location_offset);

        //set the text to the textview
        locationOffsetView.setText(locationOffset);


        //find the TextView with the view ID magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in the TextView
        // Create a new mag object from the magnitude of the earthquake
        DecimalFormat decimalFormat  = new DecimalFormat("0.0");

        // convert to string the formated double
        String decimalMagnitude = decimalFormat.format(currentEarthquake.getmMagnitude());

        //set to the textview the formated valie of magnitude
        magnitude.setText(decimalMagnitude);


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable gradientDrawable = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getmMagnitude());

        // Set the color on the magnitude circle
        gradientDrawable.setColor(magnitudeColor);


        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        // find the TextView with the view ID date
        TextView date  = (TextView) listItemView.findViewById(R.id.date);

        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate  = formatDate(dateObject);

        //set the date to the TextView date
        date.setText(formattedDate);

        //find the TextView with the view ID time
        TextView time = (TextView) listItemView.findViewById(R.id.time);

        // format the time string (i.e. "4:30PM")
        String formattedTime  = formatTime(dateObject);

        // set the formatted time to the TextView time
        time.setText(formattedTime);


        // return the listItemView that is showing the appropriate data
        return listItemView;
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("h:mm a");
        return simpleDateFormat.format(dateObject);
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("MMM dd, yyyy");
        return simpleDateFormat.format(dateObject);

    }

    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
