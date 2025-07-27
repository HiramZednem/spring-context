package com.codqueto.services;

import com.codqueto.models.Stone;
import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

//@ServiceAdd commentMore actions
@Log
@Getter
@Component
public class GauntletServiceImpl implements GauntletService {

    private final Stone mindStone;
    private final Stone powerStone;
    private final Stone realityStone;
    private final Stone soulStone;
    private final Stone spaceStone;
    private final Stone timeStone;

    @Autowired
    public GauntletServiceImpl(
            @Qualifier("mind") Stone mindStone,
            @Qualifier("power") Stone powerStone,
            @Qualifier("reality") Stone realityStone,
            @Qualifier("soul") Stone soulStone,
            @Qualifier("space") Stone spaceStone,
            @Qualifier("time") Stone timeStone
    ) {
        this.mindStone = mindStone;
        this.powerStone = powerStone;
        this.realityStone = realityStone;
        this.soulStone = soulStone;
        this.spaceStone = spaceStone;
        this.timeStone = timeStone;
    }

    @Override
    public void useGauntlet(String stoneName) {
        switch (stoneName) {
            case "mind" -> log.info("Use stone: " + this.mindStone);
            case "power" -> log.info("use stone: " + this.powerStone);
            case "reality" -> log.info("Use stone: " + this.realityStone);
            case "soul" -> log.info("Use stone: " + this.soulStone);
            case "space" -> log.info("Use stone: " + this.spaceStone);
            case "time" -> log.info("Use stone: " + this.timeStone);
            default -> throw new IllegalArgumentException("Invalid Name");
        }

    }

    @Override
    public void useFullPower() {
        if (
                this.mindStone != null &&
                this.powerStone != null &&
                this.realityStone != null &&
                this.soulStone != null &&
                this.spaceStone != null &&
                this.timeStone != null
        ) {
            log.info("using all power");
        } else {
            throw new IllegalStateException("You need to have all the stones to use full power");
        }

    }

    public void setStones(Map<String, Stone> stones) {
        stones.forEach((fieldName, stone) -> {
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, stone);
                log.info("Dependency Inyection of " + fieldName);
                field.setAccessible(false);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}