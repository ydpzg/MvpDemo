package com.hgsoft.mvpdemo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hgsoft.mvpdemo.R;

/**
 * Created by YUDAPEI on 2017/7/21.
 */

public class MyView extends View {

    private float mRadius = 80;
    private int mBackgroundColor = Color.GRAY;
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
        init(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        System.out.println("init");

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyViewAttr, 0, 0);
            mRadius = typedArray.getDimension(R.styleable.MyViewAttr_radius, 80);
            mBackgroundColor = typedArray.getColor(R.styleable.MyViewAttr_backgroud_color, Color.GRAY);
        }

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth((float) 10.0);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("onDraw");
        canvas.drawColor(mBackgroundColor);
        canvas.drawCircle(getX() + 0, getY(), mRadius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
