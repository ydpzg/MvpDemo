package com.hgsoft.mvpdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by YUDAPEI on 2017/7/27.
 */

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 先对每个子view做一次measureChild得到getMeasuredWidth,getMeasuredHeight
        for(int j = 0;j < getChildCount();j++) {
            View view = getChildAt(j);
            measureChild(view, widthMeasureSpec, heightMeasureSpec);
        }
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        // 再对每个子view做一次layout,设置子view的布局位置
        int left = 0;
        int top = 0;
        for(int j = 0;j < getChildCount();j++) {
            View view = getChildAt(j);
            if (left + view.getMeasuredWidth() > getMeasuredWidth()) {
                top += view.getMeasuredHeight();
                left = 0;
            }
            view.layout(left, top, left + view.getMeasuredWidth(), top + view.getMeasuredHeight());
            left += view.getMeasuredWidth();
        }
    }
}
