package com.codermonkeys.covid_19;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GlobalActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<CasesItem> mItemCases;
    private CasesAdapter mAdapter;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Global Status");

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mItemCases = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);


        parseJson();
    }


    private void parseJson() {

        String url = "https://corona.lmao.ninja/countries";

        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject object = response.getJSONObject(i);


                        JSONObject flagObject = object.getJSONObject("countryInfo");

                        String flagUrl = flagObject.getString("flag");
                        //Log.d("url", "onResponse: " + flagUrl);

                        String countryName = object.getString("country");
                        int totalCases = object.getInt("cases");
                        int todayCases = object.getInt("todayCases");
                        int totalDeaths = object.getInt("deaths");
                        int todayDeaths = object.getInt("todayDeaths");
                        int recovered = object.getInt("recovered");
                        int activeCases = object.getInt("active");


                        mItemCases.add(new CasesItem(flagUrl, countryName, totalCases, todayCases, totalDeaths, todayDeaths, recovered, activeCases));


                        mAdapter = new CasesAdapter(getApplicationContext(), mItemCases);
                        mRecyclerView.setAdapter(mAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        mRequestQueue.add(arrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cases_menu, menu);
        MenuItem item = menu.findItem(R.id.search_view);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setQueryHint("Type here to search");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
