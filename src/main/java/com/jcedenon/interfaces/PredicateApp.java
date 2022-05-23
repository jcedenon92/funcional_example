package com.jcedenon.interfaces;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

//boolean test(T t);
public class PredicateApp {

    private void method1(){
        Person p = new Person();
        p.setId(1);
        p.setName("Juan");
        p.setAge(20);

        Predicate<Person> mayorQue = x -> x.getAge() >= 18;
        if (mayorQue.test(p)){
            System.out.println("Es mayor de edad");
        }

        method2();
    }

    private void method2(){
        Predicate<Integer> mayorQue10 = x -> x >= 10;
        Predicate<Integer> menorQue20 = x -> x <= 20;

        boolean rpta1 = mayorQue10.and(menorQue20).test(15);
        boolean rpta2 = mayorQue10.and(menorQue20).negate().test(25);

        System.out.println(rpta1);
        System.out.println(rpta2);
    }

    private void method3(int num1, Predicate<Integer> predicate){
        boolean rpta = predicate.test(num1);
        System.out.println(rpta);
    }

    public static void main(String[] args) {
        PredicateApp p1 = new PredicateApp();
//        p1.method1();
//        p1.method2();
        p1.method3(7, x -> x > 5);
    }
}
