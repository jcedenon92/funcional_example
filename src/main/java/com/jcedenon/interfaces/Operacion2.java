package com.jcedenon.interfaces;

public interface Operacion2 {

    void calcular2();

    default void mostrar(){
        System.out.println("Operacion");
    }
}
