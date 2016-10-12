package com.millicent.benfromstupid;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.millicent.benfromstupid.activity.CustomViewOneActivity;
import com.millicent.benfromstupid.activity.PopupWindowsBottomActivity;
import com.millicent.benfromstupid.customview.CustomViewActivity;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;

    private String[] title = {"自定义UI组件","自定义VIEW（一）","底部弹窗"};
    private String[] subtitle = {"跟随手指的小球","自定义view。1.","底部弹窗PopupWindows"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerview_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        MainAdapter mainAdapter = new MainAdapter();

        mainAdapter.setMyOnClick(new MainAdapterOnClick() {
            @Override
            public void onClick(View view, int position) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this,CustomViewActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this,CustomViewOneActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this,PopupWindowsBottomActivity.class));
                        break;
                }
            }
        });
        recyclerView.setAdapter(mainAdapter);

    }

    private class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyHolderView>{

        private MainAdapterOnClick myMainAdapterOnClick;

        public void setMyOnClick(MainAdapterOnClick click){
            this.myMainAdapterOnClick = click;
        }

        @Override
        public MyHolderView onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(MainActivity.this,R.layout.adapter_main,null);
            return new MyHolderView(view,myMainAdapterOnClick);
        }

        @Override
        public void onBindViewHolder(MyHolderView holder, int position) {
            holder.tv_title.setText(title[position]);
            holder.tv_subtitle.setText(subtitle[position]);
        }

        @Override
        public int getItemCount() {
            return title.length;
        }

        public class MyHolderView extends RecyclerView.ViewHolder implements View.OnClickListener{

            public TextView tv_title,tv_subtitle;
            private MainAdapterOnClick mMainAdapterOnClick;

            public MyHolderView(View itemView,MainAdapterOnClick onClickListener) {
                super(itemView);

                this.mMainAdapterOnClick = onClickListener;
                tv_title = (TextView) itemView.findViewById(R.id.tv_title);
                tv_subtitle = (TextView) itemView.findViewById(R.id.tv_subtitle);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {
                if (mMainAdapterOnClick != null){
                    mMainAdapterOnClick.onClick(view,getPosition());
                }
            }
        }
    }
}
