package com.suixun.hsh.ui.fragment.ChildFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.suixun.hsh.R;
import com.suixun.hsh.bean.News;
import com.suixun.hsh.presenter.IPresenterNews;
import com.suixun.hsh.presenter.IPresenterNewsImpl;
import com.suixun.hsh.ui.adapter.ChildNewsRecyclerViewAdapter;
import com.suixun.hsh.view.IViewNews;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildNewsFragment extends Fragment implements IViewNews {

    @BindView(R.id.newsRecyclerView)
    RecyclerView newsRecyclerView;
    Unbinder unbinder;
    @BindView(R.id.newSwipeRefreshLayout)
    SwipeRefreshLayout newSwipeRefreshLayout;
    private String name;
    private String url;
    private IPresenterNews presenterNews;
    private News news;


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
        presenterNews = new IPresenterNewsImpl(this);
        presenterNews.getData(url);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        newSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        newSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                newSwipeRefreshLayout.setRefreshing(false);
                            }
                        });
                    }
                }).start();
            }
        });
        return view;
    }

    private void initData() {
        ChildNewsRecyclerViewAdapter adapter = new ChildNewsRecyclerViewAdapter(news.getData(), getActivity());
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        newsRecyclerView.setLayoutManager(manager);
        newsRecyclerView.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getData(News result) {
        Log.d("AAAAAAAAA", "getData: " + result.getData().toString());
        this.news = result;
        initData();
    }
}
