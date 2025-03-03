package com.example.dragwindowpreview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class LocationFindingActivity extends AppCompatActivity {

    private TextView textJudul;
    private Button shareloc;
    private LocationPermissionHelper location;

    protected void onCreate(Bundle SavedInstanceState){
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.location_find);

        location = new LocationPermissionHelper();

        textJudul = findViewById(R.id.title_text);
        shareloc = findViewById(R.id.trigger_location);

        textJudul.setText(R.string.pencarian_lokasi);
        shareloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                location.checkLocationPermission(LocationFindingActivity.this);
            }
        });



    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Teruskan hasil permintaan izin ke LocationPermissionHelper
        location.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

}
