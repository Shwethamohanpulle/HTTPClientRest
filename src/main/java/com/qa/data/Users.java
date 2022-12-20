package com.qa.data;
//POJO (Plain old java object)
public class Users {
	String name;
	String job;
	String id;
	String createdAt;
	
	//Constructor1
	public Users() {
		
	}
	//Constructor2
public Users(String name, String job) {
		this.name=name;
		this.job=job;
	}

//Generate getters and setters
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
	

}
