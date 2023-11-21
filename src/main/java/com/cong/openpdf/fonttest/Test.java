package com.cong.openpdf.fonttest;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        String stringTrue = "1";
        Integer intTrue = 1;
        System.out.println(Objects.equals(Integer.valueOf(stringTrue), intTrue));
        System.out.println(Objects.equals(stringTrue, "1") || Objects.equals(stringTrue, 1));
    }
}
