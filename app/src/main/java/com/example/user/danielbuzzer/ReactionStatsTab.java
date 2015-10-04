package com.example.user.danielbuzzer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ReactionStatsTab extends AppCompatActivity {
    private static final String FILENAME = "file.sav";
    private ListView oldReactionsList;
    private ArrayAdapter<ReactionTime> adapter;
    private ArrayList<ReactionTime> reactions = new ArrayList<ReactionTime>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_stats);
        Button clearButton = (Button) findViewById(R.id.clear);
        oldReactionsList = (ListView) findViewById(R.id.oldReactionsList);
        clearButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                reactions.clear();
                adapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<ReactionTime>(this, R.layout.list_view, reactions);
        oldReactionsList.setAdapter(adapter);
    }
    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<ReactionTime>>() {}.getType();
            reactions = gson.fromJson(in,listType);
        } catch (FileNotFoundException e) {
            reactions = new ArrayList<ReactionTime>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reaction_stats, menu);
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
