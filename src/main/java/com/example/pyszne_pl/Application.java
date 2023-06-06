package com.example.pyszne_pl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class Application {

    public static Logger logger;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        runLogger();
        logger.info("App started successfully.");
    }

    private static void runLogger(){
        FileHandler fh;
        logger = Logger.getLogger("logs");
        try {
            fh = new FileHandler("logs.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.addHandler(fh);

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        logger.info("Logger initialized.");
    }

}
