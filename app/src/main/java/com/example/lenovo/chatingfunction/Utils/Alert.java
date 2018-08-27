package com.example.lenovo.chatingfunction.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by tmsasia on 17/03/2017.
 */

public class Alert {

    public static void showAlert(Context context, String title, int message, String positive){
        String strMessage = null;
        if(message > 0) {
            strMessage = context.getResources().getString(message);
        }
        showAlert(context, title, strMessage, positive, null, null, null);
    }

    public static void showAlert(Context context, String title, String message, String positive){
        showAlert(context, title, message, positive, null, null, null);
    }

    public static void showAlert(Context context, String title, int message, String positive, final AlertResponse.Positive postiveCallback){
        String strMessage = null;
        if(message > 0) {
            strMessage = context.getResources().getString(message);
        }
        showAlert(context, title, strMessage, positive, null, postiveCallback, null);
    }

    public static void showAlert(Context context, String title, String message, String positive, final AlertResponse.Positive postiveCallback){
        showAlert(context, title, message, positive, null, postiveCallback, null);
    }

    public static void showAlert(Context context, String title, int message, String positive, String negative, final AlertResponse.Positive postiveCallback, final AlertResponse.Negative negativeCallback) {
        String strMessage = null;
        if(message > 0) {
            strMessage = context.getResources().getString(message);
        }
        showAlert(context, title, strMessage, positive, negative, postiveCallback, negativeCallback);
    }

    public static void showAlert(Context context, int title, String message, String positive, String negative, final AlertResponse.Positive postiveCallback, final AlertResponse.Negative negativeCallback) {
        String strTitle = null;
        if(title > 0) {
            strTitle = context.getResources().getString(title);
        }
        showAlert(context, strTitle, message, positive, negative, postiveCallback, negativeCallback);
    }

    public static void showAlert(Context context, int title, int message, String positive, String negative, final AlertResponse.Positive postiveCallback, final AlertResponse.Negative negativeCallback){
        String strTitle = null;
        String strMessage = null;
        if(title > 0) {
            strTitle = context.getResources().getString(title);
        }

        if(message > 0) {
            strMessage = context.getResources().getString(message);
        }

        showAlert(context, strTitle, strMessage, positive, negative, postiveCallback, negativeCallback);
    }

    public static void showAlert(Context context, String title, String message, String positive, String negative, final AlertResponse.Positive postiveCallback, final AlertResponse.Negative negativeCallback){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if(title != null) {
            builder.setTitle(title);
        }

        if(message != null) {
            builder.setMessage(message);
        }

        builder.setCancelable(true);

        builder.setPositiveButton(
                positive,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        if(postiveCallback != null) {
                            postiveCallback.didSelectPositiveButton();
                        }
                    }
                });

        if(negative != null) {
            builder.setNegativeButton(
                    negative,
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                            if (negativeCallback != null) {
                                negativeCallback.didSelectNegativeButton();
                            }
                        }
                    });
        }

        AlertDialog alert = builder.create();
        alert.show();
    }

    public interface AlertResponse{
        public interface Positive{
            void didSelectPositiveButton();
        }

        public interface Negative{
            void didSelectNegativeButton();
        }
    }
}
