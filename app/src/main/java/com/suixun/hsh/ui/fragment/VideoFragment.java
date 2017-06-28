package com.suixun.hsh.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suixun.hsh.R;
import com.suixun.hsh.adapter.ViewPagerAdapter;
import com.suixun.hsh.contants.CommonContants;
import com.suixun.hsh.ui.fragment.ChildFragment.ChildNewsFragment;
import com.suixun.hsh.ui.fragment.ChildFragment.ChildVideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    @BindView(R.id.sliding_tabs)
    TabLayout slidingTabs;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    private List<String> tabList = new ArrayList<>();
    private List<Fragment> childFragmentsList = new ArrayList<>();

    public VideoFragment() {
        // Required empty public constructor
    }

    private static VideoFragment videoFragment;

    public static VideoFragment getInstance() {
        if (videoFragment == null) {
            videoFragment = new VideoFragment();
        }
        return videoFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        if (tabList.size() == 0 && childFragmentsList.size() == 0){
            for (int i = 0; i < 6; i++) {
                tabList.add(CommonContants.VIDEO_FLAGS[i]);
                childFragmentsList.add(ChildVideoFragment.getInstance(CommonContants.VIDEO_FLAGS[i], CommonContants.VIDEO_FLAGURL[i]));
            }
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), tabList,childFragmentsList);
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
}
