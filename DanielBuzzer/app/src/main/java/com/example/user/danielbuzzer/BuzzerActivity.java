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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BuzzerActivity extends AppCompatActivity implements View.OnClickListener {

    Button singleButton, multiButton, statButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        singleButton = (Button)findViewById(R.id.singleButton);
        singleButton.setOnClickListener(this);

        multiButton = (Button)findViewById(R.id.multiButton);
        multiButton.setOnClickListener(this);

        statButton = (Button)findViewById(R.id.statButton);
        statButton.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private void singleClick() {
        startActivity(new Intent("danielbuzzer.Single"));
    }
    private void multiClick() {
        startActivity(new Intent("danielbuzzer.Multi"));
    }
    private void statClick() {
        startActivity(new Intent("danielbuzzer.Stats"));
    }

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
        }

    }
}