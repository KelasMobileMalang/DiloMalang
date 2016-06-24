package com.dilomalang.dilomalang.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.adapter.DeveloperAdapter;

import java.util.ArrayList;

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

public class AboutDeveloperActivity extends AppCompatActivity {

    ListView lv;
    Context context;

    public static int [] prgmImages={R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample,R.drawable.sample};
    public static String [] prgmNameList={"Nama 1","Nama 2","Nama 3","Nama 4","Nama 5","Nama 6","Nama 7","Nama 8","Nama 9","Nama 10"};
    public static String [] emailList={"Email 1","Email 2","Email 3","Email 4","Email 5","Email 6","Email 7","Email 8","Email 9","Email 10"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_about_dev);

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new DeveloperAdapter(this, prgmNameList,emailList,prgmImages));

    }



}
