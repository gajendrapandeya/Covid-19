package com.codermonkeys.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SymptomsActivity extends AppCompatActivity {

    private Button mButtonMoreInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Symptoms & Preventions");

        mButtonMoreInfo = findViewById(R.id.button_more_info);
        final String url = "https://www.who.int/health-topics/coronavirus#tab=tab_1";
        mButtonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_VIEW);
                myIntent.setData(Uri.parse(url));
                startActivity(myIntent);
            }
        });

    }
}
