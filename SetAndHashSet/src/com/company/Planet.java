package com.company;

public class Planet extends HeavenlyBody{
    public Planet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.PLANET);
    }


    // Check whether the bodytype is moon
    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if(moon.getKey().getBodyType() == BodyType.MOON){
            return  super.addSatellite(moon);
        } else {
            return false;
        }
    }
}
