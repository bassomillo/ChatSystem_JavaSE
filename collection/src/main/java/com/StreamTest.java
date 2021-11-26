package com;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void CreateTest(){
        //use set to creat stream
        List<Integer> list= new ArrayList<>();
        Stream<Integer> stream = list.stream();
        String[] strings = {"a"};
        int[] ints = {1,2,3};
        Stream<String> stream1 = Arrays.stream(strings);
        IntStream stream3 = Arrays.stream(ints);
        //Stream class itself has static methods to creat stream
        Stream<? extends Serializable> concat = Stream.concat(stream, stream1);
        Stream<String> a = Stream.of("a", "b", "cde");

        //Random
        IntStream ints1 = new Random().ints(100);

    }

}
