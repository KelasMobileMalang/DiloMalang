package com.dilomalang.dilomalang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
}
