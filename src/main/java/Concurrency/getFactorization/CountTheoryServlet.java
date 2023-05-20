package Concurrency.getFactorization;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountTheoryServlet {
    private int counter = 0;
    private final Map<Integer, Integer[]> factorizeLocalCache = new HashMap<>();

    private FactorizeCache factorizeCache = null;

    public Integer[] doGetFactorize(int n) {
        Integer[] currentFactorize = null;
        synchronized (this) {
            counter += 1;
            if (factorizeLocalCache.get(n) != null) {
                currentFactorize = factorizeLocalCache.get(n).clone();
            }
        }
        if (currentFactorize == null) {
            currentFactorize = Factorize.proceed(n);
            synchronized (this) {
                factorizeLocalCache.putIfAbsent(n, currentFactorize.clone());
            }
        }
        return currentFactorize;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized Set<Integer> getCacheNumbers() {
        return Collections.unmodifiableSet(factorizeLocalCache.keySet());
    }


    public Integer[] doGetFactorize2(int n) {
        if (factorizeCache == null) {
            factorizeCache = new FactorizeCache(n, Factorize.proceed(n));
        }
        return factorizeCache.getFact();
    }

    private static class FactorizeCache {
        private int n;
        private Integer[] fact;

        FactorizeCache(Integer[] fact) {
            this.fact = fact;
        }

        FactorizeCache(int n, Integer[] fact) {
            this.n = n;
            this.fact = fact;
        }

        Integer[] getFact() {
            return fact;
        }
    }
}
