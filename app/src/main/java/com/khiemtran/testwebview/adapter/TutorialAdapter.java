package com.khiemtran.testwebview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.khiemtran.testwebview.fragment.TutorialFragment;

import java.util.List;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public class TutorialAdapter extends FragmentPagerAdapter {

    public TutorialAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
        return new TutorialFragment(arg0);
    }

    @Override
    public int getCount() {
        return 9;
    }

}
