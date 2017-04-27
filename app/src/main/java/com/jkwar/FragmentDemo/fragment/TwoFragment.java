package com.jkwar.FragmentDemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkwar.FragmentDemo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements View.OnClickListener{


    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        view.findViewById(R.id.id_fragment_two_btn).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fts = getFragmentManager().beginTransaction();
        fts.replace(R.id.fragmenttask_content, new ThreeFragment(),"one");
        fts.addToBackStack("two_fragment");
        fts.commit();
    }
}
