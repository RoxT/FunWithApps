package com.roxanne.funwithapps.funwithapps;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private static final String LOGTAG = "MainActivity.java";
    private ArrayList<String> values;
    public static ArrayList<Character> characters;
    private Serializer file;
    CharacterAdapter myAdapter;
    int selected;
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        file = new Serializer(this);
        characters = file.getCharacters();

        if (characters.size() < 1) {
            characters.add(new Character("Detta the Default", 5));
        }
        final ListView listview = (ListView) findViewById(R.id.list);
        myAdapter = new CharacterAdapter(this, characters.toArray(new Character[characters.size()]));

        listview.setAdapter(myAdapter);

    }

    /** Called when the user clicks the Add button */
    public void newOnClick(View view){
        Intent intent  = new Intent(this, AddDialog.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Clear button */
    public void clearOnClick(View view){
        Intent intent  = new Intent(this, CancelDialog.class);
        startActivity(intent);
    }

    /** Called when the user clicks the Next button */
    public void nextOnClick(View view){

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
