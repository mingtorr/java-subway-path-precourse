package subway.utils;

public class ValidationUtil {
    public static boolean isNotNullOrBlank(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isNotPositive(int number) {
        return number <= 0;
    }
}
