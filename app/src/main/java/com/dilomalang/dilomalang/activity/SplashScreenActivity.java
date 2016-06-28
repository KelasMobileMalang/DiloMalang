package com.dilomalang.dilomalang.activity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.helper.GpsHelper;

/**
 * Created on : June/23/2016
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 * Company    : Rimbunesia.com
 * Project    : DiloMalang
 */

public class SplashScreenActivity extends AppCompatActivity {

    private LocationManager lm;
    private LocationListener locationListener;
    private TextView latituteField;
    private TextView longitudeField;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.dilo_page_splashscreen);
//
//        latituteField = (TextView) findViewById(R.id.tvLat);
//        longitudeField = (TextView) findViewById(R.id.tvLong);
//
//        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new MyLocationListener();
//
//        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//
//    }

    @Override
    protected void onResume() {
       super.onResume();

    }

    private class MyLocationListener implements LocationListener {
                //Menampilkan Update Lokasi GPS terkini
        @Override
        public void onLocationChanged(Location loc) {
            if (loc != null) {
                latituteField.setText(String.valueOf(loc.getLatitude()));
                longitudeField.setText(String.valueOf(loc.getLongitude()));
            }
        }

        @Override
        public void onProviderDisabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onProviderEnabled(String provider) {
            // TODO Auto-generated method stub
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            // TODO Auto-generated method stub
        }
    }

}
