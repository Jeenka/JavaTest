package Classes;

import java.util.Optional;
import java.util.regex.Pattern;

public final class ValidatorUtility {
    private static final Pattern LINK_PATTERN =
            Pattern.compile("^(https?://)([\\w-]+\\.)+[\\w-]{2,}(:\\d{1,5})?(/[\\w\\-./?%&=+#~]*)?$");

    private ValidatorUtility() {
    }

    public static void validate(int value, String fieldName) {
        if (value < 0) {
            throw new IllegalArgumentException(fieldName + " must be >= 0");
        }
    }

    public static void validate(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be blank");
        }
    }

    public static void validateOptional(Integer value, String fieldName) {
        if (value != null && value < 0) {
            throw new IllegalArgumentException(fieldName + " must be >= 0 when provided");
        }
    }

    public static void validate(Object value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " must not be null");
        }
    }

    public static void validateLink(String value, String fieldName) {
        if (value.isBlank() || value == null) {
            return;
        }
        if (!LINK_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(fieldName + " must be a valid http/https URL");
        }
    }
}
