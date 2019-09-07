package com.example.appmaps.activities;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.appmaps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

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

       // mMap.setMinZoomPreference(10);
       // mMap.setMaxZoomPreference(15);

        // Add a marker in Sydney and move the camera
        LatLng zitacuaro = new LatLng(19.43470493944953, -100.3557300567627);
        mMap.addMarker(new MarkerOptions().position(zitacuaro).title("Hola desde Zitacuaro").draggable(true));
        //Orientacion d el camara
        CameraPosition camera= new CameraPosition.Builder()
                .target(zitacuaro)
                .zoom(10)        //limit -> 21
                //Orientacion camara este
                .bearing(0)       //0-365°
                .tilt(30)         //limt ->90
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(zitacuaro));

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(MapsActivity.this,"Click on:\n"+
                        "Lat: "+latLng.latitude+"\n"+
                        "Lon: "+latLng.longitude,Toast.LENGTH_SHORT).show();

            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Toast.makeText(MapsActivity.this,"Long Click on:\n"+
                        "Lat: "+latLng.latitude+"\n"+
                        "Lon: "+latLng.longitude,Toast.LENGTH_SHORT).show();
            }
        });

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {

            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });


    }


}
