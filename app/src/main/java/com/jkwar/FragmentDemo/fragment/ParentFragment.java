package com.jkwar.FragmentDemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jkwar.FragmentDemo.R;

/**
 * 创建人:     JKwar
 * 创建时间:   2016/4/27 16:04
 * 类名:      ParentFragment
 * 描述:      嵌套fragment
 * 修改人:
 * 修改时间:
 */
public class ParentFragment extends Fragment {
    public ParentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_parent, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Fragment childFragment = new ChildFragment();
        //与嵌套进行交换应该使用getSupportFragmentManager，而不是getChildFragmentManager
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.child_fragment_container, childFragment).commit();
    }

    public static class ChildFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_child, container, false);
        }
    }
}
