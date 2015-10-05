package com.example.user.danielbuzzer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//This activity has buttons that sends the user to the different modes of the Buzzer mode
//Each buzzer mode is identical in saving data into the Saved preferences variables
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
