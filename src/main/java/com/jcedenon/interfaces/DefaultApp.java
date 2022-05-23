package com.jcedenon.interfaces;

public class DefaultApp {

    public static void main(String[] args) {
        Operacion op = new Sumar();
        op.calcular();
        op.mostrar();
    }
}
