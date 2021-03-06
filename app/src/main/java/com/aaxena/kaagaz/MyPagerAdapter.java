package com.aaxena.kaagaz;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public MyPagerAdapter(FragmentManager fm){
        super(fm);
    }
    @Override    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Tab1();
            case 1: return new Tab4();
            case 3: return new Tab2();
            case 2: return new Tab3();
        }
        return null;
    }
    @Override
    public int getCount() {
        return 4;
    }
    @Override    public CharSequence getPageTitle(int position) {switch (position){
        case 0: return "Desert";
        case 1: return "Kaagaz";
        case 3: return "Waves";
        case 2: return "Phase";
        default: return null;
    }
    }
}
