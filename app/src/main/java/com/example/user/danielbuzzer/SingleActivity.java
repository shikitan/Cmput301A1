package com.example.user.danielbuzzer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* This is for the reaction time mode. This Activity would have a reactionmanage array that would
hold instances of the reactiontime objects
Alertdialogs are used to show the popupmessage before you start the game and also after you get
a reaction time.

also a CountDownTimer is called to make a randomized delay that would stop you from recording a time
if you pressed the button too early
 */
public class SingleActivity extends AppCompatActivity{

    private CountDownTimer rTimer;
    private Button singleReaction;


    private static final String FILENAME = "reactions.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        TextView msg = (TextView) findViewById(R.id.goText);
        msg.setText("Get Ready");
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("After you click Ok \nPress the button when it says Go!!!");
        myAlert.setCancelable(false);
        myAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                TextView msg = (TextView) findViewById(R.id.goText);
                msg.setText("Get Ready");
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
        TextView msg = (TextView) findViewById(R.id.goText);


        singleReaction = (Button)findViewById(R.id.singleReaction);
        msg.setText("Get Ready");
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
                TextView msg = (TextView) findViewById(R.id.goText);
                msg.setText("GO!!!");
                final long begt = System.currentTimeMillis();

                singleReaction.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        long endt = System.currentTimeMillis();
                        long diff = endt - begt;
                       /* int diff2 = (int) diff;
                        ReactionManage reactions = new ReactionManage(SingleActivity.this);

                        reactions.loadList();
                        reactions.add(new ReactionTime(diff2));
                        reactions.saveList();*/

                        AlertDialog.Builder newAlert = new AlertDialog.Builder(SingleActivity.this);
                        newAlert.setMessage("You Reacted in "+diff+" milliseconds! Press OK to play again");
                        newAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int num) {
                                dialog.cancel();
                                TextView msg = (TextView) findViewById(R.id.goText);
                                msg.setText("Get Ready");

                                finish();
                                startActivity(new Intent("danielbuzzer.Single"));
                            }
                        });
                        newAlert.create();
                        newAlert.show();

                    }
                });
            }
        };
        rTimer.start();

    }
}
