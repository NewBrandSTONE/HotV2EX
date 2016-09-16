package com.android.oz.hotv2ex.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.android.oz.hotv2ex.R;
import com.android.oz.hotv2ex.ui.fragment.AllFragment;
import com.android.oz.hotv2ex.ui.fragment.HotTopicFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * @author O.z Young
 * @date 16/9/16
 * @desc ${CURSOR}
 */
public class HomeActivity extends FragmentActivity {

    private SmartTabLayout mSmartLayout;
    private ViewPager mViewPager;
    private MyAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    private void initView() {
        mSmartLayout = (SmartTabLayout) findViewById(R.id.home_strip);
        mViewPager = (ViewPager) findViewById(R.id.home_tabs);
        mAdapter = new MyAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);

        mSmartLayout.setViewPager(mViewPager);
    }

    private class MyAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"最热", "全部"};
        private ArrayList<Fragment> mFragmentList;


        public MyAdapter(FragmentManager fm) {
            super(fm);
            mFragmentList = new ArrayList<>();
            mFragmentList.add(new AllFragment());
            mFragmentList.add(new HotTopicFragment());
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }
}
