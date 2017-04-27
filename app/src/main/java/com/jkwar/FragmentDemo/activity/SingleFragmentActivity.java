package com.jkwar.FragmentDemo.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.jkwar.FragmentDemo.R;

/**
 * 创建人:     JKwar
 * 创建时间:   2016/4/25 19:12
 * 类名:      SingleFragmentActivity
 * 描述:      抽象
 * 修改人:
 * 修改时间:
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    public abstract Fragment createFragment();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        if (savedInstanceState!=null) {
            Log.d("SingleFragmentActivity", "onCreate: "+savedInstanceState);
        }
        //fragment管理器
        FragmentManager fm = getSupportFragmentManager();
        //根据tag查找fragment实例
        //fm.findFragmentByTag("");
        //根据id查找fragment实例
        Fragment fragment = fm.findFragmentById(R.id.content);
        //通过判断savedInstanceState时候为空，登出activity时候重新创建
        if (fragment == null || savedInstanceState == null) {
            fragment = createFragment();
            //添加
            fm.beginTransaction().add(R.id.content, fragment).commit();
        }
    }
}
