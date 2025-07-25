package com.codqueto.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@ToString(callSuper = true)
@Log
public class MindStone extends Stone{
    private static final String COLOR = "Yellow";
    private static final String NAME = "Mind Stone";
    private static final String LOCATION = "Scepter";
    private static final int ENERGY_LEVEL = 4;

    public MindStone() {
        super(COLOR, NAME, LOCATION, ENERGY_LEVEL);
    }

    @Override
    public void usePower() {
        System.out.println("Mind control in stone: " + super.toString());
    }

    public MindStone getPrototype() {
        try (
            final var bos = new ByteArrayOutputStream();
            final var oos = new ObjectOutputStream(bos);
        ){

            // serialize object
            oos.writeObject(this);
            oos.flush();

            try (
                final var bis = new ByteArrayInputStream(bos.toByteArray());
                final var ois = new ObjectInputStream(bis);
            ){

                // cast
                return (MindStone) ois.readObject();
            }


        } catch ( IOException | ClassNotFoundException e){
           log.warning("Can't cast or read class");
           throw new RuntimeException(e.getMessage());
        }
    }
}