package com.codermonkeys.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class NepalStatus extends AppCompatActivity {

    private TextView mTextViewConfirmed, mTextViewRecovered, mTextViewDeath, mTextViewActive;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nepal_status);
        initWidgets();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Nepal Status");
        mRequestQueue = Volley.newRequestQueue(this);

        parseJson();
    }

    private void initWidgets() {
        mTextViewConfirmed = findViewById(R.id.text_view_confirmed);
        mTextViewRecovered = findViewById(R.id.text_view_recovered);
        mTextViewDeath = findViewById(R.id.text_view_death);
        mTextViewActive = findViewById(R.id.text_view_active);
    }

    private void parseJson() {

        String url = "https://covid2019-api.herokuapp.com/v2/country/nepal";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                   JSONObject object = response.getJSONObject("data");

                   int confirmed = object.getInt("confirmed");
                   int deaths = object.getInt("deaths");
                   int recovered = object.getInt("recovered");
                   int active = object.getInt("active");

                   mTextViewConfirmed.setText("Confirmed\n\t" + confirmed);
                   mTextViewRecovered.setText("Recovered\n\t" + recovered);
                   mTextViewDeath.setText("Deaths\n\t" + deaths);
                   mTextViewActive.setText("Active\n\t" + active);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Network error!! Please connect to internet", Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(objectRequest);
    }

}
