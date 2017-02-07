package com.singh.vinay.hadlercalleverysecond.handler;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.view.WindowManager;

import com.singh.vinay.hadlercalleverysecond.R;


public class DialogHandler {

    //Singleton instance
    private static DialogHandler instance;

    /**
     * Private constructor
     */
    private DialogHandler() {
    }

    /**
     * @return Singleton instance
     */
    public static DialogHandler getInstance() {
        if (instance == null) {
            instance = new DialogHandler();
        }
        return instance;
    }

    /**
     * show dialog
     *
     * @param context
     * @param title
     * @param message
     */
    public void show(Context context, String title, String message) {
        final AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    /**
     * create progress dialog
     *
     * @param context
     */
    public Dialog createProgress(Context context) {
        final Dialog pdProgress = new Dialog(context);
        pdProgress.getWindow();
        pdProgress.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pdProgress.setContentView(R.layout.view_progress_indicator);
        pdProgress.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
        pdProgress.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        pdProgress.setCancelable(false);
        return pdProgress;
    }

}
