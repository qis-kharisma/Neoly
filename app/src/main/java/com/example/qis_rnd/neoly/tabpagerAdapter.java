package com.example.qis_rnd.neoly;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.View;

/**
 * Created by NIPU on 12/27/2017.
 */

public class tabpagerAdapter extends FragmentStatePagerAdapter {
TabActivity tab=new TabActivity();
 CardView cdr1;
    String[] tabarray = new String[]{"Home","Map","Call","Queue"};
    Integer tabnumber = 4;
    Integer[] tabarray1 = new Integer[]{R.drawable.ic_menu_camera,R.drawable.ic_menu_camera,R.drawable.ic_menu_camera,R.drawable.ic_menu_camera};
    //private ClassLoader context;
    Context context;
    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabarray[position ];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                one one1 = new one();

                return one1;
            case 1:
                two two2 = new two();
                return two2;
            case 2:
                three three3 = new three();
                return three3;
            case 3:
                four four4 = new four();
                return four4;
//            case 4:
//                five five5 = new five();
//                return five5;
//            case 5:
//                six six6 = new six();
//                return six6;
        }


        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }

}
