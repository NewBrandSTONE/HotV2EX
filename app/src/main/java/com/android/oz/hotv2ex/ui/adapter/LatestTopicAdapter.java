package com.android.oz.hotv2ex.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.bean.MemberBean;
import com.android.oz.hotv2ex.listener.ItemClickListener;
import com.android.oz.hotv2ex.util.TimeUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public class LatestTopicAdapter extends RecyclerView.Adapter<LatestTopicAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<LatestBean> mLatestList;

    private ItemClickListener mListener;

    public void setmListener(ItemClickListener mListener) {
        this.mListener = mListener;
    }

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
        return new MyViewHolder(view, mListener);
    }

    /**
     * 加载数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 创建的时间
        long createdTime = mLatestList.get(position).getCreated();

        // 用户信息
        MemberBean userMember = mLatestList.get(position).getMember();

        // 回复数
        StringBuilder repliesSB = new StringBuilder("回复数：");
        repliesSB.append(mLatestList.get(position).getReplies());

        holder.tv_title.setText(mLatestList.get(position).getTitle());
        holder.tv_post_time.setText(TimeUtils.buildSimpleDate(createdTime));
        holder.tv_replies.setText(repliesSB.toString());

        // 设置圆角图片
        RoundingParams roundingParams = RoundingParams.asCircle();
        holder.iv_usericon.getHierarchy().setRoundingParams(roundingParams);
        holder.iv_usericon.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        holder.iv_usericon.setImageURI("https:" + userMember.getAvatar_large());
    }


    @Override
    public int getItemCount() {
        return mLatestList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_title;
        private TextView tv_post_time;
        private TextView tv_replies;
        private SimpleDraweeView iv_usericon;
        private ItemClickListener mListener;

        public MyViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_post_time = (TextView) itemView.findViewById(R.id.tv_post_time);
            tv_replies = (TextView) itemView.findViewById(R.id.tv_replies);
            iv_usericon = (SimpleDraweeView) itemView.findViewById(R.id.iv_usericon);

            mListener = listener;
            // 设置监听事件
            itemView.setOnClickListener(this);
        }

        /**
         * 点击事件监听
         *
         * @param v
         */
        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
