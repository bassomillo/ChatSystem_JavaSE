package com;

import context.ApplicationContext;
import handler.SingletonHandler;

import java.net.URL;
import java.util.List;

public class BootStrap {
    static {
        final URL resource = Thread.currentThread().getContextClassLoader().getResource("");
        List<String> fileNames = FileUtil.FileToList(resource.getFile());
        System.out.println("fileNames = " + fileNames);
        SingletonHandler.handler(fileNames);
    }
    public static void main(String[] args) {
        System.out.println("ApplicationContext.getSingleton(Dog.class) = " + ApplicationContext.getSingleton(Dog.class));
    }
}
