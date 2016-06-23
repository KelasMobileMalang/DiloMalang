package com.dilomalang.dilomalang.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.dilomalang.dilomalang.item.Developer;

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

public class DeveloperAdapter extends ArrayAdapter<Developer> {


    public DeveloperAdapter(Context context, int resource, Developer[] objects) {
        super(context, resource, objects);
    }


}
