package com.jkwar.FragmentDemo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.FruitsDetailsFragment;
import com.jkwar.FragmentDemo.fragment.FruitsListFragment;

import static com.jkwar.FragmentDemo.fragment.FruitsListFragment.REQUEST_DETAIL;

public class FruitsDetailsActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return FruitsDetailsFragment.newInstance(getIntent().getStringExtra(REQUEST_DETAIL));
    }

}
