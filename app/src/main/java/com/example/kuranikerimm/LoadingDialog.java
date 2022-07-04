package com.example.kuranikerimm;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingDialog {
    private Activity activity;
    private AlertDialog dialog;
    AlertDialog.Builder builder;
    public static int süre;
    public LoadingDialog(Activity myActivity){
        activity = myActivity;

    }
    public void startLoadingDialog(){
        builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading,null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
        süre = 1;
    }
   public void dismissDialog(){
        //builder.setNegativeButton("kapat",null);
        dialog.cancel();
    }
}
