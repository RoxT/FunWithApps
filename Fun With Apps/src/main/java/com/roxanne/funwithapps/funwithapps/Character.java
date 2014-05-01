package com.roxanne.funwithapps.funwithapps;

import java.io.Serializable;

/**
 * A character with name and initiative
 * Created by Roxanne on 16/04/14.
 */
public class Character implements Serializable {

    private String name;
    private int init;
    private int count;
    private boolean player;


    public Character(String name, int init){
        this.name = name;
        this.init = init;
        count = 1;
        player = true;
    }

    public Character(String name, int init, int count){
        this.name = name;
        this.init = init;
        this.count = count;
        player = false;
    }

    public Character(){

    }

    @Override
    public String toString(){
        String what = "M";
        if (player) {
            what = "P";
        }
        return what + " " + name + " Init: " + init;
    }

    public String getName(){
        return name;
    }

    public int getInit(){
        return init;
    }


    public void setName(String newName){
        name = newName;
    }

    public void setInit(int newInit){
        init = newInit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (player)
            this.count = count;
    }

    public boolean isPlayer() {
        return player;
    }
}
