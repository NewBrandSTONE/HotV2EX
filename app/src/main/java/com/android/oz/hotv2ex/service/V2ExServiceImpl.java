package com.android.oz.hotv2ex.service;

import com.android.oz.hotv2ex.api.V2EX;
import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.service.inter.V2EXServiceInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author O.z Young
 * @date 16/9/17
 * @desc ${CURSOR}
 */
public class V2ExServiceImpl {

    public Call<List<LatestBean>> getLatestNews() {
        // 默认需要通知ConverFactory
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(V2EX.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        V2EXServiceInterface service = retrofit.create(V2EXServiceInterface.class);
        return service.getLatestTopics();
        /*Call<List<LatestBean>> latestTopics = service.getLatestTopics();
        latestTopics.enqueue(new Callback<List<LatestBean>>() {
            @Override
            public void onResponse(Call<List<LatestBean>> call, Response<List<LatestBean>> response) {
                //Log.v("Oz", "请求成功" + response.body().get(0).getTitle());
                Log.v("Oz", "请求成功" + response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<LatestBean>> call, Throwable t) {
                Log.v("Oz", "请求失败");
            }
        });
        return null;*/
    }
}
