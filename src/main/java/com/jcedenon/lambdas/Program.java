package com.jcedenon.lambdas;

public class Program {

    private double sumar(double a, double b){
        IOperacion operacion = (x,y) -> x + y;
        return operacion.operar(a,b);
    }

    private double restar(double a, double b){
        IOperacion operacion = (x,y) -> x - y;
        return operacion.operar(a,b);
    }

    private double multiplicar(double a, double b){
        IOperacion operacion = (x,y) -> x * y;
        return operacion.operar(a,b);
    }

    public static void main(String[] args) {
        Program program = new Program();
        double suma = program.sumar(1,2);
        System.out.println("La suma es: " + suma);
        double restar = program.restar(1,2);
        System.out.println("La resta es: " + restar);
        double multiplicar = program.multiplicar(1,2);
        System.out.println("La multiplicación es: " + multiplicar);
    }
}
