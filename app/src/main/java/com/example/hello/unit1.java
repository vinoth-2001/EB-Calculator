package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class unit1 extends AppCompatActivity {


    EditText uread;
    Button cbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit1);



        uread =findViewById(R.id.unitt);
        cbtn = findViewById(R.id.cbtn);

        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();

            }
        });
    }



    private void senddata() {
        if ((uread.getText().length() > 0)){
            double pone = Double.parseDouble(uread.getText().toString().trim());


            Intent i = new Intent(unit1.this, result2.class);
            i.putExtra(result2.UREAD,pone);
            startActivity(i);

        }
        else {
            Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
        }
    }

}