package com.android.oz.hotv2ex.service;

import com.android.oz.hotv2ex.bean.LatestBean;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public interface IAPIService {
    /**
     * 获取最新主题列表
     *
     * @return
     */
    @GET("topics/latest.json")
    Observable<List<LatestBean>> getLatestTopics();
}
