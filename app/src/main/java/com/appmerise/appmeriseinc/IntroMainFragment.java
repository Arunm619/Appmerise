
/*
* Copyrights (R) Arun sudharsan 2017
* Developer name: Arun sudharsan
* Developed App: Appmerise Inc
* Date: 24/07/17
* */
package com.appmerise.appmeriseinc;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroMainFragment extends Fragment {


    public IntroMainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v  = inflater.inflate(R.layout.fragment_intro_main, container, false);


        return v;
    }

}
