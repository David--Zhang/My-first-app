package com.example.damoyishi.developertraining;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by damoyishi on 1/8/15.
 */
public class FragmentOne extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one_layout, container, false);
        return v;
        //Same as : Return inflater.inflate(R.layout.fragment_one_layout, container, false);
    }
}
