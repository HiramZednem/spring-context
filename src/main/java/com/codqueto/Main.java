package com.codqueto;

import com.codqueto.configs.StonesConfigs;
import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.TimeStone;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.codqueto.services.GauntletService;
import com.codqueto.services.GauntletServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(StonesConfigs.class);

        final GauntletService gauntletService = applicationContext.getBean(GauntletServiceImpl.class);
        gauntletService.useFullPower();

//        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StonesConfigs.class);
//
////        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stones.xml");
//
//        GauntletServiceImpl gauntletService = applicationContext.getBean("gauntlet", GauntletServiceImpl.class);
//        gauntletService.useFullPower();
//        gauntletService.useGauntlet("mind");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("stones.xml");
//
//        final MindStone mind = applicationContext.getBean("mind", MindStone.class);
//        final PowerStone power = applicationContext.getBean("power", PowerStone.class);
//        final RealityStone reality = applicationContext.getBean("reality", RealityStone.class);
//        final SoulStone soul = applicationContext.getBean("soul", SoulStone.class);
//        final SpaceStone space = applicationContext.getBean("space", SpaceStone.class);
//        final TimeStone time = applicationContext.getBean("time", TimeStone.class);
//
//        GauntletService gauntletService  = new GauntletServiceImpl(mind, power, reality, soul, space, time);
//        System.out.println(mind);
//        gauntletService.useGauntlet("mind");
    }
}