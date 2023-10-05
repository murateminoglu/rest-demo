package murat.webapi.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import murat.webapi.restdemo.entity.User;
import murat.webapi.restdemo.service.UserDaoService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	public UserDaoService userDaoService;
	// method
	// url/...

	@GetMapping
	public List<User> getUsers() {
		return userDaoService.getAll();
	}

	@GetMapping("{id}")
	public User getUser(@PathVariable int id) {
		return userDaoService.getUser(id);
	}

	@PostMapping
	public void createUser(@RequestBody User user) {
		userDaoService.setUser(null,user);
	}
	
	@DeleteMapping("{id}")
	public void deleteeUser(@PathVariable int id) {
		userDaoService.deleteUser(id);
	}
	

	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
	    User updated = userDaoService.setUser(id,updatedUser);
	    return ResponseEntity.ok(updated);
	}
}
