package com.andr0day.shellingdemo;

import android.app.Application;
import android.content.Context;

import java.lang.reflect.Method;

public class MyApp extends Application {

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        System.out.println("attachBaseContext, processName:" + getProcessName());
    }


    public void onCreate() {
        super.onCreate();
    }

    //this.mBase.mMainThread.getProcessName()
    private String getProcessName() {
        String processName = null;
        try {
            Class activityThreadClazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThreadField = activityThreadClazz.getDeclaredMethod("currentActivityThread");
            currentActivityThreadField.setAccessible(true);
            Object activityThread = currentActivityThreadField.invoke(activityThreadClazz);

            Method getProcessName = activityThread.getClass().getDeclaredMethod("getProcessName");
            processName = (String) getProcessName.invoke(activityThread);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return processName;
    }
}
