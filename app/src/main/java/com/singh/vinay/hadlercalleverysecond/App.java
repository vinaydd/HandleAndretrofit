package com.singh.vinay.hadlercalleverysecond;

import android.app.Application;
import android.content.Context;

import com.google.firebase.crash.FirebaseCrash;


public class App extends Application {

    //app context
    private static Context context;

    /**
     * called on app created
     */
    @Override
    public void onCreate() {
        super.onCreate();

        //app context
        context = getApplicationContext();

        //firebase crash report for all uncaught exceptions occurs in the app
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                FirebaseCrash.report(ex);
            }
        });
    }

    /**
     * get app context
     *
     * @return context
     */
    public static Context getAppContext() {
        return context;
    }

}
