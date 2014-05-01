package com.roxanne.funwithapps.funwithapps;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddPlayer extends ActionBarActivity {

    private NumberPicker np;
    private EditText editText;

    Serializer file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        if (file == null)
            file = new Serializer(this);

        editText = (EditText) findViewById(R.id.etName);

        np = (NumberPicker) findViewById(R.id.npInit);
        np.setMaxValue(9);
        np.setMinValue(0);

    }

    public void saveOnClick(View v){

        String name = editText.getText().toString();
        int init = np.getValue();

        Character newCharacter = new Character(name, init);
        file.addCharacter(newCharacter);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_player, menu);
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
