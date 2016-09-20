package com.android.oz.hotv2ex.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.constant.IntentConstant;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @author O.z Young
 * @date 16/9/19
 * @desc ${CURSOR}
 */
public class TopicDetailActivity extends Activity {

    private Toolbar mToolbar;
    private LatestBean mLatestBean;
    private TextView mTv_content_rendered;
    private TextView mTv_usertagline;
    private TextView mTv_username;
    private SimpleDraweeView mSdv_usericon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);

        initData();
        initView();
    }

    private void initData() {
        Intent intent = getIntent();
        mLatestBean = (LatestBean) intent.getSerializableExtra(IntentConstant.TO_TOPIC_DETAIL);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(mLatestBean.getNode().getTitle());

        mTv_content_rendered = (TextView) findViewById(R.id.tv_content_rendered);
        mTv_usertagline = (TextView) findViewById(R.id.tv_usertagline);
        mTv_username = (TextView) findViewById(R.id.tv_username);
        mSdv_usericon = (SimpleDraweeView) findViewById(R.id.sdv_usericon);

        mTv_content_rendered.setText(Html.fromHtml(mLatestBean.getContent_rendered()));

        mTv_usertagline.setText(mLatestBean.getMember().getTagline());
        mTv_username.setText(mLatestBean.getMember().getUsername());

        mSdv_usericon.setImageURI("https:" + mLatestBean.getMember().getAvatar_large());
    }
}
