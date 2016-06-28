package com.dilomalang.dilomalang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dilomalang.dilomalang.R;

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

public class CheckInActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "https://dilomalang.mnafian.net/register";

    public static final String KEY_TANGGAL = "tanggal";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_STARTUP = "startup";
    public static final String KEY_KEPERLUAN = "keperluan";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_GENRE = "genre";
    public static final String KEY_UMUR = "umur";
    public static final String KEY_TOKEN = "token";



    private EditText editTanggal;
    private EditText editNama;
    private EditText editStartup;
    private EditText editKeperluan;
    private EditText editEmail;
    private EditText editGenre;
    private EditText editUmur;

    private Button buttoncheckin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_checkin);

        editTanggal = (EditText) findViewById(R.id.editTanggal);
        editNama = (EditText) findViewById(R.id.editNama);
        editStartup= (EditText) findViewById(R.id.editStartup);
        editKeperluan= (EditText) findViewById(R.id.editKeperluan);
        editEmail= (EditText) findViewById(R.id.editEmail);
        editGenre= (EditText) findViewById(R.id.editGenre);
        editUmur= (EditText) findViewById(R.id.editUmur);

        buttoncheckin = (Button) findViewById(R.id.buttoncheckin);

        buttoncheckin.setOnClickListener(this);
    }

    private void submitCheckin (){
        final String tanggal = editTanggal.getText().toString().trim();
        final String nama = editNama.getText().toString().trim();
        final String startup = editStartup.getText().toString().trim();
        final String keperluan = editKeperluan.getText().toString().trim();
        final String email = editEmail.getText().toString().trim();
        final String genre = editGenre.getText().toString().trim();
        final String umur = editUmur.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, REGISTER_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(CheckInActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CheckInActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_TANGGAL,tanggal);
                params.put(KEY_NAMA,nama);
                params.put(KEY_STARTUP,startup);
                params.put(KEY_KEPERLUAN,keperluan);
                params.put(KEY_EMAIL,email);
                params.put(KEY_GENRE,genre);
                params.put(KEY_UMUR,umur);
                params.put(KEY_TOKEN,"68c1f8e3881b56a62a84d5ef7977f4a3");
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    @Override
    public void onClick(View v) {
        if(v == buttoncheckin){
            submitCheckin();
        }
    }
    }

