package com.android.oz.hotv2ex.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * @author O.z Young
 * @date 16/9/19
 * @desc ${CURSOR}
 */
public class IntentUtils {

    /**
     * @param c            上下文对象
     * @param clazz        需要开启的Activity
     * @param ifFinishSelf 是否关闭本身
     */
    public static void startActivity(Context c, Class<? extends Activity> clazz, boolean ifFinishSelf) {
        Intent intent = new Intent(c, clazz);
        c.startActivity(intent);
        if (ifFinishSelf) {
            ((Activity) c).finish();
        }
    }

}
