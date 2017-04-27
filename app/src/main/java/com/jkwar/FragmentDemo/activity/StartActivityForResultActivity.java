package com.jkwar.FragmentDemo.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.jkwar.FragmentDemo.R;
import com.jkwar.FragmentDemo.fragment.FruitsListFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jkwar.FragmentDemo.fragment.FruitsListFragment.REQUEST_CODE;
import static com.jkwar.FragmentDemo.fragment.FruitsListFragment.REQUEST_DETAIL;
import static java.util.Arrays.asList;

public class StartActivityForResultActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return new FruitsListFragment();
    }
}
