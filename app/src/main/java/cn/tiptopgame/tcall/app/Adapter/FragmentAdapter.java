package cn.tiptopgame.tcall.app.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

//FragmentAdapter
public class FragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentlist;

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }
}
