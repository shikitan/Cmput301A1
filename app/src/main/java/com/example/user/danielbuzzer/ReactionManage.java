/*package com.example.user.danielbuzzer;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2015-10-04.
 */

//This class is edited out as it created a nullpointer error at the .add method.
//It was supposed to an array class that held instances of Reaction Time objects

//This class is in the singleactivity class
/*public class ReactionManage{
    private List<ReactionTime> reactions;
    private static final String FILENAME = "reactions.sav";
    Context myactivity;

    public ReactionManage(Context activity) {
        this.myactivity = activity;
    }

This would load a presaved array list so that we can keep data persistant
    public void loadList(){
        try {
            FileInputStream fis = myactivity.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            // Taken from https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html
            Type listType = new TypeToken<ArrayList<ReactionTime>>() {}.getType();
            reactions = gson.fromJson(in,listType);
        } catch (FileNotFoundException e) {
            reactions = new ArrayList<ReactionTime>();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


this would add on a new time to the array
    public void add(ReactionTime time){
        reactions.add(time);
    }


Then we would save it into a file
    public void saveList(){
        try {
            FileOutputStream fos = myactivity.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(reactions, writer);
            writer.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
*/