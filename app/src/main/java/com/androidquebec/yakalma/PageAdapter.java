package com.androidquebec.yakalma;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter  extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.numOfTabs = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AcceuilFragment();
            case 1:
                return new DayMenuFragment();
            case 2:
                return new NouveauFragment();
            case 3:
                return new ListesFragment();
            default :

            return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
