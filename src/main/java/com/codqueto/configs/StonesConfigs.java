package com.codqueto.configs;

import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.TimeStone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("com.codqueto")
public class StonesConfigs {

    @Bean("mind")
    @Scope("prototype")
    public MindStone mindStone() {
        return new MindStone();
    }

    @Bean("power")
    @Scope("prototype")
    public PowerStone PowerStone() {
        return new PowerStone();
    }

    @Bean("reality")
    @Scope("prototype")
    public RealityStone RealityStone() {
        return new RealityStone();
    }

    @Bean("soul")
    @Scope("prototype")
    public SoulStone soulStone() {
        return new SoulStone();
    }

    @Bean("space")
    @Scope("prototype")
    public SpaceStone spaceStone() {
        return new SpaceStone();
    }

    @Bean("time")
    @Scope("prototype")
    public TimeStone timeStone() {
        return new TimeStone();
    }
}

