package com.jkwar.FragmentDemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.jkwar.FragmentDemo.R;
import static com.jkwar.FragmentDemo.fragment.FruitsListFragment.REQUEST_DETAIL;


public class FruitsDetailsFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public FruitsDetailsFragment() {
    }

    public static FruitsDetailsFragment newInstance(String param1) {
        FruitsDetailsFragment fragment = new FruitsDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fragment_fruits_details, container, false);
        final EditText editText= (EditText) view.findViewById(R.id.fruits_details_ed);
        editText.setText(mParam1);
        view.findViewById(R.id.updateBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(REQUEST_DETAIL, editText.getText().toString());
                getActivity().setResult(110, intent);
                getActivity().finish();
            }
        });
        return view;
    }
}
