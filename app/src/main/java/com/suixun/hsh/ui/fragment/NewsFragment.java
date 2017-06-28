package com.suixun.hsh.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suixun.hsh.R;
import com.suixun.hsh.contants.CommonContants;
import com.suixun.hsh.ui.fragment.ChildFragment.ChildNewsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    @BindView(R.id.sliding_tabs)
    TabLayout slidingTabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    Unbinder unbinder;

    private List<String> tabList = new ArrayList<>();
    private List<ChildNewsFragment> childFragmentsList = new ArrayList<>();

    private static NewsFragment homeFragment;

    public static NewsFragment getInstance() {
        if (homeFragment == null) {
            homeFragment = new NewsFragment();
        }
        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        if (tabList.size() == 0 && childFragmentsList.size() == 0){
            for (int i = 0; i < 6; i++) {
                tabList.add(CommonContants.NEWS_FLAGS[i]);
                childFragmentsList.add(ChildNewsFragment.getInstance(CommonContants.NEWS_FLAGS[i], CommonContants.NEWS_FLAGURL[i]));
            }
        }
        NewsViewPagerAdapter adapter = new NewsViewPagerAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);
        slidingTabs.setupWithViewPager(viewpager);
        slidingTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    class NewsViewPagerAdapter extends FragmentPagerAdapter{

        public NewsViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return childFragmentsList.get(position);
        }

        @Override
        public int getCount() {
            return childFragmentsList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabList.get(position);
        }
    }
}
