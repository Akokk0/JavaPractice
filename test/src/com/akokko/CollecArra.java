package com.akokko;

import java.util.ArrayList;

public class CollecArra {

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList<>();

        arrayList.add("Hello,World");
        arrayList.add("ABC");
        arrayList.add("CDA");

        for (Object o : arrayList) {

            System.out.println(o);

        }

    }

}
