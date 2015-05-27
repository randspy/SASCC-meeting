package com.company;

/**
 * Created by sgluter on 26/05/15.
 */
public class StringCalculator {
    public int add(String number) {
        if (isNoElement(number)) {
            return 0;
        }

        String[] elements = seperateElements(number);

        if (isOneElement(elements)) {
            return toInt(number);
        }

        return toInt(elements[0]) + toInt(elements[1]);

    }

    private boolean isNoElement(String number) {
        return number.isEmpty();
    }

    private boolean isOneElement(String[] elements) {
        return elements.length == 1;
    }

    private String[] seperateElements(String number) {
        return number.split(",");
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
