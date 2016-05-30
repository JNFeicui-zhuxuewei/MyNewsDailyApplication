package com.example.mynewsdailyapplication.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mynewsdailyapplication.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    private ArrayList <View>  mList;
 int[] pics = {R.mipmap.image1,R.mipmap.image2,R.mipmap.image3,R.mipmap.image4};


    private Button mBtnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
    }

    private void initview() {
        mBtnSkip = (Button) findViewById(R.id.btn_skip);
        mBtnSkip.setOnClickListener(this);
        mList=  new ArrayList<>();
        mViewPager = (ViewPager) findViewById(R.id.vp_guide);


        for (int i = 0; i <pics.length ; i++) {
            ImageView iv = new ImageView(this);
            // 填充整个屏幕
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(pics[i]);
            mList.add(iv);
            
        }
        mViewPager.setAdapter(new  MyPagerAdapter(mList));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
        finish();

    }

    private class MyPagerAdapter extends PagerAdapter {
        private  ArrayList<View> mList;
        public MyPagerAdapter(ArrayList<View> list) {
            mList = list;
        }


//        // 界面切换时调用
//        public  void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
//
//        }
//        // 界面切换后调用
//        public void onPageScrolled(int position){
//            setPoint(position);
//            if (position >=3){
//                Intent intent = new Intent(LeadActivity.this,SplashActivity.class);
//                startActivity(intent);
//                finish();
//                SharedPreferences preference = getSharedPreferences("runconfig",MODE_PRIVATE);
//                SharedPreferences.Editor editer = preference.edit();
//                editer.putBoolean("isFirstRun",false);
//                editer.apply();
//            }
//
//        }
//        // 滑动状态变化时调用
//        public  void  onPageScrollStateChanged(int state){
//
//        }
//
//        private  class  MyPagerAdapter extends PagerAdapter{
//            private ArrayList<View> list;
//            public MyPagerAdapter(ArrayList<View> list){
//                this.list = list;
//            }
//        }
  // 初始化position 展现到界面上来
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           container.addView(mList.get(position),0);
            return mList.get(position);

        }
  //  当不可见是 销毁position
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mList.get(position));
        }

        @Override
        public int getCount() {
            if (mList != null){
                return mList.size();
            }
            return  0;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
