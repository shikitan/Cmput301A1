package com.example.user.danielbuzzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MultiActivity extends AppCompatActivity implements View.OnClickListener{

    Button button2p, button3p, button4p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        button2p = (Button)findViewById(R.id.button2p);
        button2p.setOnClickListener(this);

        button3p = (Button)findViewById(R.id.button3p);
        button3p.setOnClickListener(this);

        button4p = (Button)findViewById(R.id.button4p);
        button4p.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_multi, menu);
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
    private void twopClick() {
        startActivity(new Intent("danielbuzzer.Multi2"));
    }
    private void threepClick() {
        startActivity(new Intent("danielbuzzer.Multi3"));
    }
    private void fourpClick() {
        startActivity(new Intent("danielbuzzer.Multi4"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2p:
                twopClick();
                break;
            case R.id.button3p:
                threepClick();
                break;
            case R.id.button4p:
                fourpClick();
                break;
        }

    }
}
