package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reading1 extends AppCompatActivity {
    EditText cread,pread;
    Button cbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading1);

        pread =findViewById(R.id.pread);
        cread =findViewById(R.id.cread);
        cbtn = findViewById(R.id.cbtn);

        cbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                senddata();
            }
        });
    }
    private void senddata() {
        if ((pread.getText().length() > 0) && (cread.getText().length() > 0)){
            double pone = Double.parseDouble(pread.getText().toString().trim());
            double ctwo = Double.parseDouble(cread.getText().toString().trim());

            Intent i = new Intent(reading1.this, Result.class);
            i.putExtra(Result.CREAD,pone);
            i.putExtra(Result.PREAD,ctwo);
            startActivity(i);

        }
        else {
            Toast.makeText(this, "enter number", Toast.LENGTH_SHORT).show();
        }
    }
}