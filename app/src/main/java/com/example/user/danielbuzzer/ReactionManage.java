package com.example.user.danielbuzzer;

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
public class ReactionManage{
    private List<ReactionTime> reactions;
    private static final String FILENAME = "reactions.sav";


    public void loadList(Context mcontext){
        try {
            FileInputStream fis = mcontext.openFileInput(FILENAME);
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



    public void add(ReactionTime time){
        reactions.add(time);
    }



    public void saveList(Context mcontext){
        try {
            FileOutputStream fos = mcontext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
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
