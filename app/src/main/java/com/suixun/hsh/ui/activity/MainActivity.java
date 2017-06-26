package com.suixun.hsh.ui.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.suixun.hsh.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.mToolBar);
        setSupportActionBar(toolbar); //将Toolbar的实例传入
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true); //显示导航按钮
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//设置导航按钮图标（默认返回箭头，含义返回上一个活动）
        }
        navView.setCheckedItem(R.id.nav_home); //设置默认选中
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() { //菜单选项监听事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //处理逻辑
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_video:
                        Toast.makeText(MainActivity.this, "Video", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.nav_message:
                        Toast.makeText(MainActivity.this, "Message", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.nav_my:
                        Toast.makeText(MainActivity.this, "My", Toast.LENGTH_SHORT).show();

                        break;
                    default:
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

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
                mDrawerLayout.openDrawer(GravityCompat.START);//对HomeAsUp按钮（id永远是 android.R.id.home），显示滑动菜单，传入GravityCompat.START
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
