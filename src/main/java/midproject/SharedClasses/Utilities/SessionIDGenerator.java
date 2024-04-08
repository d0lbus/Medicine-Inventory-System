package midproject.SharedClasses.Utilities;

import java.util.UUID;

public class SessionIDGenerator {
    /**
     * Generates a unique session ID using UUID.
     * @return A unique session ID string.
     */
    public static String generateUniqueSessionId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
