package com.andr0day.shellingdemo;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyService extends Service {
    IMyAidlInterface iMyAidlInterface = new IMyAidlInterface.Stub() {
        @Override
        public void inter(int a, String b) throws RemoteException {
            System.out.println("inter");
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("onBind");
        return iMyAidlInterface.asBinder();
    }

    @SuppressLint("StaticFieldLeak")
    public int onStartCommand(Intent intent, int flags, int startId) {
        new AsyncTask<Void, Void, Integer>() {

            @Override
            protected Integer doInBackground(Void... voids) {
                return test();
            }

            protected void onPostExecute(Integer res) {
                System.out.println("AsyncTask.res:" + res);
                Log.e("XXX", "AsyncTask.res:" + res);
            }

        }.execute(null, null);

        return START_NOT_STICKY;
    }

    public int test() {
        int a = 2;
        int b = 3;
        return a + b + 4;
    }

}
