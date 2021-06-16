package com.oneskool.home;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class HomeController {
    private final Logger log = LogManager.getLogger(this.getClass());

    @GetMapping(value = "/hello")
    public String getHello() {
        return "Hello there!!";
    }


    @GetMapping(value = "/")
    public HomeEntity getHome() {
        // We log some info
        log.info("Hello from home at " + new Date());

        HomeEntity entity = new HomeEntity(
                3,
                "Welcome to our application",
                "This application is all about showing how to build Spring Boot apps");
//
//        for(int i = 0; i < 5; i++) {
//            // more logging for no reason in a loop
//            log.info("This is the " + i + " time I say 'Hello World'.");
//
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ie) {     // catch errors
//                log.error("Error ", ie);
//            }
//        }

        return entity;
    }
}
