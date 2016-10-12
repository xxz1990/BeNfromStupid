package com.millicent.benfromstupid.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.millicent.benfromstupid.R;

/**
 * Created by Milct on 2016/7/29.
 */
public class CustomViewOne extends View {
    /**
     * 文本的内容
     */
    private String mTitleText;
    /**
     * 文本的颜色
     */
    private int mTitleTextColor;
    /**
     * 文本的大小
     */
    private int mTitleTextSize;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 文本绘制的矩形范围
     */
    private Rect mBound;


    public CustomViewOne(Context context) {
        this(context, null);
    }

    public CustomViewOne(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取自定义样式的属性
         * 在values下attrs文件里的资源
         */
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomViewOne, defStyleAttr, 0);
        //得到自定义属性的数量
        int n = a.getIndexCount();

        for (int i = 0; i < n; i++) {
            //根据下标得到具体的属性
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomViewOne_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomViewOne_titleTextcolor:
                    //默认颜色为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomViewOne_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }
        }

        a.recycle();

        /**
         * 根据文本设置花出来
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        //控制文本绘制在一个矩形里
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(getMeasuredWidth(), getHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setColor(Color.BLUE);

        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);

        mPaint.setColor(Color.WHITE);

        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

}
