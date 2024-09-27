package prime;

import java.util.Arrays;

public class SieveOfErotosthenes {
    public void sieveOfErotosthenes(int start, int end) {
        boolean[] primes = new boolean[end + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i <= end; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= end; j += i)
                    primes[j] = false;
            }
        }

        for (int i = 2; i <= end; i++) {
            if (primes[i]) System.out.println(i + " ");
        }
    }
}
