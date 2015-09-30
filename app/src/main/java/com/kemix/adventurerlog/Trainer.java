package com.kemix.adventurerlog;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Kemix on 8/3/2015.
 */
public class Trainer {

    private String name;
    private int age;
    private String sex;
    private String height;
    private int weight;
    private int level;
    private ArrayList<TrainerClass> classArray = new ArrayList<TrainerClass>();
    private int pokedexSeen;
    private int pokedexCaught;
    private int maxHP;
    private int currentHP;
    private int money;
    private ArrayList<Pokemon> currentPokemon = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> storedPokemon = new ArrayList<Pokemon>();
    private ArrayList<Stat> trainerStats = new ArrayList<Stat>();
    private ArrayList<Feat> trainerFeats = new ArrayList<Feat>();
    private ArrayList<String> inventory = new ArrayList<String>();

    public Trainer() {

    }

    public void load(String newName, int newAge, String newSex, String newHeight, int newWeight, int newLevel, int newStr, int newDex, int newCon, int newInt, int newWis, int newCha) {
        name = newName;
        age = newAge;
        sex = newSex;
        height = newHeight;
        weight = newWeight;
        level = newLevel;
        money = 0;
        pokedexCaught = 0;
        pokedexSeen = 0;

        trainerStats.add(new Stat("STR", newStr));
        trainerStats.add(new Stat("DEX", newDex));
        trainerStats.add(new Stat("CON", newCon));
        trainerStats.add(new Stat("INT", newInt));
        trainerStats.add(new Stat("WIS", newWis));
        trainerStats.add(new Stat("CHA", newCha));
        setMaxHP();
        setCurrentHP(getCurrentHP());

    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getStr() {
        return trainerStats.get(0).getFullInfo();
    }

    public int getStrValue() {
        return trainerStats.get(0).getValue();
    }


    public void setStr(int newValue) {
        trainerStats.get(0).setValue(newValue);
    }

    public String getDex() {
        return trainerStats.get(1).getFullInfo();
    }

    public int getDexValue(){
        return trainerStats.get(1).getValue();
    }

    public void setDex(int newValue) {
        trainerStats.get(1).setValue(newValue);
    }

    public String getCon() {
        return trainerStats.get(2).getFullInfo();
    }

    public int getConValue(){
        return trainerStats.get(2).getValue();
    }

    public void setCon(int newValue) {
        trainerStats.get(2).setValue(newValue);
    }

    public String getInt() {
        return trainerStats.get(3).getFullInfo();
    }

    public int getIntValue(){
        return trainerStats.get(3).getValue();
    }

    public void setInt(int newValue) {
        trainerStats.get(3).setValue(newValue);
    }

    public String getWis() {
        return trainerStats.get(4).getFullInfo();
    }

    public int getWisValue(){
        return trainerStats.get(4).getValue();
    }

    public void setWis(int newValue) {
        trainerStats.get(4).setValue(newValue);
    }

    public String getCha() {
        return trainerStats.get(5).getFullInfo();
    }

    public int getChaValue(){
        return trainerStats.get(5).getValue();
    }

    public void setCha(int newValue) {
        trainerStats.get(5).setValue(newValue);
    }

    public void setMaxHP() {
        maxHP = (trainerStats.get(2).getValue()) * 5;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setCurrentHP(int newValue) {
        currentHP = newValue;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setPokedexSeen(int newValue) {
        pokedexSeen = newValue;
    }

    public int getPokedexSeen() {
        return pokedexSeen;
    }

    public void setPokedexCaught(int newValue) {
        pokedexCaught = newValue;
    }

    public int getPokedexCaught() {
        return pokedexCaught;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int newValue) {
        money = newValue;
    }

    public ArrayList<Stat> getTrainerStats(){
        return trainerStats;
    }


}
