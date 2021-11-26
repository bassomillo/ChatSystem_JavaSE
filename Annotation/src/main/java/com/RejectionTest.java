package com;

import annotation.MyAnnotation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RejectionTest {
    private Class clazz = null;

    @BeforeEach
    public void before(){
        clazz = Dog.class;
    }

    @Test
    public void clazzTest(){

        System.out.println("clazz.isAnnotation() = " + clazz.isAnnotation());
        try {
            Dog dog = (Dog) clazz.newInstance();
            dog.setName("apple");
            System.out.println("dog = " + dog);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void FieldTest() throws NoSuchFieldException, IllegalAccessException {
        Field[] fields = clazz.getFields();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field.getName() = " + field.getName());
        }
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField.getName() = " + declaredField.getName());
        }
        Dog dog = new Dog();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(dog,"jerry");
        String dogName = (String)name.get(dog);
        System.out.println("dogName = " + dogName);
    }

    @Test
    public void MethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod.getName() = " + declaredMethod.getName());
        }

        Method eat = clazz.getDeclaredMethod("eat");
        Method eat1 = clazz.getDeclaredMethod("eat", String.class);
        Dog dog = new Dog();
        eat1.setAccessible(true);
        eat1.invoke(dog,"meat");
        eat.setAccessible(true);
        eat.invoke(dog);
    }

    @Test
    public void ConstructorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        Constructor declaredConstructor = clazz.getDeclaredConstructor();
        Constructor declaredConstructor1 = clazz.getDeclaredConstructor(int.class, String.class);
        declaredConstructor1.setAccessible(true);
        Dog dog = (Dog) declaredConstructor.newInstance();
        Dog jerry = (Dog) declaredConstructor1.newInstance(2, "jerry");
        String name = jerry.getName();
        System.out.println("name = " + name);
    }

    @Test
    public void AnnotationTest() throws NoSuchMethodException {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("annotation = " + annotation);
        }
        MyAnnotation setName = clazz.getDeclaredMethod("setName",String.class).getAnnotation(MyAnnotation.class);
        String name = setName.name();
        System.out.println(name);
        MyAnnotation annotation = (MyAnnotation) clazz.getAnnotation(MyAnnotation.class);
        int value = annotation.value();
        System.out.println(value);
    }


    public static void main(String[] args) {
        Class clazz = Dog.class;
        Class<?> aClass = null;
        try {
            aClass = Class.forName("com.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Dog dog = new Dog();
        Class<? extends Dog> bClass = dog.getClass();
        System.out.println(clazz==bClass);
        System.out.println(bClass==aClass);
    }
}
