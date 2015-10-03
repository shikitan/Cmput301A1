package com.example.user.danielbuzzer;

import android.app.TabActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class Stats extends TabActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TabHost th = (TabHost)findViewById(android.R.id.tabhost);
        th.setup();

        TabHost.TabSpec spec = th.newTabSpec("tab1");
        spec.setContent(R.id.ReactionStats);
        spec.setIndicator("Reaction Stats");
        th.addTab(spec);

        spec = th.newTabSpec("tab2");
        spec.setContent(R.id.BuzzerStats);
        spec.setIndicator("Buzzer Stats");
        th.addTab(spec);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stats, menu);
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
