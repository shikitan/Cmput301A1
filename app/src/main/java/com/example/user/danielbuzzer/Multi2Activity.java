package com.example.user.danielbuzzer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Multi2Activity extends AppCompatActivity {

    Button firstButton, secondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi2);
        firstButton = (Button)findViewById(R.id.firstButton);
        firstButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
               int counter = prefs.getInt("2P1", 0);
               counter ++;
               SharedPreferences.Editor editor = prefs.edit();
               editor.putInt("2P1", counter );
               editor.commit();

               AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi2Activity.this);
               newAlert.setMessage("Player one click first! Press OK to play again");
               newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int num) {
                       dialog.cancel();
                       finish();
                       startActivity(new Intent("danielbuzzer.Multi2"));
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
                int counter = prefs.getInt("2P2", 0);
                counter ++;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("2P2", counter );
                editor.commit();

                AlertDialog.Builder newAlert = new AlertDialog.Builder(Multi2Activity.this);
                newAlert.setMessage("Player two click first! Press OK to play again");
                newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int num) {
                        dialog.cancel();
                        finish();
                        startActivity(new Intent("danielbuzzer.Multi2"));
                    }
                });
                newAlert.create();
                newAlert.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
