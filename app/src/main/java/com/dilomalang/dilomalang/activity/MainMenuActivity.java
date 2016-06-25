package com.dilomalang.dilomalang.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

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

public class MainMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_mainmenu);

        final LinearLayout buttonCheckIn = (LinearLayout) findViewById(R.id.btnCheckin);
        buttonCheckIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,CheckInActivity.class);
                startActivity(intent);
            }
        });

        final LinearLayout buttonAboutDilo = (LinearLayout) findViewById(R.id.btnAboutDilo);
        buttonAboutDilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,AboutDiloActivity.class);
                startActivity(intent);
            }
        });

        final LinearLayout buttonAboutDeveloper = (LinearLayout) findViewById(R.id.btnAboutDev);
        buttonAboutDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this,AboutDeveloperActivity.class);
                startActivity(intent);
            }
        });

        final LinearLayout button = (LinearLayout) findViewById(R.id.btnVisit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://malang.dilo.id/"));
                startActivity(intent);

            }
        });


    }
}
