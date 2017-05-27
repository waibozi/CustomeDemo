package com.customdemo.fabanimation;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.customdemo.R;
import com.customdemo.RecyclerAdapter;
import com.customdemo.Utils;
import com.customdemo.translucentstatusbar.DrawerLayoutDemo;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FabAnimationActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        setContentView(R.layout.layout_fab_animation_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rv_list = (RecyclerView) findViewById(R.id.rv_list);
        RecyclerAdapter adapter = new RecyclerAdapter();
        adapter.setOnItemClickListener(this);
        rv_list.setAdapter(adapter);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) toolbar.getLayoutParams();
        int statusBarHeight = Utils.getStatusBarHeight(this);
        params.height += statusBarHeight;
        toolbar.setLayoutParams(params);
        toolbar.setPadding(0, statusBarHeight, 0, 0);
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, DrawerLayoutDemo.class);
        startActivity(intent);
    }
}
