package com.farahhannah.fstgrabcarservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    // Creating button.
    Button list, booking, logout ;

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
        booking = (Button) findViewById(R.id.btnBook);
        list = (Button) findViewById(R.id.btnList);


        // Adding FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){

            // Finishing current Profile activity.
            finish();

            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(UserActivity.this, LoginActivity.class);
            startActivity(intent);

            // Showing toast message.
            Toast.makeText(UserActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }



        // Adding firebaseAuth current user info into firebaseUser object.
        firebaseUser = firebaseAuth.getCurrentUser();

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, ListActivity.class);
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
                Intent intent = new Intent(UserActivity.this, LoginActivity.class);
                startActivity(intent);

                // Showing toast message on logout.
                Toast.makeText(UserActivity.this, "Logged Out Successfully.", Toast.LENGTH_LONG).show();

            }
        });


    }
}