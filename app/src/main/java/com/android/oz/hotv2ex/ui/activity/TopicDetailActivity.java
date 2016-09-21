package com.android.oz.hotv2ex.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.constant.HttpConstant;
import com.android.oz.hotv2ex.constant.IntentConstant;
import com.android.oz.hotv2ex.util.WebViewUtils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * @author O.z Young
 * @date 16/9/19
 * @desc ${CURSOR}
 */
public class TopicDetailActivity extends Activity {

    private Toolbar mToolbar;
    private LatestBean mLatestBean;
    //private TextView mTv_content_rendered;
    private WebView mWebView;
    private TextView mTv_usertagline;
    private TextView mTv_username;
    private TextView mTv_topic_title;
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
        mToolbar.setTitleTextColor(Color.WHITE);

        mTv_topic_title = (TextView) findViewById(R.id.tv_topic_title);
        //mTv_content_rendered = (TextView) findViewById(R.id.tv_content_rendered);
        mTv_usertagline = (TextView) findViewById(R.id.tv_usertagline);
        mTv_username = (TextView) findViewById(R.id.tv_username);
        mSdv_usericon = (SimpleDraweeView) findViewById(R.id.sdv_usericon);
        mWebView = (WebView) findViewById(R.id.webview);

        // mTv_content_rendered.setText(Html.fromHtml(mLatestBean.getContent_rendered()));
        mTv_topic_title.setText(mLatestBean.getTitle());
        mTv_usertagline.setText(mLatestBean.getMember().getTagline());
        mTv_username.setText(mLatestBean.getMember().getUsername());

        mWebView.getSettings().setJavaScriptEnabled(true);
        // 隐藏滚动条
        mWebView.setVerticalScrollBarEnabled(false);

        // TODO: 16/9/21 这里可能需要优化,将来应该把时间的角标也添加到html中,不要分开创建
        String htmlContent = WebViewUtils.webviewFormatHtmlContent(mLatestBean.getContent_rendered());
        // 添加创建时间
        String createTimeFooter = WebViewUtils.createTimeFooter(mLatestBean.getCreated());
        htmlContent += createTimeFooter;

        mWebView.loadDataWithBaseURL(null, htmlContent, "text/html", "utf-8", null);

        // 设置圆角图片
        RoundingParams roundingParams = RoundingParams.asCircle();
        mSdv_usericon.getHierarchy().setRoundingParams(roundingParams);
        mSdv_usericon.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        mSdv_usericon.setImageURI(HttpConstant.HTTPS + mLatestBean.getMember().getAvatar_large());
    }
}
