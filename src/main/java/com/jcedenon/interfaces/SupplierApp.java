package com.jcedenon.interfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

//T get();
public class SupplierApp {

    private void method1(){
        Supplier<LocalDateTime> s = () -> {
            return LocalDateTime.now().minusDays(5);
        };

        System.out.println(s.get());
    }

    public static void main(String[] args) {
        SupplierApp app = new SupplierApp();
        app.method1();
    }
}
