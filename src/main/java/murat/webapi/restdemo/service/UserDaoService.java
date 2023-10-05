package murat.webapi.restdemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import murat.webapi.restdemo.dto.UserDto;
import murat.webapi.restdemo.entity.User;


@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();

	private static int usersCount = 3;
	@Autowired
	public UserDaoService() {
		users.add(new User(1, "Murat Emin", new Date()));
		users.add(new User(2, "Martin Luther", new Date()));
		users.add(new User(3, "Max Jan", new Date()));
	}

	public List<User> getAll() {
		return users;
	}

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

	public void deleteeUser(Integer id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}
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
}
