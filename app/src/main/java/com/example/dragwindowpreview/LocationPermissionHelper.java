package com.example.dragwindowpreview;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LocationPermissionHelper {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;

    public void checkLocationPermission(Activity activity) {
        // Periksa apakah izin lokasi sudah diberikan
        if (ContextCompat.checkSelfPermission(activity, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Jika izin belum diberikan, minta izin
            ActivityCompat.requestPermissions(activity, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            // Izin sudah diberikan, lakukan sesuatu yang membutuhkan lokasi
            // Misalnya, mulai mengambil lokasi
            // startLocationUpdates();
        }
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Izin diberikan, lakukan sesuatu yang membutuhkan lokasi
                // Misalnya, mulai mengambil lokasi
                // startLocationUpdates();
            } else {
                // Izin ditolak, beri tahu pengguna atau lakukan sesuatu yang sesuai
                // Misalnya, tampilkan pesan bahwa fitur lokasi tidak dapat digunakan
            }
        }
    }
}
