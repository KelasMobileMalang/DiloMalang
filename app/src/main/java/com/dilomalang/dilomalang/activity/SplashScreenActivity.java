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

    TextView latituteField;
    TextView longitudeField;
    String longitude, latitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_splashscreen);

        latituteField = (TextView) findViewById(R.id.tvLat);
        longitudeField = (TextView) findViewById(R.id.tvLong);

        GpsHelper gpsHelper = new GpsHelper(SplashScreenActivity.this, SplashScreenActivity.this);
        gpsHelper.startGps();
        gpsHelper.getLatit();
        gpsHelper.getLongit();

        cekLokasi(latitude, longitude);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreenActivity.this,MainMenuActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }

    @Override
    protected void onResume() {
       super.onResume();

    }

    protected void parseJSON(String result) {
        JSONObject myJson = null;
        try {
            myJson = new JSONObject(result);
            longitude = myJson.optString("message");
            longitudeField.setText(longitude);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void cekLokasi(final String latitude, final String longitude){
        RequestQueue queue = Volley.newRequestQueue(this);  // this = context
        final String url = "https://dilomalang.mnafian.net/check";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        latituteField.setText(response.toString());
                        parseJSON(response.toString());
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", String.valueOf(error));
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("token", "68c1f8e3881b56a62a84d5ef7977f4a3");
                params.put("latitude", latitude);
                params.put("longitude", longitude);
                return params;
            }
        };
        queue.add(postRequest);
    }

}
