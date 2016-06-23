package com.dilomalang.dilomalang.helper;

import com.dilomalang.dilomalang.R;
import com.dilomalang.dilomalang.item.Developer;

import java.util.ArrayList;
import java.util.List;

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

public class NameDeveloperHelper {

    public static List<Developer> getDeveloperList() {
        List<Developer> developers = new ArrayList<>();
        for (int i = 0; i < getImage().length; i++) {
            Developer dev = new Developer(getNameDev()[i], getImage()[i]);
            developers.add(dev);
        }
        return developers;
    }

    private static int[] getImage() {
        return new int[]{R.drawable.sample, R.drawable.sample};
    }

    private static String[] getNameDev() {
        return new String[]{"Sample", "Sample"};
    }
}
