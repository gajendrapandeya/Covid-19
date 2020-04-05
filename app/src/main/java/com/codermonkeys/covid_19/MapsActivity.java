package com.codermonkeys.covid_19;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    public static final int zoomQuality = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sukraraj = new LatLng(27.6954492,85.3047526);
        mMap.addMarker(new MarkerOptions().position(sukraraj).title("Sukraraj Tropical And Infectious Disease Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sukraraj, zoomQuality));

        LatLng patan = new LatLng(27.6679129,85.3191451);
        mMap.addMarker(new MarkerOptions().position(sukraraj).title("Patan Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(patan, zoomQuality));

        LatLng NepalAPF = new LatLng(27.6902448,85.2497488);
        mMap.addMarker(new MarkerOptions().position(NepalAPF).title("Nepal APF Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NepalAPF, zoomQuality));

        LatLng BirHospital = new LatLng(27.7048296,85.3114627);
        mMap.addMarker(new MarkerOptions().position(BirHospital).title("Bir Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BirHospital, zoomQuality));


        LatLng NationalAyurved = new LatLng(27.6767545,85.2858444);
        mMap.addMarker(new MarkerOptions().position(NationalAyurved).title("National Ayurveda Research And Training Center"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(NationalAyurved, zoomQuality));

        LatLng Birendra = new LatLng(27.6768309,85.2530134);
        mMap.addMarker(new MarkerOptions().position(Birendra).title("Birendra Sainik Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Birendra, zoomQuality));

        LatLng mechiZonal = new LatLng(26.5571821,88.0873524);
        mMap.addMarker(new MarkerOptions().position(mechiZonal).title("Mechi Zonal Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mechiZonal, zoomQuality));

        LatLng udayapur = new LatLng(26.7975598,86.6930455);
        mMap.addMarker(new MarkerOptions().position(udayapur).title("Udayapur District Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(udayapur, zoomQuality));

        LatLng janakpurZonal = new LatLng(26.7333329,85.9213397);
        mMap.addMarker(new MarkerOptions().position(janakpurZonal).title("Janakpur Zonal Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(janakpurZonal, zoomQuality));


        LatLng bhaktapur = new LatLng(27.6745619,85.393942);
        mMap.addMarker(new MarkerOptions().position(bhaktapur).title("Bhaktapur Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bhaktapur, zoomQuality));

        LatLng sindhuli = new LatLng(27.6749251,85.1312531);
        mMap.addMarker(new MarkerOptions().position(sindhuli).title("Sindhuli Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sindhuli, zoomQuality));

        LatLng dhaulagiri = new LatLng(28.2686502,83.5981524);
        mMap.addMarker(new MarkerOptions().position(dhaulagiri).title("Dhaulagiri Zonal Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dhaulagiri, zoomQuality));

        LatLng gorkha = new LatLng(27.9949153,84.6257523);
        mMap.addMarker(new MarkerOptions().position(gorkha).title("Gorkha District Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gorkha, zoomQuality));

        LatLng lumbini = new LatLng(27.6978312,83.4619628);
        mMap.addMarker(new MarkerOptions().position(lumbini).title("Lumbini Zonal Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lumbini, zoomQuality));

        LatLng tamghas = new LatLng(28.0643121,83.2375241);
        mMap.addMarker(new MarkerOptions().position(tamghas).title("Tamghas Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tamghas, zoomQuality));

        LatLng surkhet = new LatLng(28.6528543,81.2242803);
        mMap.addMarker(new MarkerOptions().position(surkhet).title("Surkhet District Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(surkhet, zoomQuality));

        LatLng dailekh = new LatLng(28.653483,81.2242776);
        mMap.addMarker(new MarkerOptions().position(dailekh).title("Dailekh District Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dailekh, zoomQuality));


        LatLng setiZonal = new LatLng(28.7039841,80.5855671);
        mMap.addMarker(new MarkerOptions().position(setiZonal).title("Seti Zonal Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(setiZonal, zoomQuality));

        LatLng mahakali = new LatLng(28.9636816,80.1841021);
        mMap.addMarker(new MarkerOptions().position(mahakali).title("Mahakali Hospital"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mahakali, zoomQuality));



    }
}
