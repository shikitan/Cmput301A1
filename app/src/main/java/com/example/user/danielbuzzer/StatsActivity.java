package com.example.user.danielbuzzer;

import android.app.TabActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;

public class StatsActivity extends TabActivity {

    Button clearMulti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        updateMult();

        clearMulti = (Button)findViewById(R.id.clearMulti);
        clearMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();

                editor.clear();
                editor.commit();

                updateMult();
            }
        });

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

    private void updateMult(){
        TextView msg = (TextView) findViewById(R.id.statMulti);
        SharedPreferences prefs = getSharedPreferences("Share", Context.MODE_PRIVATE);

        int count2P1 = prefs.getInt("2P1", 0);
        int count2P2 = prefs.getInt("2P2", 0);

        int count3P1 = prefs.getInt("3P1", 0);
        int count3P2 = prefs.getInt("3P2", 0);
        int count3P3 = prefs.getInt("3P3", 0);


        int count4P1 = prefs.getInt("4P1", 0);
        int count4P2 = prefs.getInt("4P2", 0);
        int count4P3 = prefs.getInt("4P3", 0);
        int count4P4 = prefs.getInt("4P4", 0);


        msg.setText("2 Players: " + count2P1 + ", " + count2P2 + "\n3 Players: " + count3P1 + ", "
                + count3P2 + ", " + count3P3 + "\n4 Players: " + count4P1 + ", " + count4P2 + ", "
                + count4P3 + ", " + count4P4);
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
