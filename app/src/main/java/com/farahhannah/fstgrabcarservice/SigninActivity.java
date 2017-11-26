package com.farahhannah.fstgrabcarservice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigninActivity extends AppCompatActivity {

    // Creating EditText.
    EditText email, password ;

    // Creating string to hold values.
    String EmailHolder, PasswordHolder;

    // Creating buttons.
    Button Signin,Signup ;

    // Creating Boolean to hold EditText empty true false value.
    Boolean EditTextEmptyCheck;

    // Creating progress dialog.
    ProgressDialog progressDialog;

    // Creating FirebaseAuth object.
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        // Assign ID's to EditText.
        email = (EditText)findViewById(R.id.editMail);
        password = (EditText)findViewById(R.id.editPassword);

        // Assign ID's to button.
        Signin = (Button)findViewById(R.id.btnSignin);
        Signup = (Button)findViewById(R.id.btnSignup);

        progressDialog =  new ProgressDialog(SigninActivity.this);

        // Assign FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();


        // Checking if user already logged in before and not logged out properly.
        if(firebaseAuth.getCurrentUser() != null){

            // Finishing current Sign in Activity.
            finish();

            // Opening UserActivity .
            Intent intent = new Intent(SigninActivity.this, DriverActivity.class);
            startActivity(intent);
        }


        // Adding click listener to sign in button.
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling method CheckEditTextIsEmptyOrNot().
                CheckEditTextIsEmptyOrNot();

                // If  EditTextEmptyCheck == true
                if(EditTextEmptyCheck)
                {

                    // If  EditTextEmptyCheck == true then sign in function called.
                    SigninFunction();

                }
                else {

                    // If  EditTextEmptyCheck == false then toast display on screen.
                    Toast.makeText(SigninActivity.this, "Please Fill All the Fields", Toast.LENGTH_LONG).show();
                }


            }
        });

        // Adding click listener to Sign up button.
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Closing current activity.
                finish();

                // Opening the Sign up Activity .
                Intent intent = new Intent(SigninActivity.this, SignupActivity.class);
                startActivity(intent);

            }
        });
    }


    // Creating method to check EditText is empty or not.
    public void CheckEditTextIsEmptyOrNot(){

        // Getting value form Email's EditText and fill into EmailHolder string variable.
        EmailHolder = email.getText().toString().trim();

        // Getting value form Password's EditText and fill into PasswordHolder string variable.
        PasswordHolder = password.getText().toString().trim();

        // Checking Both EditText is empty or not.
        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            // If any of EditText is empty then set value as false.
            EditTextEmptyCheck = false;

        }
        else {

            // If any of EditText is empty then set value as true.
            EditTextEmptyCheck = true ;

        }

    }

    // Creating signin function.
    private void SigninFunction() {

        // Setting up message in progressDialog.
        progressDialog.setMessage("Please Wait");

        // Showing progressDialog.
        progressDialog.show();

        // Calling  signInWithEmailAndPassword function with firebase object and passing EmailHolder and PasswordHolder inside it.
        firebaseAuth.signInWithEmailAndPassword(EmailHolder, PasswordHolder)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If task done Successful.
                        if(task.isSuccessful()){

                            // Hiding the progress dialog.
                            progressDialog.dismiss();

                            // Closing the current Sign in Activity.
                            finish();


                            // Opening the UserActivity.
                            Intent intent = new Intent(SigninActivity.this, DriverActivity.class);
                            startActivity(intent);
                        }
                        else {

                            // Hiding the progress dialog.
                            progressDialog.dismiss();

                            // Showing toast message when email or password not found in Firebase Online database.
                            Toast.makeText(SigninActivity.this, "Email or Password Not found, Please Try Again", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

}
