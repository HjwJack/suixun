package com.suixun.hsh.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.suixun.hsh.R;
import com.suixun.hsh.base.BaseActivity;
import com.suixun.hsh.ui.fragment.NewsFragment;
import com.suixun.hsh.ui.fragment.ContentFragment;
import com.suixun.hsh.ui.fragment.MyFragment;
import com.suixun.hsh.ui.fragment.SmilingFragment;
import com.suixun.hsh.ui.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.mToolBar)
    Toolbar mToolBar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private Fragment fragment;


    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar); //将Toolbar的实例传入
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); //显示导航按钮
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//设置导航按钮图标（默认返回箭头，含义返回上一个活动）
        }

        fragmentList = getFraments();
        normalFragment();

        navView.setCheckedItem(R.id.nav_news); //设置默认选中
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { //菜单选项监听事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ft = getSupportFragmentManager().beginTransaction();
                //处理逻辑
                switch (item.getItemId()) {
                    case R.id.nav_news:
                        fragment = fragmentList.get(0);
                        ft.replace(R.id.mFragment, fragment);
                        ft.commit();
                        showLog("news");
                        break;
                    case R.id.nav_video:
                        fragment = fragmentList.get(1);
                        ft.replace(R.id.mFragment, fragment);
                        ft.commit();
                        showLog("video");

                        break;
                    case R.id.nav_contentScripts:
                        fragment = fragmentList.get(2);
                        ft.replace(R.id.mFragment, fragment);
                        ft.commit();
                        showLog("contentScripts");
                        break;
                    case R.id.nav_smilingFigure:
                        fragment = fragmentList.get(3);
                        ft.replace(R.id.mFragment, fragment);
                        ft.commit();
                        showLog("smilingFigure");
                        break;
                    case R.id.nav_my:
                        fragment = fragmentList.get(4);
                        ft.replace(R.id.mFragment, fragment);
                        ft.commit();
                        showLog("my");

                        break;
                    default:
                        break;

                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("FAB clicked");
            }
        });

    }

    private void normalFragment() {
        ft = getSupportFragmentManager().beginTransaction();
        fragment = fragmentList.get(0);
        ft.replace(R.id.mFragment, fragment);
        ft.commit();
    }

    private List<Fragment> getFraments() {
        fragmentList.add(NewsFragment.getInstance());
        fragmentList.add(VideoFragment.getInstance());
        fragmentList.add(ContentFragment.getInstance());
        fragmentList.add(SmilingFragment.getInstance());
        fragmentList.add(MyFragment.getInstance());

        return fragmentList;
    }


    /**
     * 加载toolbar.xml文件
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }


    /**
     * 处理各个按钮的点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);//对HomeAsUp按钮（id永远是 android.R.id.home），显示滑动菜单，传入GravityCompat.START
                break;
            case R.id.backup:
                showToast("You clicked Backup");
                break;
            case R.id.delete:
                showToast("You clicked Delete");
                break;
            case R.id.settings:
                showToast("You clicked Settings");
                break;
            default:
                break;
        }
        return true;
    }


}
