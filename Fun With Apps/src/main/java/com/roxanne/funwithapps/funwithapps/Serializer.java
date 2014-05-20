package com.roxanne.funwithapps.funwithapps;

import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Manages the saved data of characters
 * Created by Roxanne on 16/04/14.
 */
public class Serializer {


    private final static String FILENAME = "characterFile";
    private final static String LOGTAG = "Serializer.java";
    private static ArrayList<Character> characters;
    Context context;


    public Serializer(Context c){
        this.context = c;
        if (characters == null){
            characters = getCharacters();
        }
    }

    /**
     * Adds character and saves list
     * @param character The character to be added
     */
    public void addCharacter(Character character){
        if (!(characters == null)){
            characters.add(character);
            saveCharacters();
        }
    }

    /**
     * Saves characters to internal storage
     */
    private void saveCharacters() {
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new
                    BufferedOutputStream(context.openFileOutput(FILENAME, Context.MODE_PRIVATE)));

            for (Character ch : characters){
                outputStream.writeObject(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    Log.e(LOGTAG, "Error closing file after writing");
                    e.printStackTrace();
                }
        }

    }

    /**
     * Read the characters file and return it as a ArrayList of Characters
     * @return list of characters
     */
    public ArrayList<Character> getCharacters() {

        // TODO optimize this so it loads one time and just return the existing characters instead of leading every time

        characters = new ArrayList<Character>();
        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream (new BufferedInputStream
                    (context.openFileInput(FILENAME)));

            Character c;
            while(true){
                c = (Character) inputStream.readObject();
                characters.add(c);
            }

        } catch (EOFException e){
            Log.i(LOGTAG, "Created " + characters.size() + " characters");
        } catch (Exception e) {
            Log.e(LOGTAG, e.toString());
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.e(LOGTAG, "Error closing file after reading");
                    e.printStackTrace();
                }
        }

        return characters;
    }

    public void clearCharacters(){
        characters = new ArrayList<Character>();
        saveCharacters();
    }

}
