package com.jcedenon.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
//void accept(T t)
public class ConsumerApp {

    private void method1(){
        Consumer<String> imprimir = System.out::println; // x->System.out.println(x);

        // x-> service.registrar(x); => service::registrar
        imprimir.accept("Hola");

        List<String> lista = List.of("Hola", "Mundo");
        lista.forEach(imprimir::accept);
    }

    private void method2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Consumer<Integer> consumer = x -> {
            x = x + 1;
            System.out.println(x);
        };

        listAll(list, consumer);
    }

    //High Order Function
    private <T> void listAll(List<T> list, Consumer<T> consumer){
        for (T t : list){
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {
        ConsumerApp app = new ConsumerApp();
//        app.method1();
        app.method2();
    }
}
