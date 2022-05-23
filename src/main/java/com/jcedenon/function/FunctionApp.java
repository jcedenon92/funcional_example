package com.jcedenon.function;

import com.jcedenon.model.Employee;
import com.jcedenon.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//R apply(T t);
public class FunctionApp {

    private void m1Apply(){
        Function<String, Integer> func = x -> x.length();

        Integer rpta = func.apply("mitocode");
        System.out.println("Tamaño de cadena: " + rpta);
    }

    private void m2AndThen(){
        Function<String, Integer> func1 = String::length;
        Function<Integer, Integer> func2 = x -> x + 10;

        Integer rpta = func1.andThen(func2).apply("mitocode");
        System.out.println(rpta);

    }

    private void m2AndThenv2(){
        Function<Integer, Integer> func1 = x -> x * 2;
        Function<Integer, Integer> func2 = x -> x + 10;

        Integer rpta = func1.andThen(func2).apply(5);
        System.out.println(rpta);

    }

    private void m3Compose(){
        Function<Integer, Integer> func1 = x -> x * 2;
        Function<Integer, Integer> func2 = x -> x + 10;

        Integer rpta = func1.compose(func2).apply(5);
        System.out.println(rpta);
    }

    private void m4Identity(){
        //f(x) = x
        Function<Employee, Employee> f = Function.identity();
        System.out.println(f.apply(new Employee()));
    }

    private void m5Identity(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("1","Perez"));
        list.add(new Person("2","Perez"));
        list.add(new Person("3","Perez"));

        Map<String, Person> map = list.stream()
                                    .collect(Collectors.toMap(Person::getId, Function.identity()));

        System.out.println(map);
    }

    private void m6Identity(){
        Function<Integer, Integer> f1 = Function.identity();
        Function<Integer, Integer> f2 = Function.identity();
        Function<Integer, Integer> f3 = Function.identity();

        Function<Integer, Integer> ff1 = e -> e;
        Function<Integer, Integer> ff2 = e -> e;
        Function<Integer, Integer> ff3 = e -> e;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);

        System.out.println(ff1);
        System.out.println(ff2);
        System.out.println(ff3);
    }

    private int m7Factorial(int number){
        Function<Integer, Integer> f = x -> number * m7Factorial(number - 1);
        return number == 1 ? 1 : f.apply(number);
    }

    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();
//        app.m1Apply();
//        app.m2AndThen();
//        app.m2AndThenv2();
//        app.m3Compose();
//        app.m4Identity();
//        app.m5Identity();
//        app.m6Identity();
        double rpta = app.m7Factorial(5);
        System.out.println(rpta);
    }
}
