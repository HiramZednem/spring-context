package com.codqueto;

import com.codqueto.configs.StonesConfigs;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.codqueto.services.GauntletService;
import com.codqueto.services.GauntletServiceImpl;

/**
 * # Important things:
 * - What is the label @Bean?
 *      Every object managed by spring is called bean. When we use the
 *      label @Bean I create an object that is managed by spring
 *
 *
 * - What is IoC? (Inversion of Controll)
 *      When the flow control is delegated to a framework. In spring
 *      is when spring manages the creation, configuration and life
 *      cycle of the objects (beans).
 *
 *
 * - What is DI? (Dependency Injection)
 *      When an object receive his dependencies from external source
 *      can be from an XML file (old way) or through @configuration class
*       types of DI:
 *      - constructor
 *      - property
 *      - setter
 *      - method
 */
public class Main {
    public static void main(String[] args) {

        // Because I'm working with spring, i need to import my beans manually.
        // If I were using spring boot, this configuration will be handled.
        // automatically

        final AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(StonesConfigs.class);

        final GauntletService gauntletService = applicationContext.getBean(GauntletServiceImpl.class);
        gauntletService.useFullPower();


        /**
         * In this case I'm using a xml to load my beans. in this case, my stones are injected automatically
         * in my gauntlet service, because I used dependency injection with @autowired.
         * And I also used the @qualifier label to specify which one i want to inject depending on
         * the id.
         * This because all my stones are type stone, but each stones has differents power, so I specify
         * which one I need to use in each case with @qualifier.
         */
//        final ApplicationContext applicationContext = new ClassPathXmlApplicationContext("stones.xml");
//        GauntletServiceImpl gauntletService = applicationContext.getBean("gauntlet", GauntletServiceImpl.class);
//        gauntletService.useFullPower();
//        gauntletService.useGauntlet("mind");


        /**
         * In this case Im loading my beans manually and creating my service manually, in this
         * example im using only IoC because I'm creating my objects by the spring framework.
         * But I'm making the injection manually.
         */

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
//        gauntletService.useGauntlet("mind");
    }
}