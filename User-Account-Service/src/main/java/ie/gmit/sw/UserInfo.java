package ie.gmit.sw;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {
    private int userId;
    private String username;
    private String email;
    private String hashedPassword;
    private String salt;

    //constructor
    public UserInfo() {
    }
    
    //constructor with fields
    public UserInfo(int userId, String username, String email, String hashedPassword, String salt) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

  //setters using json properties for Jackson serialization/deserialization
    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUsername() {
        return username;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getHashedPassword() {
        return hashedPassword;
    }

    @JsonProperty
    public String getSalt() {
        return salt;
    }
}
