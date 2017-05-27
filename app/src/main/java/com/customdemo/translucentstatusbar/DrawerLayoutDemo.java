package com.customdemo.translucentstatusbar;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.customdemo.R;
import com.customdemo.RecyclerAdapter;
import com.customdemo.Utils;

/**
 * Created by Administrator on 2017/5/27.
 */

public class DrawerLayoutDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.drawer_layout_activity);
        RecyclerView rv_list = (RecyclerView) findViewById(R.id.rv_list);
        rv_list.setAdapter(new RecyclerAdapter());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.dl_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        int statusBarHeight = Utils.getStatusBarHeight(this);
        ViewGroup.LayoutParams params = toolbar.getLayoutParams();
        params.height += statusBarHeight;
        toolbar.setLayoutParams(params);
        toolbar.setPadding(0, statusBarHeight, 0, 0);
    }
}
