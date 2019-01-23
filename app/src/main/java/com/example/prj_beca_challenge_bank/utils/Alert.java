package com.example.prj_beca_challenge_bank.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.prj_beca_challenge_bank.view.details.DetailsActivity;
import com.example.prj_beca_challenge_bank.view.login.LoginActivity;

public class Alert {

    public static void alertLogout(final Context context, String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setNegativeButton("Não", null);
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callLoginActivity(context);
            }
        });
        //
        alert.show();
    }

    public static void callLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        //
        context.startActivity(intent);
        //
        ((DetailsActivity) context).finish();
        //
        toast(context, "Logout efetuado com sucesso");
    }

    public static void alertExitApp(final Context context, String title, String message) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setCancelable(false);
        alert.setNegativeButton("Não", null);
        alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ((LoginActivity) context).finish();
            }
        });
        //
        alert.show();
    }

    public static void toast(final Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}