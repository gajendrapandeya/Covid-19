package com.codermonkeys.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.codermonkeys.covid_19.MainActivity.EXTRA_DESCRIPTION;
import static com.codermonkeys.covid_19.MainActivity.EXTRA_IMAGE_URL;
import static com.codermonkeys.covid_19.MainActivity.EXTRA_TITLE;

public class DetailActivity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTExtViewTitle, mTextViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("News");

        mImageView = findViewById(R.id.image_view_image_resource_detail);
        mTExtViewTitle = findViewById(R.id.text_view_title_detail);
        mTextViewDescription = findViewById(R.id.text_view_description_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_IMAGE_URL);
        String title = intent.getStringExtra(EXTRA_TITLE);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);

        Glide.with(getApplicationContext()).load(imageUrl).fitCenter().centerInside().into(mImageView);
        mTExtViewTitle.setText(title);
        mTextViewDescription.setText(description);
    }
}
