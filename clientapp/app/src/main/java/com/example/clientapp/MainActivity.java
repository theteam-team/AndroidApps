package com.example.clientapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity  {

    FirebaseAuth mAuth;


    private ProgressBar progressBar;



    Button sign_up ;
    Button log_in ;
    Button get_loc;
    EditText name;
    EditText email;
    EditText pas;
    EditText location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign_up = (Button)findViewById(R.id.sign);
        log_in = (Button)findViewById(R.id.login);
        get_loc = (Button)findViewById(R.id.get_location);

        name = (EditText)findViewById(R.id.user_name);
        email = (EditText)findViewById(R.id.emailAddress);
        pas = (EditText)findViewById(R.id.password);
        location = (EditText) findViewById(R.id.location);
        progressBar = findViewById(R.id.progressbar);
        progressBar.setVisibility(View.GONE);



        mAuth = FirebaseAuth.getInstance();




    }


    @Override
    protected void onStart() {
        if (mAuth.getCurrentUser() != null) {
            //handle the already login user
            startActivity(new Intent(MainActivity.this, navigation.class));
            finish();


        }
        super.onStart();


    }


    public  void getLocation (View view){

       // Intent i = new Intent(MainActivity.this,myLocation.class);
        //i.putExtra("message", message);
        //startActivity(i);



    }


    public  void signUp(View view){

        final String name_text = name.getText().toString().trim();
        final String email_text = email.getText().toString().trim();
        final String pas_text = pas.getText().toString().trim();
        final String location_text = pas.getText().toString().trim();


        if (name_text.isEmpty()) {
            name.setError(getString(R.string.input_error_name));
            name.requestFocus();
            return;
        }

        if (email_text.isEmpty()) {
            email.setError(getString(R.string.input_error_email));
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email_text).matches()) {
            email.setError(getString(R.string.input_error_email_invalid));
            email.requestFocus();
            return;
        }
        if (pas_text.isEmpty()) {
            pas.setError(getString(R.string.input_error_password));
            pas.requestFocus();
            return;
        }
        if (pas_text.length() < 5) {
            pas.setError(getString(R.string.input_error_password_length));
            pas.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email_text, pas_text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {

                            User user = new User(
                                    name_text,
                                    email_text,
                                    pas_text,
                                    location_text
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    progressBar.setVisibility(View.GONE);
                                    if (task.isSuccessful()) {
                                        Toast.makeText(MainActivity.this, getString(R.string.registration_success), Toast.LENGTH_LONG).show();
                                        Intent i = new Intent(MainActivity.this,navigation.class);
                                        startActivity(i);

                                    } else {

                                        //display a failure message
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }

    public void login(View view) {

        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);


    }


}
