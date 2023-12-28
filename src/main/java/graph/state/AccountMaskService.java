package graph.state;

import java.util.Map;
import java.util.HashMap;
public class AccountMaskService {

    private final Map<String, String> accMap = new HashMap<>();
    {
        accMap.put("123", "true");
        accMap.put("321", "true");
        accMap.put("3216", "true");
    }

    private AccountMaskService() {
    }

    public static AccountMaskService getInstance() {
        return new AccountMaskService();
    }

    public boolean match(String acc) {
        if (acc == null || acc.isEmpty()) {
            return false;
        }
        return ConvertUtils.toBooleanSafely(accMap.get(acc), false);
    }

}
