package subway.utils;

public class ValidationUtil {
    public static boolean isNotNullOrBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
