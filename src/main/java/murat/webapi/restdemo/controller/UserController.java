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

import murat.webapi.restdemo.service.UserService;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/users")
@NoArgsConstructor
@AllArgsConstructor
public class UserController {

    @Autowired
    public UserService userDaoService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userDaoService.getAll();

        return new ResponseEntity<>(users, OK);
    }

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userDaoService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        UserDto createdUser = userDaoService.setUser(userDto);
        return new ResponseEntity<>(createdUser, CREATED);

    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDaoService.deleteUser(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer id,@RequestBody  UserDto updatedUserDto) {
        return new ResponseEntity<>(userDaoService.updateUser(id, updatedUserDto), OK);
    }
}
