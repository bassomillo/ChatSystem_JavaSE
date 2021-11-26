package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaTest {
    List<Person> personList = new ArrayList<>();
    List<Integer> simpleList = Arrays.asList(15,22,9,11,33,52,14);

    @BeforeEach
    public void initData(){
        personList.add(new Person("a",3000,23,"male","ottawa"));
        personList.add(new Person("b",7000,34,"male","vancouver"));
        personList.add(new Person("c",5200,22,"female","ottawa"));
        personList.add(new Person("d",1500,33,"female","toronto"));
        personList.add(new Person("e",8000,44,"female","seattle"));
        personList.add(new Person("f",6200,36,"female","montreal"));
    }

    @Test
    public void foreachTest(){
        personList.stream().forEach(System.out::println);
    }

    @Test
    public void findTest(){
        Optional<Integer> first = simpleList.stream().findFirst();
        first.ifPresent(System.out::println);
        Optional<Integer> any = simpleList.stream().findAny();
        any.ifPresent(System.out::println);

        Optional<Integer> firstMulti = simpleList.parallelStream().findFirst();
        first.ifPresent(System.out::println);
        Optional<Integer> anyMulti = simpleList.parallelStream().findAny();
        any.ifPresent(System.out::println);
    }

    @Test
    public void matchTest(){
        //if all salary is more than 5000
        boolean allMatch = personList.stream().allMatch(person -> person.getSalary() > 5000);
        //if anyone's salary is more than 5000
        boolean anyMatch = personList.stream().anyMatch(person -> person.getSalary() > 5000);
        System.out.println("allMatch = " + allMatch);
        System.out.println("anyMatch = " + anyMatch);
    }

    @Test
    public void countTest(){
        long count = simpleList.stream().count();
        System.out.println(count);

        OptionalDouble average = simpleList.stream().mapToInt(new ToIntFunction<Integer>() {
            @Override
            public int applyAsInt(Integer value) {
                return value;
            }
        }).average();
        System.out.println("average = " + average);

        int sum = IntStream.of(1, 2, 3, 4).sum();
        System.out.println("sum = " + sum);
        OptionalInt max = new Random().ints(20).max();
        OptionalInt min = new Random().ints(20).min();
        Optional<Person> max1 = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("max1 = " + max1);
    }

    @Test
    public void reduceTest(){
        int reduce = IntStream.of(1, 2, 3, 4).reduce(1, (n1, n2) -> n1 * n2);
        System.out.println("reduce = " + reduce);
    }

    @Test
    public void joinTest(){
        List<String> strings = Arrays.asList("a","b","c");
        String collect = strings.stream().collect(Collectors.joining("-"));
        System.out.println("collect = " + collect);
    }

    @Test
    public void groupTest(){
        Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(p -> p.getSalary() > 5000));
        System.out.println("collect = " + collect);
        Map<String, List<Person>> collect1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println("collect1 = " + collect1);
    }

    @Test
    public void collectTest(){
        List<Integer> collect = simpleList.stream().collect(Collectors.toList());
        Set<Integer> collect1 = simpleList.stream().collect(Collectors.toSet());
        Map<String, Person> collect2 = personList.stream().collect(Collectors.toMap(person -> person.getName(), person -> person));//first lambda for key,second for the value
        System.out.println("collect = " + collect);
        System.out.println("collect1 = " + collect1);
        System.out.println("collect2 = " + collect2);
    }

    @Test
    public void filterTest(){
        personList.stream().filter(p->p.getSalary()>5000).forEach(System.out::println);
    }

    @Test
    public void mapTest(){
        List<Integer> collect = personList.stream().map(p -> p.getSalary()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        personList.stream().map(p->{
            p.setSalary(p.getSalary()+1000);
            return p;
        }).forEach(System.out::println);
    }

    @Test
    public void sortTest(){
        List<Person> collect = personList.stream().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).collect(Collectors.toList());
        System.out.println("collect = " + collect);
    }

    @Test
    public void peekTest(){
        //Using peek is in order to debug
        List<Person> collect = personList.stream().peek(System.out::println).collect(Collectors.toList());
        //Using peek is in order to change items in the stream
        personList.stream().peek(p->p.setSalary(p.getSalary()+1000)).forEach(System.out::println);

    }

    @Test
    public void othersTest(){
        simpleList.stream().distinct().skip(2).forEach(System.out::println);
        //Try to figure out the highest salary of men and women representatively
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        for(Map.Entry<String,List<Person>> entry: collect.entrySet()){
            String key = entry.getKey();
            Integer i = entry.getValue().stream().mapToInt(Person::getSalary).max().orElse(0);
            stringIntegerHashMap.put(key,i);
        }
        System.out.println("stringIntegerHashMap = " + stringIntegerHashMap);
    }
}
