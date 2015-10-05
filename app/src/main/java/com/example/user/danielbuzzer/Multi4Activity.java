package com.example.user.danielbuzzer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Multi4Activity extends AppCompatActivity {

    Button firstButton, secondButton, thirdButton, fourthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi4);
        firstButton = (Button)findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
                int counter = prefs.getInt("4P1", 0);
                counter ++;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("4P1", counter );
                editor.commit();

                AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi4Activity.this);
                newAlert.setMessage("Player one click first! Press OK to play again");
                newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int num) {
                        dialog.cancel();
                        finish();
                        startActivity(new Intent("danielbuzzer.Multi4"));
                    }
                });
                newAlert.create();
                newAlert.show();
            }
        });
        secondButton = (Button)findViewById(R.id.secondButton);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
                int counter = prefs.getInt("4P2", 0);
                counter ++;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("4P2", counter );
                editor.commit();

                AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi4Activity.this);
                newAlert.setMessage("Player two click first! Press OK to play again");
                newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int num) {
                        dialog.cancel();
                        finish();
                        startActivity(new Intent("danielbuzzer.Multi4"));
                    }
                });
                newAlert.create();
                newAlert.show();
            }
        });
        thirdButton = (Button)findViewById(R.id.thirdButton);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
                int counter = prefs.getInt("4P3", 0);
                counter ++;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("4P3", counter );
                editor.commit();

                AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi4Activity.this);
                newAlert.setMessage("Player three click first! Press OK to play again");
                newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int num) {
                        dialog.cancel();
                        finish();
                        startActivity(new Intent("danielbuzzer.Multi4"));
                    }
                });
                newAlert.create();
                newAlert.show();
            }
        });
        fourthButton = (Button)findViewById(R.id.fourthButton);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
                int counter = prefs.getInt("4P4", 0);
                counter ++;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("4P4", counter );
                editor.commit();

                AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi4Activity.this);
                newAlert.setMessage("Player four click first! Press OK to play again");
                newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int num) {
                        dialog.cancel();
                        finish();
                        startActivity(new Intent("danielbuzzer.Multi4"));
                    }
                });
                newAlert.create();
                newAlert.show();
            }
        });

    }
}
