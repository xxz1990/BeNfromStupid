package com.millicent.benfromstupid.weight;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.millicent.benfromstupid.R;

import java.util.zip.Inflater;

/**
 * Created by Milct on 2016/8/12.
 */
public class BottomPopupWindows extends PopupWindow {

    private View mView;
    private TextView btnPhoto;
    private TextView btnSelectPhoto;
    private TextView btnCancle;

    public BottomPopupWindows(Context context, View.OnClickListener itemsOnClick,String[] strings) {
        super(context);
        initView(context,itemsOnClick,strings);
    }


    private void initView(Context context , View.OnClickListener itemsOnClick ,String[] strings) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.bottompopupwindow, null);
        btnCancle = (TextView) mView.findViewById(R.id.btn_cancle);
        btnPhoto = (TextView) mView.findViewById(R.id.btn_photo);
        btnSelectPhoto = (TextView) mView.findViewById(R.id.select_photo);

        // 设置按钮监听
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAG", "取消项目");
                dismiss();
            }
        });

        btnPhoto.setText(strings[0]);
        if (strings.length == 1){
            btnSelectPhoto.setVisibility(View.GONE);
        }
        if (strings.length > 1){
            btnSelectPhoto.setText(strings[1]);
            btnSelectPhoto.setOnClickListener(itemsOnClick);
        }

        btnPhoto.setOnClickListener(itemsOnClick);


        //设置PopupWindow的View
        this.setContentView(mView);
        //设置PopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        //设置PopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);
        //设置PopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//        this.setAnimationStyle(R.style.Animation);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);


    }

}
