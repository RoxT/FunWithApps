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
    ArrayAdapter myAdapter;
    int selected;
    View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = 0;

        file = new Serializer(this);

        if (characters == null) {
            characters = new ArrayList<Character>();
        }
        characters = file.getCharacters();


//        if (characters.size() < 1){
//            Character detta = new Character("Detta the Default", 3);
//            for (int i = 0; i < 3 ; i++)
//                file.addCharacter(new Character("Player " + i, (int) (Math.random() * 10)));
//            file.addCharacter(detta);
//            characters = file.getCharacters();
//        }

        values = new ArrayList<String>();
        for (Character c : characters){
             for (int i = 1; i <= c.getCount(); i++)
                 values.add(c.toString());
            }

        final ListView listview = (ListView) findViewById(R.id.listview);
        myAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, values);

        listview.setAdapter(myAdapter);
        Log.i(LOGTAG, "myAdapter count = " + myAdapter.getCount());
        if (myAdapter.getCount() > 0) {
            v = myAdapter.getView(selected, v, listview);
            v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            v.setSelected(true);
            Log.i(LOGTAG, "selected = " + selected);

        }

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
        final ListView listview = (ListView) findViewById(R.id.listview);
        v.setBackgroundColor(getResources().getColor(android.R.color.background_dark));
        v.setSelected(false);
        if (selected < myAdapter.getCount() - 1) {
            v = myAdapter.getView(++selected, v, listview);
        } else {
            selected = 0;
            v = myAdapter.getView(selected, v, listview);
        }
        v.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
        v.setSelected(true);
        Log.i(LOGTAG, "selected = " + selected);

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
