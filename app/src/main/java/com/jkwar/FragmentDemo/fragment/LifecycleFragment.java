package com.jkwar.FragmentDemo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jkwar.FragmentDemo.R;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LifecycleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LifecycleFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private final String TAG = LifecycleFragment.class.getSimpleName();

    private String mParam1;

    public LifecycleFragment() {
        // Required empty public constructor
    }

    public static LifecycleFragment newInstance(String param1) {
        LifecycleFragment fragment = new LifecycleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    //在Fragment已与Activity关联时调用
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach: " + mParam1);
    }

    public void setParam(String param) {
        Log.d(TAG, "setParam: "+param);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        Log.d(TAG, "onCreate: " + mParam1);
    }

    //为Fragment加载布局时调用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + mParam1);
        View view = inflater.inflate(R.layout.fragment_lifecycle, container, false);
        TextView textView = (TextView) view.findViewById(R.id.lifecycle_txt);
        textView.setText(mParam1);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: " + mParam1);
    }

    //当Activity中的onCreate方法执行完后调用
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated: " + mParam1);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + mParam1);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + mParam1);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + mParam1);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + mParam1);
    }

    //Fragment中的布局被移除时调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView: " + mParam1);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + mParam1);
    }

    //Fragment和Activity解除关联的时候调用
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: " + mParam1);
    }
}
