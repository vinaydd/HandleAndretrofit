package com.singh.vinay.hadlercalleverysecond;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by root on 31/1/17.
 */
public class IntentServices extends IntentService {

    public IntentServices() {
        this(IntentServices.class.getName());
    }

    public IntentServices(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        showToast("Starting IntentService");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        showToast("Finishing IntentService");


    }

    protected void showToast(final String msg){
        //gets the main thread
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                // run this code in the main thread
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }




}
