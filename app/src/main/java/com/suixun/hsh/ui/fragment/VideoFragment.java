package com.suixun.hsh.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suixun.hsh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        return view;
    }

}
