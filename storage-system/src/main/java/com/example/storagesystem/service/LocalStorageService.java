package com.example.storagesystem.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage") // custom bean name
@Scope("prototype") // new object every time requested
@Lazy // created only when needed
public class LocalStorageService implements StorageService {

    public LocalStorageService() {
        System.out.println("LocalStorageService Bean Created");
    }

    @Override
    public void storeFile(String fileName) {
        System.out.println("File stored in Local Storage: " + fileName);
    }

}