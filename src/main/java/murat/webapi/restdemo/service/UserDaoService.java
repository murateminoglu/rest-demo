package murat.webapi.restdemo.service;

import java.util.List;


import murat.webapi.restdemo.dto.UserDto;
import murat.webapi.restdemo.entity.User;



<<<<<<< HEAD
public interface UserDaoService {
	UserDto convertToUserDto(User user);
	List<UserDto> getAll();
	UserDto setUser(UserDto userDto);
	UserDto getUser(Integer id);
	void deleteUser(Integer id);
	UserDto updateUser(Integer id,UserDto updatedUserDto);
=======
	private static int usersCount = 3;

	public UserDaoService() {
		users.add(new User(1, "Murat Emin", new Date()));
		users.add(new User(2, "Martin Luther", new Date()));
		users.add(new User(3, "Max Jan", new Date()));
	}
>>>>>>> 662aea92835bc02211acb66607162dc7e52e7b7f


<<<<<<< HEAD
=======
	public User setUser(final Integer id,final User user) {
		// input validation
		User u = users.stream().filter(us ->us.getId().equals(id)).findAny().orElse(null);
		usersCount++;
		if (u == null) {
			u = new User();
			u.setId(usersCount);
			users.add(u);
		} 
		u.setName(user.getName());
	    u.setBirthDay(user.getBirthDay());
		return u;
	}

	public User getUser(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public void deleteUser(Integer id) {
		users.removeIf(user -> user.getId() == id);
	}


	public User updateUser(User updatedUser) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if (user.getId().equals(updatedUser.getId())) {
				
				user.setName(updatedUser.getName());
				user.setBirthDay(updatedUser.getBirthDay());
				return user;
			}
		}
		return null; 
	}
>>>>>>> 662aea92835bc02211acb66607162dc7e52e7b7f
}
