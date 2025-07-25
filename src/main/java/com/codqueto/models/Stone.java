package com.codqueto.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Log
public abstract class Stone implements Serializable
{

    String color;
    String name;
    String location;
    Integer energyLevel;
    Integer numberOfSides;

    private static final int NUMBER_OF_SIDES = 6;


    public Stone(String color, String name, String location, Integer energyLevel) {
        this.color = color;
        this.name = name;
        this.location = location;
        this.energyLevel = energyLevel;
        this.numberOfSides = NUMBER_OF_SIDES;
    }

    public abstract void usePower();

    public void clear() {
        log.info("Cleaning stone");
    }
}
