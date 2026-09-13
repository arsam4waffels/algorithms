package com.thealgorithms.maths;


// final class - Inheritance is not possible.
public final class AbsoluteMax {

    // The constructor has been made private.
    // It is not possible to create an object of the class.
    private AbsoluteMax() {}

    // Finds the absolute maximum value among the given numbers.
    // With [varargs], you can specify any number of arguments.
    public static int getMaxValue(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }
        // By default, the first input is set equal to the largest absolute value.
        int absMax = numbers[0];

        // The counter `i` is initially set to 1, since the first data item is already
        // recorded by default and there is no need to compare it with itself.
        for (int i = 1; i < numbers.length; i++) {

            // [There are two possibilities]

            // 1. If the absolute value of the new data point is greater than the current one,
            // a swap should be performed.

            // 2. The absolute values are equal, but since the number is positive,
            // the positive value is selected.

            if (Math.abs(numbers[i]) > Math.abs(absMax)
                    || (Math.abs(numbers[i]) == Math.abs(absMax)
                    && numbers[i] > absMax))
            {
                absMax = numbers[i];
            }
        }
        return absMax;
    }
}
