package com.company;

import java.util.ArrayList;
import java.util.List;

public class Monster implements ISaveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        ArrayList<String> values = new ArrayList<String>();
        values.add(0, this.name);
        values.add(1, "" + this.hitPoints);
        values.add(2, "" + this.strength);
        return values;
    }

    @Override
    public void read(List<String> saveValue) {
        if(saveValue != null && saveValue.size() > 0){
            this.name = saveValue.get(0);
            this.hitPoints = Integer.parseInt(saveValue.get(1));
            this.strength = Integer.parseInt(saveValue.get(2));
        }
    }

    @Override
    public String toString() {
        String result = "Player{name='" + name + "'" +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength + "'}";
        return result;
    }
}
