package com.company;


import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    public int add(String string) {
        if (isNoElement(string)) {
            return 0;
        }

        String[] separateElements = separateElements(string);
        checkNegatives(separateElements);

        return addElements(separateElements);
    }

    private boolean isNoElement(String number) {
        return number.isEmpty();
    }

    private String[] separateElements(String number) {
        return number.split("[^0-9-]+");
    }

    private void checkNegatives(String[] separateElements) {

        List<String> negativeNumbers = new ArrayList<>();

        for (String element: separateElements) {
            if (toInt(element) <0)
                negativeNumbers.add(element);
        }

        if (negativeNumbers.size()>0) {
            String msg = String.join(",", negativeNumbers.toArray(new String[negativeNumbers.size()]));
            throw new IllegalArgumentException("Negatives not allowed: "+msg);
        }
    }

    private int addElements(String[] separateElements) {
        int accumulator = 0;
        for (String element: separateElements) {
            accumulator += toInt(element);
        }
        return accumulator;
    }

    private int toInt(String number) {
        return number.isEmpty() ? 0 : Integer.parseInt(number);
    }
}
