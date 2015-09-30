package com.kemix.adventurerlog;

/**
 * Created by Kemix on 8/3/2015.
 */
public class Stat {
    private String name;
    private int value;
    private int modifier;

    public Stat (String newName, int newValue){
        name = newName;
        value = newValue;
        setModifier();
    }

    public void setValue(int newValue){
        value = newValue;
        setModifier();
    }

    public void increaseValue(){
        value++;
        setModifier();
    }

    public void decreaseValue(){
        value--;
        setModifier();
    }

    public void setModifier(){
        if (value == 10){
            modifier = 0;
        }
        else if (value < 10){
            modifier = value - 10;
        }
        else{
            modifier = (value - 10)/2;
        }
    }

    public int getModifier(){
        return modifier;
    }

    public String getName(){
        return name;
    }

    public int getValue(){
        return value;
    }

    public String getFullInfo(){
        String string = "["+this.getName()+"]\t\t["+Integer.toString(this.getValue()) +"]\t[";
        if (modifier > -1){
            string +="+"+this.getModifier()+"]";
        }
        else{
            string+=this.getModifier()+"]";
        }
        return string;
    }
}
