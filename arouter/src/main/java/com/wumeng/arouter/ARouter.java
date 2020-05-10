package com.wumeng.arouter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WuMeng
 * @date 2020/5/10
 * desc:
 */
public class ARouter {

    private static ARouter aRouter = new ARouter();

    /**
     * 装载了所有的Activity的类实例
     */
    private Map<String, Class<? extends Activity>> maps;

    private Context context;

    private ARouter() {
        maps = new HashMap<>();
    }

    public static ARouter getInstance() {
        return aRouter;
    }

    public void init(Context context) {
        this.context = context;
    }

    /**
     * 跳转窗体的方法
     * @param key
     * @param bundle
     */
    public void jumpActivity(String key, Bundle bundle) {
        Class<? extends Activity> activityClass = maps.get(key);
        if (activityClass != null) {
            Intent intent = new Intent().setClass(context,activityClass);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        }
    }

}
