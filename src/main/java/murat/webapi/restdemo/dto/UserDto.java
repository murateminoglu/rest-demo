package murat.webapi.restdemo.dto;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.intellij.lang.annotations.Pattern;

import java.util.Date;

@Data
public class UserDto {
	//private Integer id;
	private String name;
	private Date birthDay;

}
