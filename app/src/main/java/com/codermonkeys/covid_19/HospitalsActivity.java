package com.codermonkeys.covid_19;




import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class HospitalsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HospitalAdapter adapter;
    ArrayList<HospitalItems> hospitalItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);

        mRecyclerView = findViewById(R.id.recycler_view_hospital);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setTitle("Hospitals");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setArrayList();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.sk_line_divider));
        mRecyclerView.addItemDecoration(itemDecoration);

        adapter = new HospitalAdapter(getApplicationContext(), (ArrayList<HospitalItems>) hospitalItems);
        mRecyclerView.setAdapter(adapter);

    }

    private void setArrayList() {

        hospitalItems = new ArrayList<>();
        hospitalItems.add(new HospitalItems("Sukrararaj Tropical And Infectious Disease Hospital", "8 AM - 3 PM \nSunday - Friday", "01-4253395\n01-4253396"));
        hospitalItems.add(new HospitalItems("Patan Hospital", "24 hrs      \nSunday - Saturday", "01-5522295"));
        hospitalItems.add(new HospitalItems("Nepal APF Hospital", "24 hrs\nSunday - Saturday", "01-4315224"));
        hospitalItems.add(new HospitalItems("Bir Hospital", "24 hrs\nSunday - Saturday", "01-4221119"));
        hospitalItems.add(new HospitalItems("National Ayurveda Research and Training Center", "10 AM - 3 AM\nSunday - Friday", "01-4334973"));
        hospitalItems.add(new HospitalItems("Birendra Sainik Hospital", "8 AM - 5 AM\nSunday - Friday", "01-4271940"));
        hospitalItems.add(new HospitalItems("Mechi Zonal Hospital", "24 hrs\nSunday - Saturday", "023-520172"));
        hospitalItems.add(new HospitalItems("Udayapur District Hospital", "24 hrs\nSunday - Saturday", "035-420187"));
        hospitalItems.add(new HospitalItems("Janakpur Zonal Hospital","24 hrs\nSunday - Saturday", "041-520133\n041-520033"));
        hospitalItems.add(new HospitalItems("Bhaktapur Hospital", "24 hrs\nSunday - Saturday", "01-6610798"));
        hospitalItems.add(new HospitalItems("Sindhuli Hospital", "6 AM - 9 PM\nSunday - Saturday", "047-520973"));
        hospitalItems.add(new HospitalItems("Dhaulagiri Zonal Hospital", "24 hrs\nSunday - Saturday", "9851176425\n068-520188"));
        hospitalItems.add(new HospitalItems("Gorkha District Hospital", "24 hrs\nSunday - Saturday", "064-420208"));
        hospitalItems.add(new HospitalItems("Lumbini Zonal Hospital", "24 hrs\nSunday - Saturday", "071-541400"));
        hospitalItems.add(new HospitalItems("Tamghas Hospital", "10 AM - 4 PM\nSunday - Friday", "079-520188"));
        hospitalItems.add(new HospitalItems("Surkhet District Hospital", "24 hrs\nSunday - Saturday", "083-525417"));
        hospitalItems.add(new HospitalItems("Dailekh District Hospital", "8 AM - 8 PM\nSunday - Saturday", "089-410185"));
        hospitalItems.add(new HospitalItems("Seti Zonal Hospital", "24 hrs\nSunday - Saturday", "9841943586"));
        hospitalItems.add(new HospitalItems("Mahakali Hospital", "24 hrs\nSunday - Saturday", "9843247009\n099-521111"));

    }

}