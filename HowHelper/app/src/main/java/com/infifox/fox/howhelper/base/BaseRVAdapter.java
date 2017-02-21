package com.infifox.fox.howhelper.base;

import com.infifox.fox.howhelper.R;
import com.infifox.fox.howhelper.bean.AdapterBean;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jili on 12/19/16.
 */

public abstract class BaseRVAdapter<T extends AdapterBean> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //data source
    protected List<T> mData;
    //TODO
    protected View mHeaderView ;
    protected static final int TYPE_ITEM = 0;
    protected static final int TYPE_TITLE = 1;
    protected static final int TYPE_FOOTER = 2;
    protected static final int TYPE_HEADER = 3;
    protected static final int TYPE_NO_IMG_ITEM = 4;
    protected static final int TYPE_EMPTY_VIEW = 5;

    private int mFooterState;
    public static final int STATE_LOADING = -1 ;
    public static final int STATE_NO_MORE = -2 ;
    public static final int STATE_NO_FOOTER = -3 ;

    public BaseRVAdapter(List<T> data) {
        this.mData = data;
    }

    public View getHeaderView(){
        return mHeaderView;
    }

    public void setHeaderView (View headerView){
        T headerBean  = createBean(AdapterBean.TYPE_HEADER);
        mData.add(0,headerBean);
        mHeaderView = headerView;
        notifyItemChanged(0);
    }

    /**
     * 通过反射创建一个header 或 footer bean
     *
     * @param type header footer
     * @return
     */
    private T createBean(int type) {
        try {
            ParameterizedType pt = (ParameterizedType) this.getClass()
                    .getGenericSuperclass();
            Class<T> clazz = (Class<T>) pt.getActualTypeArguments()[0];
            T bean = clazz.newInstance();
            bean.setShowType(type);
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
       View itemView;
        if(viewType == TYPE_ITEM){
            itemView = LayoutInflater.from(parent.getContext()).inflate(getItemLayout(),parent, false);
            return  getItemViewHolder(itemView);
        }
        else if(viewType == TYPE_TITLE){
            itemView = LayoutInflater.from(parent.getContext()).inflate(getTitleLayout(),parent, false);
            return  getItemViewHolder(itemView);
            }    else if(viewType == TYPE_FOOTER){
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_item,parent, false);
            return  getItemViewHolder(itemView);
        }else if(viewType == TYPE_HEADER) {

            return new HeaderViewHolder(mHeaderView);
        }else {
            return  createOtherTypeViewHolder(parent,viewType);

        }
    }

    protected abstract RecyclerView.ViewHolder createOtherTypeViewHolder(ViewGroup parent, int viewType);


    protected abstract int getTitleLayout();

    protected abstract RecyclerView.ViewHolder getItemViewHolder(View itemView);

    protected abstract int getItemLayout();

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public T getItem(int position){
        return mData.get(position);
    }

    /***
     *  add footter , show loading more
     */
    public void addFooter(){
        T footerBean = createBean(AdapterBean.TYPE_FOOTER);
        mData.add(footerBean);
        setFooterState(STATE_LOADING);
        notifyDataSetChanged();

    }

    /**
     *  remove footer display
     */
    public void removerFooter(){
        int lastPosition = mData.size() -1 ;
        int itemViewType = getItemViewType(lastPosition);
        if(itemViewType == TYPE_FOOTER){
            mData.remove(lastPosition);
            setFooterState(STATE_NO_FOOTER);
            notifyDataSetChanged();
        }
    }

    public int getFooterState(){
        return mFooterState;
    }

    private void setFooterState(int footerState) {
        this.mFooterState = footerState;
    }

    /***
     *  add data
     */
    public void addDataList(List<T> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public void replaceData(List<T> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();

    }

    protected  abstract int getItemType(int position);

    @Override
    public int getItemViewType(int position){
        return getItemType(position);
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_loading)
        TextView tvLoading;
        @BindView(R.id.progressBar)
        ContentLoadingProgressBar progressbar;

        public FooterViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }



    public class HeaderViewHolder extends RecyclerView.ViewHolder{
        public HeaderViewHolder(View itemView){
            super(itemView);
        }
    }


}
