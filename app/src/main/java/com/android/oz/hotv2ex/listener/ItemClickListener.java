package com.android.oz.hotv2ex.listener;

import android.view.View;

/**
 * @author O.z Young
 * @date 16/9/19
 * @desc 给ReyclerView设置的点击事件
 */
public interface ItemClickListener {

    /**
     * item点击事件
     *
     * @param view
     */
    void onItemClick(View view, int position);
}
