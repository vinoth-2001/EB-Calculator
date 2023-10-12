package com.example.hello;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class result2 extends AppCompatActivity {


    public static final String UREAD = "UREAD";

    TextView cunit, amount;
    double s = 0, unit;
    SQLiteDatabase db;
    
    String rno,ano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);



        cunit = findViewById(R.id.uni);
        amount = findViewById(R.id.amount);



        Intent i = getIntent();
        unit = i.getDoubleExtra(UREAD, 0);


        billcalculater();

    }



    public void billcalculater() {
        if (unit > 0) {
             // 500
            cunit.setText(valueOf(unit));


            if (unit > 0 && unit <= 100) {
                s = 0;
            } else if (unit <= 500) {
                if (unit > 100 && unit <= 200) {
                    s = ((unit - 100) * 2.25);
                } else if (unit > 200 && unit <= 400) {
                    s = (100 * 2.25) + ((unit - 200) * 4.5);
                } else if (unit > 400 && unit <= 500) {
                    s = (100 * 2.25) + (200 * 4.5) + ((unit - 400) * 6);
                }
            } else if (unit > 500) {
                if (unit > 100 && unit <= 400) {
                    unit = ((unit - 100) * 4.5);
                } else if (unit > 400 && unit <= 500) {
                    s = (300 * 4.5) + ((unit - 400) * 6);
                } else if (unit > 500 && unit <= 600) {
                    s = (300 * 4.5) + (100 * 6) + ((unit - 500) * 8);
                } else if (unit > 600 && unit <= 800) {
                    s = (300 * 4.5) + (100 * 6) + (100 * 8) + ((unit - 600) * 9);
                } else if (unit > 800 && unit <= 1000) {
                    s = (300 * 4.5) + (100 * 6) + (100 * 8) + (200 * 9) + ((unit - 800) * 10);
                } else if (unit > 1000) {
                    s = (300 * 4.5) + (100 * 6) + (100 * 8) + (200 * 9) + (200 * 10) + ((unit - 1000) * 11);
                }
            }
            amount.setText(valueOf(s));


        }


    }
}