package com.example.user.danielbuzzer;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Activity showing the email page.
public class EmailActivity extends AppCompatActivity {

    private Button sendEmail;
    private EditText userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        //when the email button is clicked, it sends an email of the buzzer stats from the
        //Shared preferences variables
        sendEmail = (Button) findViewById(R.id.sendStats);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent emailI = new Intent(Intent.ACTION_SEND);
                    userEmail = (EditText) findViewById(R.id.userEmail);
                    String emailAddress = userEmail.getText().toString();
                    emailI.putExtra(Intent.EXTRA_EMAIL, emailAddress);
                    emailI.putExtra(Intent.EXTRA_SUBJECT, "301 A1 Stats");

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


                    emailI.putExtra(Intent.EXTRA_TEXT, "2 Players: " + count2P1 + ", " + count2P2 +
                            "\n3 Players: " + count3P1 + ", " + count3P2 + ", " + count3P3 + "\n" +
                            "4 Players: " + count4P1 + ", " + count4P2 + ", " + count4P3 + ", " +
                            count4P4);
                    emailI.setType("message/rfc822");
                    startActivity(emailI);
                } catch (ActivityNotFoundException e){
                    Toast toast  = Toast.makeText(EmailActivity.this, "Sorry, an email client was " +
                            "not found", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }


}
