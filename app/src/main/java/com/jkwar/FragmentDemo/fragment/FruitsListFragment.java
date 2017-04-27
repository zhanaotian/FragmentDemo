package com.jkwar.FragmentDemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jkwar.FragmentDemo.activity.FruitsDetailsActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FruitsListFragment extends ListFragment {
    public static final int REQUEST_CODE=0x110;
    public static final String REQUEST_DETAIL="request_detail";
    private ArrayAdapter<String> mAdapter;

    private int mPostion;

    private List<String> mList = Arrays.asList("苹果", "香蕉", "玻璃", "梨子", "西瓜", "橙子");

    public FruitsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mPostion = position;
        Intent intent = new Intent(getActivity(), FruitsDetailsActivity.class);
        intent.putExtra(REQUEST_DETAIL, mList.get(position));
        //跳转
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mList);
        //设置适配器
        setListAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //修改数据
        if (requestCode==REQUEST_CODE) {
            mList.set(mPostion,data.getStringExtra(REQUEST_DETAIL));
            mAdapter.notifyDataSetChanged();
        }
    }
}
