package murat.webapi.restdemo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;


@Entity
@Table(name = "user_s")
@Getter
@Service
@Data
public class User {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") private Integer id;
	@Column (name = "name") private String name;
	@Column (name = "birthDay") private Date birthDay;


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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

}
