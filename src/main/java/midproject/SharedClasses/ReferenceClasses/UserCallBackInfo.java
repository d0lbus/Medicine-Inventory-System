package midproject.SharedClasses.ReferenceClasses;

import java.util.Objects;

public class UserCallBackInfo {
    private String username;
    private String userType;

    public UserCallBackInfo(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCallBackInfo that = (UserCallBackInfo) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(userType, that.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, userType);
    }
}
