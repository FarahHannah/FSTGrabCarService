package com.farahhannah.fstgrabcarservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BookingActivity extends AppCompatActivity {

    Spinner sp, sp1, sp2 ;

    //make string Arrary

    String places[] = {"KTM","TESCO","GIANT","AKASIA","KK1","KKSI","KKNC"};
    String number[] = {"1","2","3","4"};
    String names[] = {"Aiman","Bujibu","Jemah","Sofia"};

    //defins array adapter of string type

    ArrayAdapter<String> adapter;

    //define string variable for record

    String record= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        sp = (Spinner) findViewById(R.id.destination);
        sp1 = (Spinner) findViewById(R.id.noOfPassenger);
        sp2 = (Spinner) findViewById(R.id.selectDriver);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, places);

        //set adapter to spinner

        sp.setAdapter(adapter);

        //set spinner method

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {

                    case 0:

                        record = "KTM";

                        break;

                    case 1:

                        record = "TESCO";

                        break;

                    case 2:

                        record = "GIANT";

                        break;

                    case 3:

                        record = "AKASIA";

                    case 4:

                        record = "KK1";

                    case 5:

                        record = "KKSI";

                    case 6:

                        record = "KKNC";
                }


            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, number);

        //set adapter to spinner

        sp1.setAdapter(adapter);

        //set spinner method

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {

                    case 0:

                        record = "1";

                        break;

                    case 1:

                        record = "2";

                        break;

                    case 2:

                        record = "3";

                        break;

                    case 3:

                        record = "4";
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //set adapter to spinner

        sp2.setAdapter(adapter);

        //set spinner method

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {

                    case 0:

                        record = "Aiman";

                        break;

                    case 1:

                        record = "Bujibu";

                        break;

                    case 2:

                        record = "Jemah";

                        break;

                    case 3:

                        record = "Sofia";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }}