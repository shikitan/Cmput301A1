/*
    DanielBuzzer: SUMMARY
    Copyright 2015 Daniel Shin dshin@ualberta.ca

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/

package com.example.user.danielbuzzer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//This is the main activity. Shows the home screen and connects to all the other activities
public class BuzzerActivity extends AppCompatActivity implements View.OnClickListener {
//initializing buttons that send the user to other activities
    Button singleButton, multiButton, statButton, emailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//shared preferences for the counts of the buzzer mode
        SharedPreferences prefs = getSharedPreferences("Multi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        int count2P1 = prefs.getInt("2P1", 0); //0 is default value.
        int count2P2 = prefs.getInt("2P2", 0);

        int count3P1 = prefs.getInt("3P1", 0);
        int count3P2 = prefs.getInt("3P2", 0);
        int count3P3 = prefs.getInt("3P3", 0);


        int count4P1 = prefs.getInt("4P1", 0);
        int count4P2 = prefs.getInt("4P2", 0);
        int count4P3 = prefs.getInt("4P3", 0);
        int count4P4 = prefs.getInt("4P4", 0);

        editor.putInt("2P1", count2P1);
        editor.putInt("2P2", count2P2);

        editor.putInt("3P1", count3P1);
        editor.putInt("3P2", count3P2);
        editor.putInt("3P3", count3P3);

        editor.putInt("4P1", count4P1);
        editor.putInt("4P2", count4P2);
        editor.putInt("4P3", count4P3);
        editor.putInt("4P4", count4P4);

        editor.commit();

        singleButton = (Button)findViewById(R.id.singleButton);
        singleButton.setOnClickListener(this);

        multiButton = (Button)findViewById(R.id.multiButton);
        multiButton.setOnClickListener(this);

        statButton = (Button)findViewById(R.id.statButton);
        statButton.setOnClickListener(this);

        emailButton = (Button)findViewById(R.id.emailButton);
        emailButton.setOnClickListener(this);
    }
//functions to go to other classes
    private void singleClick() {startActivity(new Intent("danielbuzzer.Single"));}
    private void multiClick() {startActivity(new Intent("danielbuzzer.Multi"));}
    private void statClick() {startActivity(new Intent("danielbuzzer.Stats"));}
    private void emailClick() { startActivity(new Intent("danielbuzzer.email"));}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.singleButton:
                singleClick();
                break;
            case R.id.multiButton:
                multiClick();
                break;
            case R.id.statButton:
                statClick();
                break;
            case R.id.emailButton:
                emailClick();
                break;
        }

    }
}
