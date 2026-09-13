package com.thealgorithms.maths;
import java.math.BigInteger;
/**
 * This class provides methods for calculating Fibonacci numbers using BigInteger for large values of 'n'.
 * <p>
 * This specific implementation uses an <b>Iterative approach (Loop)</b> with {@code O(n)} time complexity
 * and {@code O(1)} space complexity.
 * <p>
 * For alternative approaches to compute or verify Fibonacci numbers, see:
 * <ul>
 * <li>{@link com.thealgorithms.recursion.FibonacciSeries} - Naive Recursive approach</li>
 * <li>{@link com.thealgorithms.dynamicprogramming.Fibonacci} - Dynamic Programming approaches (Memoization, Bottom-Up, Optimized)</li>
 * <li>{@link com.thealgorithms.maths.FibonacciJavaStreams} - Functional approach using Java Streams</li>
 * <li>{@link com.thealgorithms.maths.FibonacciNumberGoldenRation} - Closed-form expression using Binet's formula</li>
 * <li>{@link com.thealgorithms.maths.FibonacciNumberCheck} - Utility to check if a given number is a Fibonacci number</li>
 * <li>{@link com.thealgorithms.matrix.matrixexponentiation.Fibonacci} - O(log n) Matrix Exponentiation approach</li>
 * </ul>
 */
public final class FibonacciLoop {

    // Private constructor to prevent instantiation of this utility class.
    private FibonacciLoop() {}

    // Calculates the nth Fibonacci number.
    // Instead of `long`, the `BigInteger` type is used, as it can store a much larger value.
    public static BigInteger compute(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input 'n' must be a non-negative integer.");
        }

        // n = 0  →  BigInteger.valueOf(0)  =  0
        // n = 1  →  BigInteger.valueOf(1)  =  1
        if (n <= 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger prev = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        // The index number starts at two because the numbers zero and one
        // have already been accounted for at indices zero and one.
        for (int i = 2; i <= n; i++) {
            BigInteger next = prev.add(current);
            prev = current;
            current = next;
        }

        return current;
    }
}
