package midproject.SharedClasses;

import java.util.UUID;

public class SessionIDGenerator {
    /**
     * Generates a unique session ID using UUID.
     *
     * @return A unique session ID string.
     */
    public static String generateUniqueSessionId() {
        // Generate a random UUID (Universally Unique Identifier)
        UUID uuid = UUID.randomUUID();
        // Convert UUID to string
        return uuid.toString();
    }
}
