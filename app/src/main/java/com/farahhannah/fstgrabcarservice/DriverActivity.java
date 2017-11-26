package com.farahhannah.fstgrabcarservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DriverActivity extends AppCompatActivity {

    // Creating button.
    Button profile, list, booking, logout ;

    // Creating FirebaseAuth.
    FirebaseAuth firebaseAuth ;

    // Creating FirebaseAuth.
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        // Assigning ID's to button.
        logout = (Button)findViewById(R.id.btnLogout);
        profile = (Button) findViewById(R.id.btnDriver1);
        booking = (Button) findViewById(R.id.btnDriver2);
        list = (Button) findViewById(R.id.btnDriver3);


        // Adding FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){

            // Finishing current Profile activity.
            finish();

            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(DriverActivity.this, SigninActivity.class);
            startActivity(intent);

            // Showing toast message.
            Toast.makeText(DriverActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }



        // Adding firebaseAuth current user info into firebaseUser object.
        firebaseUser = firebaseAuth.getCurrentUser();

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverActivity.this, WorkActivity.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DriverActivity.this, RideActivity.class);
                startActivity(intent);
            }
        });

        // Adding click listener on logout button.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Destroying login season.
                firebaseAuth.signOut();

                // Finishing current User Profile activity.
                finish();

                // Redirect to Login Activity after click on logout button.
                Intent intent = new Intent(DriverActivity.this, SigninActivity.class);
                startActivity(intent);

                // Showing toast message on logout.
                Toast.makeText(DriverActivity.this, "Logged Out Successfully.", Toast.LENGTH_LONG).show();

            }
        });


    }
}