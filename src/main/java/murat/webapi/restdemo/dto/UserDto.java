package murat.webapi.restdemo.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.intellij.lang.annotations.Pattern;

import java.util.Date;


public class UserDto {

	private Integer id;
	private String name;
	private Date birthDay;
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthDay() {
		return birthDay;
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
