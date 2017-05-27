package com.customdemo.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.customdemo.R;

/**
 * Created by Administrator on 2017/5/10.
 */

public class TestView extends View {

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    RectF r2 = new RectF();                           //RectF对象
    Paint paint = new Paint();

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        r2.left = 50;                                 //左边
        r2.top = 400;                                 //上边
        r2.right = 450;                                   //右边
        r2.bottom = 600;
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(r2, 100, 100, paint);
        canvas.restore();
    }
}
