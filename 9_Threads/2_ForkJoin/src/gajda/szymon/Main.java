package gajda.szymon;

import com.sun.deploy.util.ArrayUtil;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

import static java.util.Comparator.naturalOrder;


public class Main {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        LinkedBlockingQueue<Integer> primes = ForkJoinPool.commonPool().invoke(new PrimeCalc(1, 10000000));
        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println("Calculation time: "+estimatedTime+"ms");
        System.out.println("Liczb pierwszych w przedziale: " + primes.size());
        System.out.println("5 największych par liczb bliźniaczych:");

        List<Integer> primes2 = new ArrayList<Integer>(primes);
        primes2.sort((left, right) -> left.compareTo(right)*(-1));
        int lastPrime = primes2.get(0);
        int ileBlizniaczych = 0;
        for (Integer p: primes2)
        {
            if(lastPrime - p == 2)
            {
                System.out.println(p + " " + lastPrime);
                if(ileBlizniaczych++ == 5)
                    break;
            }
            lastPrime = p;
        }
    }

    static class PrimeCalc extends RecursiveTask<LinkedBlockingQueue<Integer>> {
        static final int SEQUENTIAL_THRESHOLD = 5000;
        int low;
        int high;

        PrimeCalc(int begin, int end)
        {
            this.low = begin;
            this.high = end;
        }

        @Override
        protected LinkedBlockingQueue<Integer> compute()
        {
            if(high - low <= SEQUENTIAL_THRESHOLD)
            {
                return getPrimes(low, high);
            }
            else
            {
                int mid = low + (high - low) / 2;
                PrimeCalc left = new PrimeCalc(low, mid);
                PrimeCalc right = new PrimeCalc(mid+1, high);
                left.fork();
                LinkedBlockingQueue<Integer> rightAns = right.compute();
                LinkedBlockingQueue<Integer> leftAns = left.join();
                leftAns.addAll(rightAns);
                return leftAns;
            }
        }

        public LinkedBlockingQueue<Integer> getPrimes(int start, int end)
        {
            LinkedBlockingQueue<Integer> primes = new LinkedBlockingQueue<Integer>();
            for(int i=start; i <= end; ++i)
            {
                if(isPrime(i))
                {
                    primes.add(i);
                }
            }
            return primes;
        }

        private boolean isPrime(int m)
        {
            if(m == 1)
                return false;

            if(m == 2 || m == 3)
                return true;

            if(m > 3)
            {
                if(m%2 == 0)
                    return false;

                for(int i = 3; i<=Math.sqrt(m); ++i)
                {
                    if(m%i == 0)
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
