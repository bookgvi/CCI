package graph.state;

import java.util.Objects;

public class ConvertUtils {


    public static Boolean toBooleanSafely(String value, boolean defaultValue) {
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        return Objects.equals("true", value) || Objects.equals("1", value);
    }

    public static Integer toIntegerSafely(Boolean param, Integer defaultValue) {
        if (!Objects.nonNull(param)) {
            return defaultValue;
        }
        return Objects.equals(true, param) ? 1 : 0;
    }

}
