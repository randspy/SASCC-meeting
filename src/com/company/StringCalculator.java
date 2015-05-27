package com.company;


public class StringCalculator {
    public int add(String string) {
        if (isNoElement(string)) {
            return 0;
        }

        int accumulator = 0;
        for (String element: separateElements(string)) {
            accumulator += toInt(element);
        }
        return accumulator;
    }

    private boolean isNoElement(String number) {
        return number.isEmpty();
    }

    private String[] separateElements(String number) {
        return number.split(",|\n");
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
