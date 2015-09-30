package com.kemix.adventurerlog;

import java.util.ArrayList;

/**
 * Created by Kemix on 8/3/2015.
 */
public class Feat {
    private String name;
    private String description;
    private boolean hasModifier;
    private ArrayList<Stat> modifiers = new ArrayList<Stat>();
    private ArrayList<Stat> statPrerequisites = new ArrayList<Stat>();
    private ArrayList <String> classPrerequisites = new ArrayList<String>();

}
