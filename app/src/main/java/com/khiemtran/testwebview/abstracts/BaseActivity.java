package com.khiemtran.testwebview.abstracts;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public abstract class BaseActivity extends Activity{

    public Context mContext;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        mContext = this;
        initData();
        initView();
    }

    protected abstract void initView();

    public void initData() {}

    protected abstract int getLayoutID();
}
