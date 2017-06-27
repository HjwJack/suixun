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
public class SmilingFragment extends Fragment {


    public SmilingFragment() {
        // Required empty public constructor
    }

    private static SmilingFragment smilingFragment;

    public static SmilingFragment getInstance(){
        if (smilingFragment==null){
            smilingFragment=new SmilingFragment();
        }
        return smilingFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smiling, container, false);
    }

}
