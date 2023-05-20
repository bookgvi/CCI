package Concurrency.getFactorization;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CountTheoryServlet {
    private int cacheUse = 0;
    private final Map<Integer, Integer[]> factorizeLocalCache = new HashMap<>();

    private LastFactorizeCache lastFactorizeCache = new LastFactorizeCache(null, null);
    private ImmutableFactorizeCache immutableFactorizeCache = new ImmutableFactorizeCache(null, null);

    public Integer[] doGetFactorize(int n) {
        Integer[] currentFactorize = null;
        synchronized (this) {
            if (factorizeLocalCache.get(n) != null) {
                cacheUse += 1;
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

    public synchronized int getCacheUse() {
        return cacheUse;
    }

    public synchronized Set<Integer> getCacheNumbers() {
        return Collections.unmodifiableSet(factorizeLocalCache.keySet());
    }


    public Integer[] doGetFactorize2(int n) {
        Integer[] fact = lastFactorizeCache.getFact(n);
        if (fact != null) {
            System.out.print("From cache: ");
        } else {
            fact = Factorize.proceed(n);
            lastFactorizeCache = new LastFactorizeCache(n, fact.clone());
        }
        return fact;
    }


    public Integer[] doGetFactorize3(int n) {
        Integer[] fact = immutableFactorizeCache.getFact(n);
        if (fact != null) {
            System.out.print("From cache: ");
        } else {
            fact = Factorize.proceed(n);
            immutableFactorizeCache = new ImmutableFactorizeCache(n, fact.clone());
        }
        return fact;
    }

    private static class LastFactorizeCache {
        private final Integer n;
        private final Integer[] fact;

        LastFactorizeCache(Integer n, Integer[] fact) {
            this.n = n;
            this.fact = fact;
        }

        Integer[] getFact(int n) {
            if (Objects.equals(this.n, n)) {
                return fact.clone();
            }
            return null;
        }
    }

    private static class ImmutableFactorizeCache {
        private final Map<Integer, Integer[]> cache = new ConcurrentHashMap<>();

        ImmutableFactorizeCache(Integer n, Integer[] fact) {
            if (n != null) {
                cache.putIfAbsent(n, fact);
            }
        }

        Integer[] getFact(int n) {
            return cache.computeIfPresent(n, (k, factArr) -> factArr.clone());
        }
    }
}
