package com.roxanne.funwithapps.funwithapps;

import android.content.Context;
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

       View rowView = convertView;
       // resuse rows
        if (rowView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.battle_list_item, parent, false);
            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) rowView.findViewById(R.id.tVName);
            viewHolder.init = (TextView) rowView.findViewById(R.id.tVInit);
            rowView.setTag(viewHolder);
        }

        //fill data
        ViewHolder viewHolder = rowView.getTag();

    }
}
