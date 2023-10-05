package murat.webapi.restdemo.entity;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class User {
	private Integer id;
	private String name;
	private Date birthDay;

	private static User instance;

	public static User getInstance() {
		if (instance == null) {
			instance = new User();
		}
		return instance;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public User(Integer id, String name, Date birthDay) {
		super();
		this.id = id;
		this.name = name;
		this.birthDay = birthDay;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDay=" + birthDay + "]";
	}

}
