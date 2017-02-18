package com.li.ji.fragmentdatademo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by jili on 2/16/17.
 */

public class MyFragment extends Fragment {

    private Button mButton;

    private EditText mEditText;

    private MyListener mMyListener;



    //set call back interface
    public interface MyListener {

        void sendContend(String info);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        mMyListener = (MyListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment, container, false);
        mEditText = (EditText) view.findViewById(R.id.editText1);
        mButton = (Button) view.findViewById(R.id.button1);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // pass the value of fragment data to Activity ;
                String str = mEditText.getText().toString();
                mMyListener.sendContend(str);
            }
        });

        return view;
    }



}
