package com.android.oz.hotv2ex.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;

import java.util.ArrayList;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public class LatestTopicAdapter extends RecyclerView.Adapter<LatestTopicAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<LatestBean> mLatestList;

    public LatestTopicAdapter(Context context, ArrayList<LatestBean> list) {
        mContext = context;
        mLatestList = list;
    }

    public void setmLatestList(ArrayList<LatestBean> mLatestList) {
        this.mLatestList = mLatestList;
    }

    /**
     * 定义视图
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.latesttopic_item, null, false);
        //MyViewHolder holder = new MyViewHolder(view);
        return new MyViewHolder(view);
    }

    /**
     * 加载数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ((MyViewHolder) holder).tv_title.setText(mLatestList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return mLatestList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
