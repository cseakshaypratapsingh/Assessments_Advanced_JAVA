package com.example.storagesystem;

import com.example.storagesystem.config.AppConfig;
import com.example.storagesystem.service.StorageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StorageSystemApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StorageService storage = context.getBean(StorageService.class);

        storage.storeFile("cloudFile.txt");

        StorageService local1 = (StorageService) context.getBean("localStorage");

        StorageService local2 = (StorageService) context.getBean("localStorage");

        local1.storeFile("localFile1.txt");
        local2.storeFile("localFile2.txt");

        System.out.println(local1 == local2);

        context.close();
    }

}