package com.jaoangeloni.newspaper.dto;

import com.jaoangeloni.newspaper.domain.User;

public class LoginDTO {
	private String email;
	private String senha;
	
	public LoginDTO() {}
	
	public LoginDTO(User obj) {
		email = obj.getEmail();
		senha = obj.getSenha();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
