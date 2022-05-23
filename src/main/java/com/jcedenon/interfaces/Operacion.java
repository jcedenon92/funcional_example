package com.jcedenon.interfaces;

@FunctionalInterface
public interface Operacion {

    void calcular();

    default void mostrar(){
        System.out.println("Operacion");
    }
}
