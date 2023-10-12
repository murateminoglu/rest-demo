package murat.webapi.restdemo.service;

import java.util.List;


import murat.webapi.restdemo.dto.UserDto;
import murat.webapi.restdemo.entity.User;




public interface UserDaoService {
	UserDto convertToUserDto(User user);
	List<UserDto> getAll();
	UserDto setUser(UserDto userDto);
	UserDto getUser(Integer id);
	void deleteUser(Integer id);
	UserDto updateUser(Integer id,UserDto updatedUserDto);


}
