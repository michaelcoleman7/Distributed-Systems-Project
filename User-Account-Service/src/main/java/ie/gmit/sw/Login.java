package ie.gmit.sw;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
	@NotNull
	private int userId;
	@NotBlank
	private String password;
	
	//login contructor
	public Login() {
	}
	
	//login constructor with params
	public Login(int userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	//setters using json properties for Jackson serialization/deserialization
	@JsonProperty
	public int getUserId() {
		return userId;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	

	
	
}
