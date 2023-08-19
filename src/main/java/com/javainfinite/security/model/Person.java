package com.javainfinite.security.model;

import javax.persistence.*;

public class Person {

	@Id private Long id;
    @Column private String id_type;
    @Column private String id_number;
    @Column private String name;
    @Column private String lastname;
    @Column private String cellphone;
    @Column private String email;
    @Column private boolean active;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getId_type() {
		return id_type;
	}
	public void setId_type(String id_type) {
		this.id_type = id_type;
	}
	public String getId_number() {
		return id_number;
	}
	public void setId_number(String id_number) {
		this.id_number = id_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Person() {
	}
	public Person(Long id, String id_type, String id_number, String name, String lastname, String cellphone,
			String email, boolean active) {
		super();
		this.id = id;
		this.id_type = id_type;
		this.id_number = id_number;
		this.name = name;
		this.lastname = lastname;
		this.cellphone = cellphone;
		this.email = email;
		this.active = active;
	}
}