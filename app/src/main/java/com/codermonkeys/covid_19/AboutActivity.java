package com.codermonkeys.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    private CircleImageView mGitImageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mGitImageview = findViewById(R.id.git);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About");

        mGitImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://github.com/gajendrapandeya";
                Intent gitInent = new Intent(Intent.ACTION_SEND);
                gitInent.setData(Uri.parse(url));
                startActivity(gitInent);

            }
        });


    }
}
