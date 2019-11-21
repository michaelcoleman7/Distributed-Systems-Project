package ie.gmit.sw;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@NotNull //ensure that int is not left empty
    private int userId;
	@NotBlank //ensure that strings is not left empty
    private String username;
	@NotBlank
    private String email;
	@NotBlank
    private String password;

    //constructor
    public User() {
    }

    //constructor with fields
    public User(int userId, String username, String email, String password) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
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
    public String getPassword() {
        return password;
    }
}
