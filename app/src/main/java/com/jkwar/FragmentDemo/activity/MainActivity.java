package com.jkwar.FragmentDemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.jkwar.FragmentDemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.stateaddBtn)
    Button stateaddBtn;
    @BindView(R.id.dynamicaddBtn)
    Button dynamicaddBtn;
    @BindView(R.id.lifecycleBtn)
    Button lifecycleBtn;
    @BindView(R.id.fragmentTaskBtn)
    Button fragmentTaskBtn;
    @BindView(R.id.startActivityForResultBtn)
    Button startActivityForResultBtn;
    @BindView(R.id.nest_fragmentBtn)
    Button nestFragmentBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.stateaddBtn, R.id.dynamicaddBtn, R.id.lifecycleBtn, R.id.fragmentTaskBtn, R.id.startActivityForResultBtn,R.id.nest_fragmentBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stateaddBtn:
                startActivity(new Intent(MainActivity.this, StateAddActivity.class));
                break;
            case R.id.dynamicaddBtn:
                startActivity(new Intent(MainActivity.this, DynamicAddActivity.class));
                break;
            case R.id.lifecycleBtn:
                startActivity(new Intent(MainActivity.this, LifecycleActivity.class));
                break;
            case R.id.fragmentTaskBtn:
                startActivity(new Intent(MainActivity.this, FragmentTaskActivity.class));
                break;
            case R.id.startActivityForResultBtn:
                startActivity(new Intent(MainActivity.this, StartActivityForResultActivity.class));
                break;
            case R.id.nest_fragmentBtn:
                startActivity(new Intent(MainActivity.this, NestFragmentActivity.class));
                break;
        }
    }
}
