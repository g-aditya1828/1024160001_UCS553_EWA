package library.util;

public class InputValidator {

    // Validate Resource ID
    public static boolean isValidResourceId(int resourceId) {
        return resourceId > 0;
    }

    // Validate Fine Days
    public static boolean isValidFineDays(int fineDays) {
        return fineDays >= 0;
    }
}