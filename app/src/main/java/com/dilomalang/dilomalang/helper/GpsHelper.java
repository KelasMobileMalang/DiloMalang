package com.dilomalang.dilomalang.helper;

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

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dilomalang.dilomalang.activity.MainMenuActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Kelas ini untuk helper sample helper GPS
 */

public class GpsHelper implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    public String latit;
    public String longit;
    Context mContect;
    Activity activity;
    String status;

    //Define a request code to send to Google Play services
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;

    public GpsHelper(Context mContect, Activity activity) {
        this.mContect = mContect;
        this.activity = activity;
        startGps();
    }

    public void startGps(){
        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)
                .setFastestInterval(1 * 1000);
    }

    public void Resume(){
        mGoogleApiClient.connect();
    }

    public void Pause(){
        Log.v(this.getClass().getSimpleName(), "onPause()");
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

        } else {
            //If everything went fine lets get latitude and longitude
            currentLatitude = location.getLatitude();
            currentLongitude = location.getLongitude();
            latit = ""+currentLatitude;
            longit = ""+currentLongitude;
            Log.v("onConnected", "OnConnected " + currentLatitude + ", " +currentLongitude);
            cekLokasi(latit, longit);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();
        latit = ""+currentLatitude;
        longit = ""+currentLongitude;
        Log.v("hasil", currentLatitude + " " + currentLongitude);
        cekLokasi(latit, longit);
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(activity, CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (IntentSender.SendIntentException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("Error", "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    public void cekLokasi(final String latitude, final String longitude){
        RequestQueue queue = Volley.newRequestQueue(activity);  // this = context
        final String url = "https://dilomalang.mnafian.net/check";

        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);

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

    protected void parseJSON(String result) {
        JSONObject myJson = null;
        try {
            myJson = new JSONObject(result);
            status = myJson.optString("message");
            Log.v("Status", "Status = " + status);
            Thread timerThread = new Thread(){
                public void run(){
                    try{
                        sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }finally{
                        Intent intent = new Intent(activity, MainMenuActivity.class);
                        intent.putExtra("status", status);
                        activity.startActivity(intent);
                        activity.finish();
                    }
                }
            };
            timerThread.start();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
