package handler;

import annotation.Singleton;
import context.ApplicationContext;

import java.util.List;

public class SingletonHandler {

    public static void handler(List<String> classNames){
        for (String className : classNames) {
            Class<?> aClass = null;
            try {
                aClass = Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Singleton annotation = aClass.getAnnotation(Singleton.class);
            if(annotation!=null){
                Object instance = null;
                try {
                    instance = aClass.newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                ApplicationContext.addSingleton(aClass,instance);
            }
        }
    }
}
