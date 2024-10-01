package patterns;

import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public void primePattern(int n) {
        // Initialize a 2D array 'matrix' of size n x n.
        var matrix = new int[n][n];

        // Calculate the number of primes needed using the formula for sum of first 'n' natural numbers.
        // size = n * (n + 1) / 2 is the number of elements required to fill the pattern in the matrix.
        var size = n * (n + 1) / 2;

        // Generate 'size' number of prime numbers and store them in the 'primes' list.
        // This will be used to fill the matrix in a specific pattern.
        var primes = generatePrimes(size);

        // Initialize a counter 'i' to track the current prime number to be placed in the matrix.
        int i = 0;

        /*
         * The following nested loops fill the matrix in a specific pattern:
         * For each column, starting from the diagonal (i = j), we fill the column with prime numbers.
         * As col increases, the starting point of filling (row) shifts downwards.
         * This results in a triangular pattern of prime numbers.
         */
        for (int col = 0; col < n; col++) {
            for (int row = col; row < n; row++) {
                // Assign prime numbers from the list into the matrix, row by row for each column.
                matrix[row][col] = primes.get(i++);
            }
        }

        // Now, the matrix is filled. The next step is to print the non-zero values row-wise.
        // The outer loop iterates over each row of the matrix.
        for (var arr : matrix) {
            // The inner loop checks each element of the current row.
            for (var a : arr) {
                // Print the element if it's non-zero (which means it's part of the pattern).
                if (a != 0) System.out.print(a + " ");
            }
            // Move to the next line after each row is printed.
            System.out.println();
        }
    }


    private List<Integer> generatePrimes(int size) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        int num = 3;
        while (list.size() <= size - 1) {
            num += 2;
            if (isPrime(num)) list.add(num);
        }
        return list;
    }

    private boolean isPrime(int num) {
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i <= Math.sqrt(num) ; i += 2) {
            if (num % i == 0) return false;
        }

        return true;

    }
}
