package com.kemix.adventurerlog;

/**
 * Created by Kemix on 8/3/2015.
 */
public class PlayerClass {
    private String name;
    private int level;

    public PlayerClass(String startName, int startLevel) {
        name = startName;
        level = startLevel;
    }

    public void levelUp(){
        level++;
    }
}
