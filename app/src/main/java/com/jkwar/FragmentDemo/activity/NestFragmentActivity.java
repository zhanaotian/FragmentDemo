package com.jkwar.FragmentDemo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.ParentFragment;

public class NestFragmentActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new ParentFragment();
    }

}
