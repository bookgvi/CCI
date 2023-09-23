package TMP;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionTest {
    @Test
    public void test() {
        Pair[] arr = new Pair[]{
            new Pair("1", "4"), new Pair("1", "3"), new Pair("3", "!!"), new Pair("1", "4")
        };

        Map<String,String> pictureAccountMap = Arrays.stream(arr)
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (accountID1, accountID2) -> accountID1));

        Map<String, String> res = Arrays.stream(arr)
                .filter(dto -> dto.getValue() != null)
                .peek(dto -> dto.setValue(""))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        StringBuilder sb = new StringBuilder();
        String s = sb.toString();
    }

    @Test
    public void testRemoveFromMap() {
        Map<String, String> m = new HashMap<>();
//        m.put("1","1");
        m.put("2","1");
//        m.put("3","1");
        Optional.ofNullable(m.get("1")).ifPresent(m::remove);
    }

    private static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
