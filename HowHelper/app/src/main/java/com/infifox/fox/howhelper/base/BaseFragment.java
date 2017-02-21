package com.infifox.fox.howhelper.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by jili on 12/19/16.
 */

public abstract class BaseFragment <P extends BasePresenter> extends Fragment{

    protected Unbinder bind;
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle saveInstanceState ){
    mPresenter = createPresenter();

        View root = inflater.inflate(getFragmentLayout(),container, false);
        bind = ButterKnife.bind(this,root);
        prepareData();
        initView();
        initListener();
        getData();
        
        return root;

    }

    protected  void changeReadState(View clickedView , int textViewId){

        TextView tvTitle = (TextView) clickedView.findViewById(textViewId); // R.id.tv_question_title ;
//        tvTitle.setTextColor(getResources().getColor(R.color.textReader));

    }


    @Override
    public void onDestroy (){
        super.onDestroy();
        if(bind != null){
            bind.unbind();
        }
        if(mPresenter !=null){
            mPresenter.unSubScribe();
        }

    }

    public void showToast(String msg){
        Toast.makeText(getContext(),msg, Toast.LENGTH_SHORT).show();

    }

    public void showToast(int msgId) {
        Toast.makeText(getContext(), msgId, Toast.LENGTH_SHORT).show();
    }

    public void showSnackBar( View view, String msg){
        Snackbar.make(view, msg,Snackbar.LENGTH_SHORT ).show();
    }

    public void showSnackBar( View view, int msgId){
        Snackbar.make(view, msgId,Snackbar.LENGTH_SHORT ).show();
    }


    protected abstract void getData();

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void prepareData();

    protected abstract int getFragmentLayout();

    protected abstract P createPresenter();


    
}
