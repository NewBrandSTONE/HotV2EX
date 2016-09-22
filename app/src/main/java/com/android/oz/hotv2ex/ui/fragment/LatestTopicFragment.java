package com.android.oz.hotv2ex.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.constant.IntentConstant;
import com.android.oz.hotv2ex.http.LatestTopicHttpMethod;
import com.android.oz.hotv2ex.listener.ItemClickListener;
import com.android.oz.hotv2ex.service.V2ExServiceImpl;
import com.android.oz.hotv2ex.ui.activity.TopicDetailActivity;
import com.android.oz.hotv2ex.ui.adapter.LatestTopicAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * @author O.z Young
 * @date 16/9/16
 * @desc 最新主题的Fragment
 */
public class LatestTopicFragment extends Fragment implements ItemClickListener {

    private RecyclerView recyclerview;
    private LinearLayoutManager mLayoutManager;
    private V2ExServiceImpl service;
    private LatestTopicAdapter mAdapter;
    private ArrayList<LatestBean> mDatas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_latest, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        //initData();
        initDataWithRxJava();
        initListener();
    }

    private void initDataWithRxJava() {
        // TODO: 16/9/22 添加上ProgressSubscriber
        LatestTopicHttpMethod.getInstance().getLatestTopic(new Subscriber<List<LatestBean>>() {
            @Override
            public void onCompleted() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "加载完成", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "加载失败!", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNext(final List<LatestBean> latestBeen) {
                mDatas = (ArrayList<LatestBean>) latestBeen;
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setmLatestList((ArrayList<LatestBean>) latestBeen);
                        mAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void initListener() {
        mAdapter.setmListener(this);
    }

    private void initData() {
        /*service = new V2ExServiceImpl();
        final Call<List<LatestBean>> latestNews = service.getLatestNews();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<LatestBean>> response = latestNews.execute();
                    if (response.isSuccessful()) {
                        final List<LatestBean> latestBeanList = response.body();
                        mDatas = (ArrayList<LatestBean>) latestBeanList;
                        if (latestBeanList != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mAdapter.setmLatestList((ArrayList<LatestBean>) latestBeanList);
                                    mAdapter.notifyDataSetChanged();
                                }
                            });
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();*/
    }

    private void initView() {
        recyclerview = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
        mDatas = new ArrayList<>();
        mAdapter = new LatestTopicAdapter(getContext(), mDatas);
        recyclerview.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (mDatas.size() != 0) {
            Intent intent = new Intent(getContext(), TopicDetailActivity.class);
            intent.putExtra(IntentConstant.TO_TOPIC_DETAIL, (Serializable) mDatas.get(position));
            getActivity().startActivity(intent);
        }
    }
}
