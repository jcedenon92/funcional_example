package com.jcedenon.interfaces;

public class Sumar implements Operacion, Operacion2{

    @Override
    public void calcular() {
        System.out.println("Suma");
    }

    @Override
    public void mostrar() {
        Operacion.super.mostrar();
        Operacion2.super.mostrar();
    }

    @Override
    public void calcular2() {

    }
}
