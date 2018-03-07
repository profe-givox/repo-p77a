package net.ivanvega.mismapitasenanddroid;

import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback, View.OnClickListener,
        GoogleMap.OnMapClickListener

{

    private GoogleMap map;

    private Button btnOpcion, btnAnimar, btnMOver, btnPOsicion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        inicializarUI();
    }

    private void inicializarUI(){
        btnOpcion = (Button) findViewById(R.id.btnOpcion); btnOpcion.setOnClickListener(this);
        btnAnimar = (Button) findViewById(R.id.btnAnimar); btnAnimar.setOnClickListener(this);
        btnMOver = (Button)findViewById(R.id.btnMover); btnMOver.setOnClickListener(this);
        btnPOsicion = (Button) findViewById(R.id.btnPosc); btnPOsicion.setOnClickListener(this);

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
        map = googleMap;
        map.setOnMapClickListener(this);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnOpcion)){
            map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            map.getUiSettings().setZoomControlsEnabled(true);
        }

        if(v.equals(btnMOver)){
            CameraUpdate camera =
                    CameraUpdateFactory.
                    newLatLngZoom(
                            new LatLng(19.427304,-99.137822),19);

            map.moveCamera(camera);
        }

        if(v.equals(btnAnimar)){
            LatLng angelInd = new LatLng(19.426978, -99.167775);
            CameraPosition position = new CameraPosition.Builder()
                    .target(angelInd)
                    .bearing(45)
                    .zoom(19)
                    .tilt(70)
                    .build();
            CameraUpdate campos =
                    CameraUpdateFactory.newCameraPosition(position);
            map.animateCamera(campos);
        }

        if(v.equals(btnPOsicion)){
            CameraPosition camPosition = map.getCameraPosition();
            Toast.makeText(this, "Lat: " + String.valueOf(camPosition.target.latitude) +
                            "\nLon: " + String.valueOf(camPosition.target.longitude)
                    , Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onMapClick(LatLng latLng) {
        Projection proj = map.getProjection();
        Point coord = proj.toScreenLocation(latLng);

        Log.d("MAPA-PROJECTION",
                "LAT: " + String.valueOf(proj.fromScreenLocation(coord).latitude  ) +
                        ", LON: " + String.valueOf(proj.fromScreenLocation(coord).longitude  ) );


        Toast.makeText(
                this,
                "Click\n" +
                        "Lat: " + latLng.latitude + "\n" +
                        "Lng: " + latLng.longitude + "\n" +
                        "X: " + coord.x + " - Y: " + coord.y,
                Toast.LENGTH_SHORT).show();
    }

}
