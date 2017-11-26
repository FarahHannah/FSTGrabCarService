package com.farahhannah.fstgrabcarservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    // Creating EditText .
    EditText email, password;

    // Creating button.
    Button Signup, Signin;

    // Creating string to hold email and password .
    String EmailHolder, PasswordHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Creating FirebaseAuth object.
    FirebaseAuth firebaseAuth;

    // Creating Boolean variable that holds EditText is empty or not status.
    Boolean EditTextStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Assigning layout email ID and Password ID.
        email = (EditText) findViewById(R.id.editMail);
        password = (EditText) findViewById(R.id.editPassword);

        // Assign button layout ID.
        Signup = (Button) findViewById(R.id.btnSignup);
        Signin = (Button) findViewById(R.id.btnSignin);

        // Creating object instance.
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(SignupActivity.this);

        // Adding click listener to Signup Button.
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling method to check EditText is empty or no status.
                CheckEditTextIsEmptyOrNot();

                // If EditText is true then this block with execute.
                if (EditTextStatus) {

                    // If EditText is not empty than DriverRegistrationFunction method will call.
                    DriverRegistrationFunction();

                }
                // If EditText is false then this block with execute.
                else {

                    Toast.makeText(SignupActivity.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });

        // Adding click listener to ButtonGoToLoginActivity button.
        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Opening the Login Activity using Intent.
                Intent intent = new Intent(SignupActivity.this, SigninActivity.class);
                startActivity(intent);

            }
        });


    }

    // Creating DriverRegistrationFunction
    private void DriverRegistrationFunction() {

        // Showing progress dialog at driver registration time.
        progressDialog.setMessage("Please Wait, We are Registering Your Data on Server");
        progressDialog.show();

        // Creating createDriverWithEmailAndPassword method and pass email and password inside it.
        firebaseAuth.createUserWithEmailAndPassword(EmailHolder, PasswordHolder).
                addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // Checking if driver is registered successfully.
                        if (task.isSuccessful()) {

                            // If driver registered successfully then show this toast message.
                            Toast.makeText(SignupActivity.this, "User Registration Successfully", Toast.LENGTH_LONG).show();
                            Intent s = new Intent(getApplicationContext(), SigninActivity.class);
                            startActivity(s);

                        } else {

                            // If something goes wrong.
                            Toast.makeText(SignupActivity.this, "Something Went Wrong.", Toast.LENGTH_LONG).show();
                        }

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                    }
                });

    }

    public void CheckEditTextIsEmptyOrNot() {

        // Getting name and email from EditText and save into string variables.
        EmailHolder = email.getText().toString().trim();
        PasswordHolder = password.getText().toString().trim();

        EditTextStatus = !(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder));

    }
}
