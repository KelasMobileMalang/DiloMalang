package com.dilomalang.dilomalang.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.adapter.DeveloperAdapter;

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

    public static int [] prgmImages={R.drawable.ahmad_dzaki_afif_h,R.drawable.ahmad_roihan,R.drawable.fadhli_al_mutawakkil,R.drawable.fahruddin_yusuf_h,R.drawable.fauzi_firman_a,
                                    R.drawable.m_fadlur_rahman,R.drawable.m_galang_arbi_s,R.drawable.syaiful_amri_yahya,R.drawable.joko_nugroho,R.drawable.tantowi_lathif};
    public static String [] prgmNameList={"Ahmad Dzaki Afif H","Ahmad Roihan","Fadhli Al Mutawakkil","Fahruddin Yusuf H","Fauzi Firman A",
                                        "M Fadlur Rahman","M Galang Arbi S","Syaiful Amri Yahya","Joko Nugroho","Tantowi Lathif"};
    public static String [] emailList={"dzakiafif12@gmail.com","ahmadroihanmlg@gmail.com","fadhli.tech@gmail.com","yusufudin14431@gmail.com","fauzialam5@gmail.com",
                                        "fadlur2@live.com","Galangarbis@gmail.com","syaifulamriyahya@gmail.com","ir.joko.nugroho@gmail.com","tantowilathif@gmail.com"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dilo_page_about_dev);

        context=this;

        /*lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new DeveloperAdapter(this, prgmNameList,emailList,prgmImages));*/

    }



}
