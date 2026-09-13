package com.thealgorithms.maths;

// final class - Inheritance is not possible.
public final class AbsoluteMin {

    // The constructor has been made private.
    // It is not possible to create an object of the class.
    private AbsoluteMin() {}

    // Compares the numbers given as arguments to get the absolute min value.
    // With [varargs], you can specify any number of arguments.
    public static int getMinValue(int... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Numbers array cannot be empty or null");
        }

        // By default, the first input is set equal to the smallest absolute value.
        // If the `long` data type is not used, there is a possibility of numerical overflow.
        // [int] -> 32 bit / [long] -> 64 bit
        long absMin = numbers[0];

        // The `long` data type is used here because the absolute value of a negative
        // number might exceed the range of the `int` type.

        for (int i = 1; i < numbers.length; i++) {
            // To prevent overflowing
            long current = numbers[i];

            if (Math.abs(current) < Math.abs(absMin)
                    || (Math.abs(current) == Math.abs(absMin)
                    && current < absMin)) {
                absMin = current;
            }
        }
        // The `long` type is converted to `int`.
        return (int) absMin;
    }
}
