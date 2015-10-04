package com.example.user.danielbuzzer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SingleActivity extends AppCompatActivity{

    private CountDownTimer rTimer;
    private Button singleReaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        

        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("After you click Ok \nPress the button when it says Go!!!");
        myAlert.setCancelable(false);
        myAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                rTimer.start();
            }

        });
        myAlert.create();
        myAlert.show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        double randN = 10+(int)(Math.random()*2000);
        long randNl = Math.round(randN);

        final TextView msg = (TextView) findViewById(R.id.goText);

        singleReaction = (Button)findViewById(R.id.singleReaction);

        rTimer = new CountDownTimer(randNl, 1) {
            @Override
            public void onTick(long millisUntilFinished) {


                singleReaction.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        TextView msg = (TextView) findViewById(R.id.goText);
                        msg.setText("Too Early! Wait for it to say GO!!!");
                        cancel();
                        start();
                    }
                });
            }

            @Override
            public void onFinish() {
                final TextView msg = (TextView) findViewById(R.id.goText);
                msg.setText("GO!!!");
                final long begt = System.currentTimeMillis();

                singleReaction.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        long endt = System.currentTimeMillis();
                        long diff = endt - begt;
                        int diff2 = (int) diff;
                        ReactionTime time = new ReactionTime(diff2);
                        AlertDialog.Builder newAlert = new AlertDialog.Builder(SingleActivity.this);
                        newAlert.setMessage("You Reacted in "+diff+" milliseconds! Press OK to play again");
                        newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int num) {
                                dialog.cancel();
                                msg.setText("Get Ready");
                                finish();
                                startActivity(new Intent("danielbuzzer.Single"));
                            }
                        });

                        newAlert.show();

                    }
                });
            }
        };
        rTimer.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_single, menu);
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
