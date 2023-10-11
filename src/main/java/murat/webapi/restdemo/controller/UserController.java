package murat.webapi.restdemo.controller;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import murat.webapi.restdemo.dto.UserDto;
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

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

	@Autowired
	public UserDaoService userDaoService;
	// method
	// url/...

	@GetMapping
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userDaoService.getAll();

		return new ResponseEntity<>(users,OK);
	}

	@GetMapping("{id}")
	public UserDto getUser(@PathVariable int id) {
		return userDaoService.getUser(id);
	}

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		try {
			UserDto createdUser = userDaoService.setUser(userDto);
			return new ResponseEntity<>(createdUser, CREATED);
		} catch (Exception e) {

			return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable int id) {
		userDaoService.deleteUser(id);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto updatedUserDto) {
		return new ResponseEntity<>(userDaoService.setUser(updatedUserDto),OK);
	}
}
