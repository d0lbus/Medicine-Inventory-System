package midproject.SharedClasses.ReferenceClasses;

public class UserCallBackInfo {
    private String username;
    private String userType;

    public UserCallBackInfo(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
