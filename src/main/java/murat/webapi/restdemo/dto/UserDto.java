package murat.webapi.restdemo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
	private Integer id;
	private String name;
	private Date birthDay;
}
