package com.millicent.benfromstupid.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.millicent.benfromstupid.R;
import com.millicent.benfromstupid.weight.BottomPopupWindows;

/**
 * Created by Milct on 2016/8/12.
 */
public class PopupWindowsBottomActivity extends Activity{

    private Button btnBottomPopupWindows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindbottom);

        initView();
    }

    private void initView() {
        btnBottomPopupWindows = (Button) findViewById(R.id.btn_bottom);
        btnBottomPopupWindows.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_bottom:
                    BottomPopupWindows bottomPopupWindows = new BottomPopupWindows(PopupWindowsBottomActivity.this, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (v.getId()==R.id.btn_photo)
                                Log.i("TAG","拍照");
                            if (v.getId()==R.id.select_photo)
                                Log.i("TAG","选择照片");
                        }
                    },new String[]{"nan","nv"});
                    bottomPopupWindows.showAtLocation(PopupWindowsBottomActivity.this.findViewById(R.id.main),
                            Gravity.BOTTOM|Gravity.CENTER_VERTICAL, 120, 120);


                    break;
            }
        }
    };
}
