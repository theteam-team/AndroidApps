package com.example.clientapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class custom_adapter extends ArrayAdapter<order> {

    private static final String LOG_TAG = custom_adapter.class.getSimpleName();


    public custom_adapter(Activity context, ArrayList<order> order){

        super(context, 0, order);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list, parent, false);
        }

        TextView nameTextView = (TextView) convertView.findViewById(R.id.name);
      //  TextView redTextView = (TextView) convertView.findViewById(R.id.red);
       // TextView orangeTextView = (TextView) convertView.findViewById(R.id.orange);
       // TextView greenTextView = (TextView) convertView.findViewById(R.id.green);
       // TextView yellowTextView = (TextView) convertView.findViewById(R.id.yellow);

        // Get the {@link AndroidFlavor} object located at this position in the list
        order current_order = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name

        assert current_order != null;
        nameTextView.setText(current_order.getName());

        // Find the TextView in the list_item.xml layout with the ID version_name

        //       redTextView.setText(current_order.getRed());

        // Find the TextView in the list_item.xml layout with the ID version_number

    //    orangeTextView.setText(current_order.getOrange());

        // Find the TextView in the list_item.xml layout with the ID version_number

     //   greenTextView.setText(current_order.getGreen());

        // Find the TextView in the list_item.xml layout with the ID version_number

       //     yellowTextView.setText(current_order.getYellow());




        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;


    }
}
