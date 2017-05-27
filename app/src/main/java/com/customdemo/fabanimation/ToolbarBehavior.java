package com.customdemo.fabanimation;


import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/26.
 */

public class ToolbarBehavior extends CoordinatorLayout.Behavior {
    private static final String TAG = "FabBehavior";
    private boolean isVisible = true;

    public ToolbarBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && isVisible) {
            isVisible = false;
            hideFab(child);
        } else if (dyConsumed < 0 && !isVisible) {
            isVisible = true;
            showFab(child);
        }
    }

    private void showFab(View child) {
        child.animate().translationY(0).setInterpolator(new AccelerateInterpolator()).start();
    }

    private void hideFab(View child) {
        child.animate().translationY(-child.getHeight()).setInterpolator(new DecelerateInterpolator()).start();
    }
}
