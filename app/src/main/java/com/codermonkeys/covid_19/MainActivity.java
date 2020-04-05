package com.codermonkeys.covid_19;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, NewsAdapter.onItemClickListner {

    private DrawerLayout drawer;
    private NavigationView navigationView;

    private RecyclerView mRecyclerView;
    private RequestQueue mRequestQueue;
    private List<NewsItems> mNewsItems;
    private NewsAdapter mAdapter;

    public static final String EXTRA_IMAGE_URL = "imageUrl";
    public static final String EXTRA_TITLE = "title";
    public static final String EXTRA_DESCRIPTION = "description";

    private ImageView imageViewNepal, imageViewWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Covid-19 Nepal");

        imageViewNepal = findViewById(R.id.imageNepal);
        imageViewWorld = findViewById(R.id.imageWorld);

        imageViewNepal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NepalStatus.class));
            }
        });

        imageViewWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GlobalActivity.class));
            }
        });


        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        mRecyclerView = findViewById(R.id.recycler_view_main);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRequestQueue = Volley.newRequestQueue(this);
        mNewsItems = new ArrayList<>();

        parseJsonCorona();
        parseJsonHealth();
        parseFitness();
        parseEntertainment();


    }

    private void parseEntertainment() {


        String url = "https://newsapi.org/v2/everything?qInTitle=%22entertainment%22&language=en&sortBy=relevancy&apiKey=c7fad055e9964a0c9ee41efbbf6a7933";
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        String imageUrl = object.getString("urlToImage");
                        String title = object.getString("title");
                        String content = object.getString("description");

                        mNewsItems.add(new NewsItems(imageUrl, title, content));
                    }
                    mAdapter = new NewsAdapter(mNewsItems, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListner(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Network Connection Error!!", Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(objectRequest);

    }


    private void parseFitness() {

        String url = "https://newsapi.org/v2/everything?qInTitle=%22fitness%22&language=en&sortBy=relevancy&apiKey=c7fad055e9964a0c9ee41efbbf6a7933";
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        String imageUrl = object.getString("urlToImage");
                        String title = object.getString("title");
                        String content = object.getString("description");

                        mNewsItems.add(new NewsItems(imageUrl, title, content));
                    }
                    mAdapter = new NewsAdapter(mNewsItems, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListner(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Network Connection Error!!", Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(objectRequest);
    }

    private void parseJsonHealth() {

        String url = "https://newsapi.org/v2/everything?qInTitle=%22health%22&language=en&sortBy=relevancy&apiKey=c7fad055e9964a0c9ee41efbbf6a7933";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        String imageUrl = object.getString("urlToImage");
                        String title = object.getString("title");
                        String content = object.getString("description");

                        mNewsItems.add(new NewsItems(imageUrl, title, content));
                    }
                    mAdapter = new NewsAdapter(mNewsItems, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListner(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Network Connection Error!!", Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(objectRequest);
    }

    private void parseJsonCorona() {

        String url = "https://newsapi.org/v2/everything?qInTitle=%22corona%22&language=en&sortBy=relevancy&apiKey=c7fad055e9964a0c9ee41efbbf6a7933";

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject object = jsonArray.getJSONObject(i);

                        String imageUrl = object.getString("urlToImage");
                        String title = object.getString("title");
                        String content = object.getString("description");

                        mNewsItems.add(new NewsItems(imageUrl, title, content));
                    }
                    mAdapter = new NewsAdapter(mNewsItems, getApplicationContext());
                    mRecyclerView.setAdapter(mAdapter);
                    mAdapter.setOnItemClickListner(MainActivity.this);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Network Connection Error!!", Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(objectRequest);
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {


            case R.id.nav_emergency:
                startActivity(new Intent(MainActivity.this, EmergencyActivity.class));
                break;

            case R.id.nav_feedback:
                sendEmail();
                break;

            case R.id.nav_symptoms:
                startActivity(new Intent(MainActivity.this, SymptomsActivity.class));
                break;

            case R.id.nav_hospitals:
                startActivity(new Intent(MainActivity.this, HospitalsActivity.class));
                break;

            case R.id.nav_map:
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.nav_donation:
                openDialog();
                break;

            case R.id.nav_share:
                share();
                break;

            case R.id.nav_about:
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
        }
        return true;
    }

    private void openDialog() {

        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "shown succesfully");
    }

    private void share() {
        Intent intentInvite = new Intent(Intent.ACTION_SEND);
        intentInvite.setType("text/plain");
        String body = "Link to your app";
        String subject = "Your Subject";
        intentInvite.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentInvite.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(intentInvite, "Share using"));
    }

    @SuppressLint("LongLogTag")
    private void sendEmail() {

        String[] TO = {"gajendrapandeya6@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"));
        //  emailIntent.setType("application/octet-stream");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);


        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(MainActivity.this, DetailActivity.class);
        NewsItems clickedItem = mNewsItems.get(position);

        detailIntent.putExtra(EXTRA_IMAGE_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_TITLE, clickedItem.getNewsTitle());
        detailIntent.putExtra(EXTRA_DESCRIPTION, clickedItem.getDescription());

        startActivity(detailIntent);
    }
}
