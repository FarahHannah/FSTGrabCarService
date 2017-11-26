
package com.farahhannah.fstgrabcarservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnUserRegister1, btnDriverRegister1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnUserRegister1 = (Button) findViewById(R.id.btnUserRegister1);
        btnDriverRegister1 = (Button) findViewById(R.id.btnDriverRegister1);



        btnUserRegister1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

       btnDriverRegister1.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, SignupActivity.class);
               startActivity(intent);
           }
       });




    }
}





