package prime;

import java.util.Arrays;

public class SieveOfErotosthenes {
    public static int[] sieveOfErotosthenes(int end) {
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= end; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= end; j += i)
                    isPrime[j] = false;
            }
        }

        var primes = new int[end + 1];
        for (int i = 2; i <= end; i++) {
            if (isPrime[i]) primes[i] = i;
        }

        return primes;
    }
}
