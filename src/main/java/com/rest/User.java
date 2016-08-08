package com.rest;

public class User {
	private String name;
	private String id;
	private String email;
	private int age;
	private String gender;
	public String getName() {
		return name;
	}
	public User(String name, String id, String email, int age, String gender) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.age = age;
		this.gender = gender;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
