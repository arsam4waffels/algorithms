package com.thealgorithms.dynamicprogramming;
import java.util.HashMap;
import java.util.Map;
/**
 * Collection of Dynamic Programming techniques to solve for the n-th Fibonacci number.
 * <p>
 * This file showcases Top-Down Memoization ({@code fibMemo}), Bottom-Up Tabulation ({@code fibBotUp}),
 * and Space-Optimized Iteration ({@code fibOptimized}).
 * <p>
 * For alternative structural paradigms, mathematical formulas, or verification steps, see:
 * <ul>
 * <li>{@link com.thealgorithms.maths.FibonacciLoop} - Standard Iterative (Loop) approach</li>
 * <li>{@link com.thealgorithms.recursion.FibonacciSeries} - Naive Recursive approach</li>
 * <li>{@link com.thealgorithms.maths.FibonacciJavaStreams} - Functional approach using Java Streams</li>
 * <li>{@link com.thealgorithms.maths.FibonacciNumberGoldenRation} - Closed-form expression using Binet's formula</li>
 * <li>{@link com.thealgorithms.maths.FibonacciNumberCheck} - Utility to check if a given number is a Fibonacci number</li>
 * <li>{@link com.thealgorithms.matrix.matrixexponentiation.Fibonacci} - O(log n) Matrix Exponentiation approach</li>
 * </ul>
 * * @author Varun Upadhyay (https://github.com/varunu28)
 */
public final class Fibonacci {
    private Fibonacci() {}

    static final Map<Integer, Integer> CACHE = new HashMap<>();

    /**
     * This method finds the nth fibonacci number using memoization technique
     *
     * @param n The input n for which we have to determine the fibonacci number
     * Outputs the nth fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static int fibMemo(int n) { // Recursive + Cache
        if (n < 0) {
            throw new IllegalArgumentException("Input n must be non-negative");
        }

        /*
         * Fibonacci(4)
         * ├── Fibonacci(3)
         * │   ├── Fibonacci(2)  ← CACHE[2]=1
         * │   └── Fibonacci(1)
         * └── Fibonacci(2)      ← CACHE[2]=1
         */
        if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        }

        int f;

        if (n <= 1) {
            f = n;
        } else {
            f = fibMemo(n - 1) + fibMemo(n - 2);
            CACHE.put(n, f);
        }
        return f;
    }

    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     * Outputs the nth fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static int fibBotUp(int n) { // Iterative + HashMap
        if (n < 0) {
            throw new IllegalArgumentException("Input n must be non-negative");
        }
        Map<Integer, Integer> fib = new HashMap<>();

        /*
         * Fibonacci(4)
         *     → Fibonacci(3)
         *         → Fibonacci(2)
         *             → Fibonacci(1) = 1 <- start
         *
         * i=0 → fib[0] = 0
         * i=1 → fib[1] = 1
         * i=2 → fib[2] = fib[1] + fib[0] = 1
         * i=3 → fib[3] = fib[2] + fib[1] = 2
         * i=4 → fib[4] = fib[3] + fib[2] = 3
         */
        for (int i = 0; i <= n; i++) {
            int f;
            if (i <= 1) {
                f = i;
            } else {
                f = fib.get(i - 1) + fib.get(i - 2);
            }
            fib.put(i, f);
        }

        return fib.get(n);
    }

    /**
     * This method finds the nth fibonacci number using bottom up
     *
     * @param n The input n for which we have to determine the fibonacci number
     * Outputs the nth fibonacci number
     * <p>
     * This is optimized version of Fibonacci Program. Without using Hashmap and
     * recursion. It saves both memory and time. Space Complexity will be O(1)
     * Time Complexity will be O(n)
     * <p>
     * Whereas , the above functions will take O(n) Space.
     * @throws IllegalArgumentException if n is negative
     * @author Shoaib Rayeen (https://github.com/shoaibrayeen)
     */
    public static int fibOptimized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input n must be non-negative");
        }
        if (n == 0) {
            return 0;
        }
        int prev = 0;
        int res = 1;
        int next;
        for (int i = 2; i <= n; i++) {
            next = prev + res;
            prev = res;
            res = next;
        }
        return res;
    }

    /**
     * We have only defined the nth Fibonacci number in terms of the two before it. Now, we will
     * look at Binet's formula to calculate the nth Fibonacci number in constant time. The Fibonacci
     * terms maintain a ratio called golden ratio denoted by Φ, the Greek character pronounced
     * ‘phi'. First, let's look at how the golden ratio is calculated: Φ = ( 1 + √5 )/2
     * = 1.6180339887... Now, let's look at Binet's formula: Sn = Φⁿ–(– Φ⁻ⁿ)/√5 We first calculate
     * the squareRootof5 and phi and store them in variables. Later, we apply Binet's formula to get
     * the required term. Time Complexity will be O(1)
     * @param n The input n for which we have to determine the fibonacci number
     * Outputs the nth fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static int fibBinet(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Input n must be non-negative");
        }
        // The square root of the integer 5
        double squareRootOf5 = Math.sqrt(5);

        // General Phi formula
        // The square root of 5 is obtained by solving a quadratic equation.
        double phi = (1 + squareRootOf5) / 2;

        /*
         * In Binet's formula, we proceed as follows:
         *
         * first, we raise phi to the power of the requested number. Next, we retain that result
         * and subtract from it the value of negative phi raised to the negative of the requested
         * number. Finally, we divide the resulting value by the square root of 5 to obtain the
         * final result.
         *
         * The final calculated value is ultimately converted to the `int` type.
         * This entails certain risks, including data overflow and calculation errors.
         */
        return (int) ((Math.pow(phi, n) - Math.pow(-phi, -n)) / squareRootOf5);
    }
}
