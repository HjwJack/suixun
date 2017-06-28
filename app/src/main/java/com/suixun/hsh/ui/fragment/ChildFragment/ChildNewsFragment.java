package com.suixun.hsh.ui.fragment.ChildFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suixun.hsh.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildNewsFragment extends Fragment {

    @BindView(R.id.txt)
    TextView txt;
    Unbinder unbinder;
    private String name;
    private String url;


    public static ChildNewsFragment getInstance(String name, String url) {
        ChildNewsFragment childNewsFragment = new ChildNewsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("url", url);
        childNewsFragment.setArguments(bundle);
        return childNewsFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
            url = bundle.getString("url");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        txt.setText(name);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
