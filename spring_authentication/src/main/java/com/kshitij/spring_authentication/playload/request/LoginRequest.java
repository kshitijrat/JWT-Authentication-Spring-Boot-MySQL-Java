package com.kshitij.spring_authentication.playload.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

	// getter & setter
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
}

