package com.millicent.benfromstupid.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Millicent on 2016/7/10.
 */
public class CustomView extends View {

    //定义初始坐标
    float currentX = 40;
    float currentY = 50;

    //创建画笔
    Paint paint = new Paint();

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 重写view的绘制方法
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //定义画笔颜色
        paint.setColor(Color.BLUE);
        //绘制一个球形(初始x坐标，初始Y坐标，园的半径，画笔)
        canvas.drawCircle(currentX,currentY,15,paint);

    }

    /**
     * 为该组件重写触碰事件的处理方法
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //修改currentX，currentY两个属性
        currentX = event.getX();
        currentY = event.getY();

        //通知组件重新绘制
        invalidate();
        //返回true表明该方法已经处理该事件
        return true;

    }
}
