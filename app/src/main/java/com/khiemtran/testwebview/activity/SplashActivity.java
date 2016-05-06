package com.khiemtran.testwebview.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.khiemtran.testwebview.R;
import com.khiemtran.testwebview.abstracts.BaseActivity;
import com.khiemtran.testwebview.adapter.TutorialAdapter;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public class SplashActivity extends FragmentActivity {

    private Context mContext;
    private ViewPager mViewPager;
    private ImageView mBtnClose;
    private ImageView mImgIndicator;
    private int[] lstResIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mContext = this;
        initData();
        initView();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBtnClose = (ImageView) findViewById(R.id.btn_close);
        mImgIndicator = (ImageView) findViewById(R.id.img_indicator);

        initViewPager();

        mBtnClose.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TestFBActitvity.class);
                startActivity(intent);
            }
        });
    }

    private void initViewPager() {
        TutorialAdapter fragmentAdapter = new TutorialAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(fragmentAdapter);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {
                mImgIndicator.setImageResource(lstResIndicator[pos]);
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    private int getLayoutID() {
        return R.layout.activity_splash;
    }

    private void initData() {
        lstResIndicator = new int[]{R.drawable.indi_1, R.drawable.indi_2, R.drawable.indi_3,
                R.drawable.indi_4, R.drawable.indi_5, R.drawable.indi_6, R.drawable.indi_7,
                R.drawable.indi_8, R.drawable.indi_9 };
    }
}
