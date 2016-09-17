package com.android.oz.hotv2ex.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.service.V2ExServiceImpl;
import com.android.oz.hotv2ex.ui.adapter.LatestTopicAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author O.z Young
 * @date 16/9/16
 * @desc 最新主题的Fragment
 */
public class LatestTopicFragment extends Fragment {

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
        initData();
    }

    private void initData() {
        service = new V2ExServiceImpl();
        final Call<List<LatestBean>> latestNews = service.getLatestNews();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<List<LatestBean>> response = latestNews.execute();
                    if (response.isSuccessful()) {
                        final List<LatestBean> latestBeanList = response.body();
                        if (latestBeanList != null) {
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.v("Oz", "latestBeanListSize-->" + latestBeanList.size());
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
        }).start();
    }

    private void initView() {
        recyclerview = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(mLayoutManager);
        mDatas = new ArrayList<>();
        mAdapter = new LatestTopicAdapter(getContext(), mDatas);
        recyclerview.setAdapter(mAdapter);
    }
}
