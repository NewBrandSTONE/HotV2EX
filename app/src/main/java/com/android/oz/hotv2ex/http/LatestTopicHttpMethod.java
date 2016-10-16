package com.android.oz.hotv2ex.http;

import com.android.oz.hotv2ex.bean.LatestBean;
import com.android.oz.hotv2ex.constant.HttpConstant;
import com.android.oz.hotv2ex.service.IAPIService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author O.z Young
 * @date 16/9/22
 * @desc ${CURSOR}
 */

public class LatestTopicHttpMethod {

    private Retrofit mRetrofit;
    private IAPIService mAPIService;

    // 将构造方法私有化
    private LatestTopicHttpMethod() {
        // 手工创建一个OkHttpclient并设置超时时间
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(HttpConstant.DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(V2EX.API_BASE_URL)
                .build();

        mAPIService = mRetrofit.create(IAPIService.class);
    }

    // 在访问LatestTopicHttpMethod时创建单例
    private static class SingletonHolder {
        private static final LatestTopicHttpMethod INSTANCE = new LatestTopicHttpMethod();
    }

    // 获取单例
    public static LatestTopicHttpMethod getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取最新话题的数据
     *
     * @param subscriber 由调用者传过来的观察者对象
     */
    public void getLatestTopic(Subscriber<List<LatestBean>> subscriber) {
        //        movieService.getTopMovie(start, count)
//                .map(new HttpResultFunc<List<Subject>>())
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
        //mAPIService.getLatestTopics()
                /*.map(new Func1<List<LatestBean>, Object>() {
                    @Override
                    public Object call(List<LatestBean> latestBeen) {
                        return latestBeen;
                    }
                }).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((subscriber));*/

        mAPIService.getLatestTopics()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<List<LatestBean>, List<LatestBean>>() {
                    @Override
                    public List<LatestBean> call(List<LatestBean> latestBeen) {
                        return latestBeen;
                    }
                })
                .subscribe(subscriber);


       /* Observable<List<LatestBean>> observable = mAPIService.getLatestTopics().map(new Func1<List<LatestBean>, List<LatestBean>>() {
            @Override
            public List<LatestBean> call(List<LatestBean> latestBeen) {
                return latestBeen;
            }
        });
        toSubscribe(observable, subscriber);*/
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }


}
