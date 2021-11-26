package com;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgramming implements Function<String,String> {

    @Override
    public String apply(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String abc = new FunctionalProgramming().apply("abc");
        System.out.println(abc);
        Function<String,String> function= s->s.toUpperCase();
        String abbc = function.apply("abbc");
        Consumer<String> consumer = System.out::println;
        consumer.accept(abbc);
        Supplier<String> stringSupplier = () -> "abc";
        String s = stringSupplier.get();
        consumer.accept(s);
        Predicate<String> predicate = v -> v.contains("a");
        System.out.println("predicate.test(\"asd\") = " + predicate.test("asd"));


    }
}
