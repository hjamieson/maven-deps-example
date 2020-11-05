package alpha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathClassTest {
    // create an impl
    class MyMath implements MathClass {

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

    @Test
    public void testAllPrimes() {
        MathClass testClass = new MathImpl();
        List<Integer> primes = testClass.allPrimes(2, 2);
        assertEquals(1, primes.size());
        assertEquals(3, testClass.allPrimes(2, 6).size());
    }

    @Test
    void testMaxPrime() {
        MathClass testClass = new MathImpl();
        int maxPrime = testClass.highestPrime(2, 2);
        assertEquals(2, maxPrime);
        assertEquals(5, testClass.highestPrime(2, 6));
    }
}
