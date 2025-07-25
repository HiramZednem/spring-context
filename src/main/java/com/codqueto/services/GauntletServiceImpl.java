package com.codqueto.services;

import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.Stone;
import com.codqueto.models.TimeStone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.Map;

//@ServiceAdd commentMore actions
@Log
//@AllArgsConstructor
@NoArgsConstructor
@Getter
public class GauntletServiceImpl implements GauntletService {

    @Autowired
    private MindStone mindStone;
    @Autowired
    private PowerStone powerStone;
    @Autowired
    private RealityStone realityStone;
    @Autowired
    private SoulStone soulStone;
    @Autowired
    private SpaceStone spaceStone;
    @Autowired
    private TimeStone timeStone;

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