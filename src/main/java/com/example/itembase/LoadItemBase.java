//package com.example.itembase;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class LoadItemBase {
//
//    private static final Logger log = LoggerFactory.getLogger(LoadItemBase.class);
//
//    @Bean
//    CommandLineRunner initDatabase(ItemRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Item(1L, "Bracer", 550F,
//                    "The bracer is a common choice to toughen up defenses and increase longevity.")));
//            log.info("Preloading " + repository.save(new Item(2L, "Clarity", 50F, "Best Item")));
//        };
//    }
//}
