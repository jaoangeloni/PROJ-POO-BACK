package com.jaoangeloni.newspaper.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	private String senha;

	@DBRef(lazy = true)
	private List<News> news = new ArrayList<>();
	
	public User() {}

	public User(String id, String name, String email, String senha) {
		super();
		this.id = id;
		this.name = name;
		this.senha = senha;
		this.email = email;
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public List<News> getPosts() {
		return news;
	}

	public void setPosts(List<News> news) {
		this.news = news;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
