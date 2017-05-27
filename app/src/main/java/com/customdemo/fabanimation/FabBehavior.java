package com.customdemo.fabanimation;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Administrator on 2017/5/26.
 */

public class FabBehavior extends FloatingActionButton.Behavior {
    private static final String TAG = "FabBehavior";
    private boolean isVisible = true;

    public FabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        return nestedScrollAxes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes);
    }

    @Override
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        Log.e(TAG, dyConsumed + "");
        if (dyConsumed > 0 && isVisible) {
            isVisible = false;
            hideFab(child);
        } else if (dyConsumed < 0 && !isVisible) {
            isVisible = true;
            showFab(child);
        }
    }

    private void showFab(FloatingActionButton child) {
        child.animate().scaleX(1).scaleY(1).setInterpolator(new AccelerateInterpolator()).start();
    }

    private void hideFab(FloatingActionButton child) {
        child.animate().scaleX(0).scaleY(0).setInterpolator(new DecelerateInterpolator()).start();
    }

}
