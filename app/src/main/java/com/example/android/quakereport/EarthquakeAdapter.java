package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 *  A EarthquakeAdapter knows how to create a list of item layout for each earthquake
 *  in the data source
 *
 *  These list item layout will be provided to an adapter view like ListView
 *  to be displayed to the user.
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

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

        //find the TextView with the view ID magnitude
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in the TextView
        magnitude.setText(currentEarthquake.getmMagnitude());

        // find the Textview with the view ID location
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        // Display the location of the current earthquake in the TextView
        location.setText(currentEarthquake.getmLocation());

        // find the TextView with the view ID date
        TextView date  = (TextView) listItemView.findViewById(R.id.date);
        //Display the date of the current earthquake in the TextView
        date.setText(currentEarthquake.getmDate());


        // return the listItemView that is showing the appropriate data
        return listItemView;
    }
}
