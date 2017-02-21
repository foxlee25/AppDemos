package com.infifox.fox.howhelper.base;

import com.infifox.fox.howhelper.R;
import com.infifox.fox.howhelper.app.HowHelperApplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import android.view.View;
/**
 * Created by jili on 12/24/16.
 */

public abstract class BaseWithToolbarActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView<P> {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;
    private Unbinder bind;
    private ProgressDialog progressDialog;
    protected P mPresenter;

    protected void onCreate(@Nullable Bundle saveInstanceState){

        super.onCreate(saveInstanceState);
        HowHelperApplication.addActivity(this);
        beforeContentView();
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        mPresenter = createpresenter();
        prepareData(getIntent());
        progressDialog = new ProgressDialog(this);
        initView();
        initlistener();
        initData(saveInstanceState);
    }

    protected abstract void initlistener();

    protected abstract void initView();

    protected abstract P createpresenter();

    protected abstract int getLayoutId();

    protected void showProgressDialog(String msg){
        progressDialog.setMessage(msg);
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(true);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener(){
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                //Todo: 12/24/2016 cancel dialog display do somthing
            }
        });

        progressDialog.show();

    }

    protected void dismissPorgressDialog(){
        if(progressDialog !=null ){
            progressDialog.dismiss();
        }
    }

    public void setPrsenter(P presenter){
        mPresenter = presenter;
    }

    public void showSnackBar(View view, String msg){
        Snackbar.make(view,msg, Snackbar.LENGTH_SHORT).show();
    }

    public void showSnackBar(View view, int msgId){
        Snackbar.make(view,msgId, Snackbar.LENGTH_SHORT).show();
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
    public void showToast(int msgId){
        Toast.makeText(this,msgId,Toast.LENGTH_SHORT).show();
    }
    public void setToolbarTitle(String msg){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(msg);
        }
    }
    public String getToolbarTitle(){
        if(getSupportActionBar() != null){
            return getSupportActionBar().getTitle().toString();
        }
        return getSupportActionBar().getTitle().toString();
    }

    public void setToolbarTitle(int titledId){
        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(titledId);
        }
    }

    protected void onDestory(){
        super.onDestroy();
        bind.unbind();
        if(mPresenter !=null ){
            mPresenter.unSubScribe();
        }
        HowHelperApplication.removeActivity(this);
    }

    protected void initToolbar(){
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }


    protected abstract void prepareData(Intent intent);

    protected abstract P createPresenter();

    protected abstract void beforeContentView();

    protected abstract void initData(Bundle saveInstanceState);

}
