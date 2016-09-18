package com.android.oz.hotv2ex;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * @author O.z Young
 * @date 16/9/18
 * @desc ${CURSOR}
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
