package com.jkwar.FragmentDemo.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.OneFragment;

public class FragmentTaskActivity extends AppCompatActivity {
    private OneFragment oneFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_task);
        final FragmentManager fm = getSupportFragmentManager();
        //创建事务
        FragmentTransaction fx = fm.beginTransaction();
        if (oneFragment == null) {
            oneFragment = new OneFragment();
            fx.addToBackStack("one_Fragment");
            fx.add(R.id.fragmenttask_content, oneFragment, "oneFragment").commit();
        }

        findViewById(R.id.exitallBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
            }
        });
    }
}
