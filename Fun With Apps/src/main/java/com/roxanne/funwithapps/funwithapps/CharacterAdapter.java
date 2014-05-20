package com.roxanne.funwithapps.funwithapps;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * An adapter to handle characters on the battle screen
 * Created by roxanne on 2014-05-08.
 */
public class CharacterAdapter extends ArrayAdapter<Character> {

    private final Context context;
    private final Character[] values;
    private final static String LOGTAG = "CharacterAdapter.java";

    public CharacterAdapter(Context c, Character[] values){
        super(c, R.layout.battle_list_item, values);
        context = c;
        this.values = values;

    }

    static class ViewHolder {
        public TextView name;
        public TextView init;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = convertView;
        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.battle_list_item, parent, false);

        }

        Character p = getItem(position);

        if (p != null) {
            Log.i(LOGTAG, "View on characterr: " + p.toString());
            TextView textOne = (TextView) v.findViewById(R.id.tVName);
            TextView textTwo = (TextView) v.findViewById(R.id.tVInit);

            if (textOne != null) {
                textOne.setText(values[position].getName());
            }

            if (textTwo != null) {

                textTwo.setText(values[position].getInit() + "");
            }
        }
        return v;

    }
}
