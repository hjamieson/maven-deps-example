package alpha;

import java.util.ArrayList;
import java.util.List;

public class MathImpl implements MathClass {
    public List<Integer> allPrimes(int min, int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (isPrime(i))
                result.add(i);
        }
        return result;
    }

    public int highestPrime(int min, int max) {
        List<Integer> primes = allPrimes(min, max);
        return primes.get(primes.size() - 1);
    }

    /**
     * a number is prime if
     *
     * @param num the number to test
     * @return true if prime
     */
    public boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
