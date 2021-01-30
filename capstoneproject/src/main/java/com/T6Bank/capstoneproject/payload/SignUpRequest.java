package com.T6Bank.capstoneproject.payload;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {
    
	@NotBlank
    @Size(min = 3, max = 15)
    private String username;

    @NotBlank
    @Size(min = 2, max = 20)
    private String password;
    
    
    private boolean active;
    
   
    private String role;
   
    public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

  
}
