package com.dilomalang.dilomalang.activity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dilomalang.dilomalang.R;

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

public class SplashScreenActivity extends AppCompatActivity implements LocationListener{

    private LocationManager lm;
    private TextView latituteField;
    private TextView longitudeField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_splashscreen);

        latituteField = (TextView) findViewById(R.id.tvLat);
        longitudeField = (TextView) findViewById(R.id.tvLong);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new MyLocationListener();

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    protected void onResume() {
       super.onResume();

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            latituteField.setText(String.valueOf(location.getLatitude()));
            longitudeField.setText(String.valueOf(location.getLongitude()));
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

}
