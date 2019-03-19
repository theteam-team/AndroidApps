package com.example.clientapp;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.DialogInterface;
import android.content.Context;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class client_1 extends AppCompatActivity {


    /*
       TextView greenValue = (TextView) findViewById(R.id.text_green);
       TextView orangeValue = (TextView) findViewById(R.id.text_orange);
       TextView yellowValue = (TextView) findViewById(R.id.text_yellow);
  */
    static int code_scan = 102;
    public int RED_VALUE = 1;
    public int GREEN_VALUE = 1;
    public int ORANGE_VALUE = 1;
    public int YELLOW_VALUE = 1;
    public int location1 = 2132565;
    public int location2 = 9823218;
    public String name = "Muhammad";


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mMessageDatabaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mMessageDatabaseReference = mFirebaseDatabase.getReference().child("new");

    }

    public void order(View view) {

        //design the shape of the message of the order
        final String message  = "Red number = " + RED_VALUE +"\n" + "Green number = " + GREEN_VALUE + "\n" +
                "Orange number = " + ORANGE_VALUE +"\n" + "Yellow number = " + YELLOW_VALUE;

        // set dialog message
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Are you sure to order : ");
        alertDialogBuilder.setMessage(message).setCancelable(false).setPositiveButton("Yes"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // if the yes button is clicked , start the new activity
                        /*

                        */
                        order order = new order(name,RED_VALUE,GREEN_VALUE,ORANGE_VALUE,YELLOW_VALUE,location1,location2);
                        mMessageDatabaseReference.push().setValue(order);

                        Intent i = new Intent(client_1.this,qr.class);
                        i.putExtra("message", message);
                        startActivity(i);
                    /*
                        Intent resultIntent = new Intent();
                        // TODO Add extras or a data URI to this intent as appropriate.
                        resultIntent.putExtra("order", message);
                        setResult(Activity.RESULT_OK, resultIntent);
                        finish();
                    */
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if the no button is clicked ,  close the dialog message and do no thing
                        dialog.cancel();
                    }
                });

        // create alert message
        AlertDialog alertDialog = alertDialogBuilder.create();


        // show it
        alertDialog.show();

    }




    public void incrementRed(View view) {
        TextView redValue = (TextView) findViewById(R.id.text_red);
        int value = Integer.parseInt(redValue.getText().toString());
        value++;
        if(value > 10){
            value =10;
        }
        RED_VALUE = value;
        redValue.setText(""+value);
    }


    public void incrementGreen(View view) {
        TextView greenValue = (TextView) findViewById(R.id.text_green);
        int value = Integer.parseInt(greenValue.getText().toString());
        value++;
        if(value > 10){
            value =10;
        }
        GREEN_VALUE = value;
        greenValue.setText(""+value);
    }


    public void incrementOrange(View view) {
        TextView orangeValue = (TextView) findViewById(R.id.text_orange);
        int value = Integer.parseInt(orangeValue .getText().toString());
        value++;
        if(value > 10){
            value =10;
        }
        ORANGE_VALUE = value;
        orangeValue .setText(""+value);
    }


    public void incrementYellow(View view) {
        TextView yellowValue = (TextView) findViewById(R.id.text_yellow);
        int value = Integer.parseInt(yellowValue.getText().toString());
        value++;
        if(value > 10){
            value =10;
        }
        YELLOW_VALUE = value;
        yellowValue.setText(""+value);
    }






    public void decrementRed(View view) {
        TextView redValue = (TextView) findViewById(R.id.text_red);
        int value = Integer.parseInt(redValue.getText().toString());
        value--;
        if(value < 0){
            value =0;
        }
        RED_VALUE = value;
        redValue.setText("" + value);
    }

    public void decrementGreen(View view) {
        TextView greenValue = (TextView) findViewById(R.id.text_green);
        int value = Integer.parseInt(greenValue.getText().toString());
        value--;
        if(value < 0){
            value =0;
        }
        GREEN_VALUE = value;
        greenValue.setText("" + value);
    }
    public void decrementOrange(View view) {
        TextView orangeValue = (TextView) findViewById(R.id.text_orange);
        int value = Integer.parseInt(orangeValue.getText().toString());
        value--;
        if(value < 0){
            value =0;
        }
        ORANGE_VALUE = value;
        orangeValue.setText("" + value);
    }
    public void decremenYellow(View view) {
        TextView yellowValue = (TextView) findViewById(R.id.text_yellow);
        int value = Integer.parseInt(yellowValue .getText().toString());
        value--;
        if(value < 0){
            value =0;
        }
        YELLOW_VALUE = value;
        yellowValue .setText("" + value);
    }


}

