package TMP;

import java.util.*;
import java.util.stream.Collectors;

public class DeduplicateKeysInMap {
    public Map<String, List<Pair>> toMapTwoDuplicates(Collection<Pair> collection) {
        return collection.stream()
                .collect(Collectors.toMap(Pair::getKey, pair -> {
                    List<Pair> pl = new ArrayList<>();
                    pl.add(pair);
                    return pl;
                }, (prev, cur) -> {
                    prev.addAll(cur);
                    return prev;
                }));
    }
    public Map<String, List<Pair>> toMap(Collection<Pair> collection) {
        Map<String, List<Pair>> res = new HashMap<>();
        for (Pair p : collection) {
            List<Pair> pl = res.getOrDefault(p.getKey(), new ArrayList<>());
            pl.add(p);
            res.put(p.getKey(), pl);
        }
        return res;
    }

    public static class Pair {
        private String key;
        private int val;

        Pair(String key, int val) {
            this.key = key;
            this.val = val;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

    }
}
