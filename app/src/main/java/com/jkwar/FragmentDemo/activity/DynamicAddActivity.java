package com.jkwar.FragmentDemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.FooFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建人:     JKwar
 * 创建时间:   2016/4/25 18:57
 * 类名:      DynamicAddActivity
 * 描述:      动态添加fragment
 * 修改人:
 * 修改时间:
 */
public class DynamicAddActivity extends AppCompatActivity implements FooFragment.OnItemSelectedListener{
    @BindView(R.id.addBtn)
    Button addBtn;
    @BindView(R.id.removeBtn)
    Button removeBtn;
    @BindView(R.id.hideBtn)
    Button hideBtn;
    @BindView(R.id.showBtn)
    Button showBtn;
    @BindView(R.id.replaceBtn)
    Button replaceBtn;
    //fragment 管理器
    FragmentManager fm;
    FooFragment fooFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add);
        ButterKnife.bind(this);
        //初始化
        fm = getSupportFragmentManager();
    }

    @OnClick({R.id.addBtn, R.id.removeBtn, R.id.hideBtn, R.id.showBtn, R.id.replaceBtn})
    public void onViewClicked(View view) {
        //fragment事务
        FragmentTransaction bt = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.addBtn:
                if (fooFragment == null) {
                    fooFragment = FooFragment.newInstance("苹果");
                    fooFragment.onAttach(this);
                    bt.add(R.id.dynamic_content, fooFragment, "fooFragment");
                } else {
                    bt.replace(R.id.dynamic_content, fooFragment, "fooFragment");
                }
                break;
            case R.id.removeBtn:
                if (fooFragment != null && fooFragment.isAdded()) {
                    bt.remove(fooFragment);
                }
                break;
            case R.id.hideBtn:
                if (fooFragment != null && fooFragment.isVisible()) {
                    bt.hide(fooFragment);
                }
                break;
            case R.id.showBtn:
                if (fooFragment != null && fooFragment.isHidden()) {
                    bt.show(fooFragment);
                }
                break;
            case R.id.replaceBtn:
                FooFragment ff = FooFragment.newInstance("梨子");
                bt.replace(R.id.dynamic_content, ff, "ff");
                break;
        }
        //提交
        bt.commit();
    }

    @Override
    public void onItemSelected(String link) {
        if (fooFragment!=null&&fooFragment.isVisible()) {
            fooFragment.setParam(link+1);
        }
    }
}
