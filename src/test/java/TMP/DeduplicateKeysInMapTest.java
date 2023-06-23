package TMP;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DeduplicateKeysInMapTest {

    @Test
    public void toMap_test1() {
        DeduplicateKeysInMap.Pair p1 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p2 = new DeduplicateKeysInMap.Pair("2", 2);
        DeduplicateKeysInMap.Pair p3 = new DeduplicateKeysInMap.Pair("3", 2);

        List<DeduplicateKeysInMap.Pair> pl = new ArrayList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        DeduplicateKeysInMap d = new DeduplicateKeysInMap();
        Map<String, List<DeduplicateKeysInMap.Pair>> m = d.toMap(pl);

    }

    @Test
    public void toMap_test2() {
        DeduplicateKeysInMap.Pair p1 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p2 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p3 = new DeduplicateKeysInMap.Pair("3", 2);

        List<DeduplicateKeysInMap.Pair> pl = new ArrayList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        DeduplicateKeysInMap d = new DeduplicateKeysInMap();
        Map<String, List<DeduplicateKeysInMap.Pair>> m = d.toMap(pl);

    }

    @Test
    public void toMap_test3() {
        DeduplicateKeysInMap.Pair p1 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p2 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p3 = new DeduplicateKeysInMap.Pair("1", 2);
        DeduplicateKeysInMap.Pair p4 = new DeduplicateKeysInMap.Pair("3", 2);

        List<DeduplicateKeysInMap.Pair> pl = new ArrayList<>();
        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        pl.add(p4);
        DeduplicateKeysInMap d = new DeduplicateKeysInMap();
        Map<String, List<DeduplicateKeysInMap.Pair>> m = d.toMap(pl);

    }
}