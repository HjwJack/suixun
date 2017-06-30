package com.suixun.hsh.ui.adapter;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.suixun.hsh.R;
import com.suixun.hsh.bean.News;

import java.util.List;

/**
 * Created by Love—Sun on 2017/6/29.
 */

public class ChildNewsRecyclerViewAdapter extends RecyclerView.Adapter<ChildNewsRecyclerViewAdapter.ViewHolder>{

    private List<News.DataBean> beanList;
    private Context context;

    public ChildNewsRecyclerViewAdapter(List<News.DataBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chile_news,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.newsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Toast.makeText(context, beanList.get(position).getAbstractX(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        News.DataBean dataBean = beanList.get(position);
        holder.newsName.setText(dataBean.getAbstractX());
        Glide.with(context).load(dataBean.getMedia_avatar_url()).into(holder.newsImage);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView newsCardView;
        ImageView newsImage;
        TextView newsName;
        public ViewHolder(View itemView) {
            super(itemView);
            newsCardView = (CardView) itemView;
            newsImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            newsName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
