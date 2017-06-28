package com.suixun.hsh.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.suixun.hsh.ui.fragment.ChildFragment.ChildNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: hjw on 2017/6/28 12:11
 * 邮箱: 18910207853@163.com
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> tabList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();


    public ViewPagerAdapter(FragmentManager fm, List<String> tabList, List<Fragment> fragmentList) {
        super(fm);
        this.tabList = tabList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }
}
