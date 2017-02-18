package com.li.ji.fragmentdatademo;

import android.app.Fragment;
import com.li.ji.fragmentdatademo.MyFragment.MyListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListener {

    private TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView)findViewById(R.id.textView);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.layout_container_fragment,new MyFragment());
        transaction.commit();

    }

    @Override
    public void sendContend(String info) {
        Log.d("TAG","   " + info);

        if ( null != info ){
            Log.d("TAG","   1 :" + info);
            mTextView.setText(info);
        } else{
            Toast.makeText(MainActivity.this, "please input something ...",Toast.LENGTH_SHORT).show();
        }
    }
}
