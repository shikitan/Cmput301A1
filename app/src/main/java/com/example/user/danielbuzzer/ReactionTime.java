package com.example.user.danielbuzzer;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 2015-10-03.
 */
public class ReactionTime extends ReactionStatsTab implements Parcelable{

    public int reactiont;
    private ArrayList<reactiont> tweets = new ArrayList<reactiont>();

    public ReactionTime(int reactiont) {

        this.reactiont = reactiont;
        this.saveInFile(reactiont);
    }

    public void saveInFile(int reactiont) {
        String strI = Integer.toString(reactiont);
        String file_name = "file.sav";
            try{
                FileOutputStream fos = openFileOutput(file_name,MODE_PRIVATE);
                fos.write(strI.getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }

    };


    public int getReactiont() {
        return reactiont;
    }


}
