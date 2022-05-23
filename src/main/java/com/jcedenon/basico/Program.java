package com.jcedenon.basico;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.forEach(x -> {
            x += 1;
            System.out.println(x);
        });
    }
}
