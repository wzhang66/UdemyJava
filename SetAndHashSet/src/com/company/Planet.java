package com.company;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }


    // Check whether the bodytype is moon
    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getBodyType() == BodyTypes.MOON){
            return  super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
