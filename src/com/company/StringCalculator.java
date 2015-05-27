package com.company;

/**
 * Created by sgluter on 26/05/15.
 */
public class StringCalculator {
    public int add(String number) {
        if (number.isEmpty()) {
            return 0;
        }


        if (number.length() == 1) {
            return toInt(number);
        }

        String[] elements = number.split(",");
        return toInt(elements[0]) + toInt(elements[1]);

    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
