package com.example.hello;

import static java.lang.String.valueOf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Result extends AppCompatActivity {

    public static final String CREAD = "CREAD";
    public static final String PREAD = "PREAD";
    TextView cunit, amount;
    double one, two, s = 0, unit = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        cunit = findViewById(R.id.uni);
        amount = findViewById(R.id.amount);



        Intent i = getIntent();
        one = i.getDoubleExtra(CREAD, 0);
        two = i.getDoubleExtra(PREAD, 0);

        billcalculater();
        insert();


    }

    public void billcalculater() {
        if (one < two) {
            unit = two - one; // 500
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

    public void insert()
    {
        try
        {
           // String name = ed1.getText().toString();
           /// String course = ed2.getText().toString();
            //String fee = ed3.getText().toString();
            String unitt = String.valueOf(cunit);
            String amountt = String.valueOf(s);
            SQLiteDatabase db = openOrCreateDatabase("SliteDb", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT,unitt VARCHAR, amountt VARCHAR)");
            String sql = "insert into records(unitt,amountt)values(?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,unitt);
            statement.bindString(2,amountt);

            statement.execute();
            Toast.makeText(this,"Record addded",Toast.LENGTH_LONG).show();

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }

}
