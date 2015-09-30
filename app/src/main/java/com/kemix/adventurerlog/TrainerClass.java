package com.kemix.adventurerlog;

import com.kemix.adventurerlog.Feat;

import java.util.ArrayList;

/**
 * Created by Kemix on 8/3/2015.
 */
public class TrainerClass {
    private String name;
    private boolean isBaseClass;
    private ArrayList<Feat> classFeats = new ArrayList<Feat>();
    private ArrayList<Stat> classBonus = new ArrayList<Stat>();
    private ArrayList<Stat> classPenalties = new ArrayList<Stat>();
    private ArrayList<Stat> statPrerequisites = new ArrayList<Stat>();
    private ArrayList<String> classPrerequisites = new ArrayList<String>();

    public TrainerClass(String name, boolean isBase, ArrayList feats, ArrayList bonus, ArrayList penalties, ArrayList statPrereq, ArrayList classPrereq){
        isBaseClass = isBase;
        classFeats = feats;
        classBonus = bonus;
        classPenalties = penalties;
        statPrerequisites = statPrereq;
        classPrerequisites = classPrereq;
    }

    public boolean canTake(ArrayList trainerStats){

        Stat statHolder;
        if(isBaseClass == true){
            for(int i = 0; i < statPrerequisites.size(); i++) {
                statHolder = statPrerequisites.get(i);
                for(int j = 0; j < trainerStats.size(); j++){

                }
            }
        }

        return true;
    }
}
