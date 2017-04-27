package com.jkwar.FragmentDemo.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.LifecycleFragment;

/**
 * 创建人:     JKwar
 * 创建时间:   2016/4/25 21:23
 * 类名:      LifecycleActivity
 * 描述:      Fragment生命周期
 * 修改人:
 * 修改时间:
 */
public class LifecycleActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return LifecycleFragment.newInstance("fragment 生命周期");
    }
}
