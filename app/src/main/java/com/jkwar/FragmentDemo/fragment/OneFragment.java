package com.jkwar.FragmentDemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jkwar.FragmentDemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements View.OnClickListener {


    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        view.findViewById(R.id.id_fragment_one_btn).setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        TwoFragment twoFragment = new TwoFragment();
        FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.hide(this);
        tx.add(R.id.fragmenttask_content, twoFragment, "Two");
        tx.addToBackStack("twoFragment");
        tx.commit();
    }
}
