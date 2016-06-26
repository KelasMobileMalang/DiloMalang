package com.dilomalang.dilomalang.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.activity.AboutDeveloperActivity;
import com.dilomalang.dilomalang.item.Developer;

import static android.widget.Toast.makeText;

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

/**
 * Kelas ini untuk developer list adapter
 */

public class DeveloperAdapter extends BaseAdapter {

    String [] result;
    String [] result1;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;

    public DeveloperAdapter(AboutDeveloperActivity mainActivity, String[] prgmNameList, String[] emailList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        result1=emailList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv,email;
        ImageView img;
    }

    public void pindahBrowser(String getLink){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(getLink));
        context.startActivity(intent);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.dilo_page_item_list, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView);
        holder.email=(TextView) rowView.findViewById(R.id.textView2);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(result[position]);
        holder.email.setText(result1[position]);
        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                String[] link = new String[]{"https://github.com/dzakiafif", "https://github.com/ahmadroihan",
                                            "https://github.com/eltawakkal/", "https://github.com/fahruddin14431",
                                            "https://github.com/fauzi5896", "https://github.com/muhfadlurrahman",
                                            "https://github.com/galangarbis", "https://github.com/sayvinzu",
                                            "link9", "link10"};

                if (position==0){
                    pindahBrowser(link[0]);
                }else if (position==1){
                    pindahBrowser(link[1]);
                }else if (position==2){
                    pindahBrowser(link[2]);
                }else if (position==3){
                    pindahBrowser(link[3]);
                }else if (position==4){
                    pindahBrowser(link[4]);
                }else if (position==5){
                    pindahBrowser(link[5]);
                }else if (position==6){
                    pindahBrowser(link[6]);
                }else if (position==7){
                    pindahBrowser(link[7]);
                }else if (position==8){
                    pindahBrowser(link[8]);
                }else if (position==9){
                    pindahBrowser(link[9]);
                }else if (position==10){
                    pindahBrowser(link[10]);
                }else{
                    Toast.makeText(context,"Tidak ada yg terpilih !",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rowView;
    }


}
