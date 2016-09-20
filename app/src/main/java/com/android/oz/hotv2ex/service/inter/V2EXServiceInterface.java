package com.android.oz.hotv2ex.service.inter;

import com.android.oz.hotv2ex.bean.LatestBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public interface V2EXServiceInterface {
    @GET("topics/latest.json")
    Call<List<LatestBean>> getLatestTopics();

}
