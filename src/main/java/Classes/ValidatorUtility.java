package Classes;

import java.util.regex.Pattern;

public final class ValidatorUtility {
    private static final Pattern LINK_PATTERN =
            Pattern.compile("^(https?://)([\\w-]+\\.)+[\\w-]{2,}(:\\d{1,5})?(/[\\w\\-./?%&=+#~]*)?$");

    private ValidatorUtility() {
    }

    public static int validate(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " must be >= 0");
        }
        return value;
    }

    public static String validate(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
        return value;
    }

    public static Integer validateOptional(Integer value, String fieldName) {
        if (value != null && value < 0) {
            throw new IllegalArgumentException(fieldName + " must be >= 0 when provided");
        }
        return value;
    }

    public static <E extends Enum<E>> E validate(E value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
        return value;
    }

    public static String validateLink(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            return value;
        }
        if (!LINK_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(fieldName + " must be a valid http/https URL");
        }
        return value;
    }
}
