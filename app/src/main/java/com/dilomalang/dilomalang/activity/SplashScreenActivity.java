package com.dilomalang.dilomalang.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.helper.GpsHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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

    GpsHelper gpsHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_splashscreen);

        gpsHelper = new GpsHelper(SplashScreenActivity.this, SplashScreenActivity.this);


    }

    @Override
    protected void onResume() {
       super.onResume();
        gpsHelper.Resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gpsHelper.Pause();
    }

}
