package com.khiemtran.testwebview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.khiemtran.testwebview.R;

/**
 * Created by khiem.tran on 06/05/2016.
 */
public class TutorialFragment extends Fragment {
    private int currentPosition;

    public TutorialFragment(){}

    public TutorialFragment(int position){
        currentPosition = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tutorial, null);

        initView(view);

        return view;
    }

    private void initView(View view) {
        TextView tvPageNumber = (TextView) view.findViewById(R.id.page_number);
        tvPageNumber.setText(String.valueOf(currentPosition));
    }
}
