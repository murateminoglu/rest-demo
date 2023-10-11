package murat.webapi.restdemo.userserviceimpl;

import lombok.RequiredArgsConstructor;
import murat.webapi.restdemo.dto.UserDto;
import murat.webapi.restdemo.entity.User;
import murat.webapi.restdemo.repository.UserRepository;
import murat.webapi.restdemo.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserDaoServiceImpl implements UserDaoService {


    private final UserRepository userRepository;



    public UserDto convertToUserDto(User user){

        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setBirthDay(user.getBirthDay());
        return userDTO;
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto setUser(UserDto userDto) {
        User user= new User();
        user.setName(userDto.getName());
        user.setBirthDay(userDto.getBirthDay());

        User savedUser = userRepository.save(user);

        UserDto savedUserDto = new UserDto();
        savedUserDto.setId(savedUser.getId());
        savedUserDto.setName(savedUser.getName());
        savedUserDto.setBirthDay(savedUser.getBirthDay());

        return savedUserDto;
    }

    public UserDto getUser(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? convertToUserDto(user) : null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(@PathVariable Integer id,@RequestBody UserDto updatedUserDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();

            if (updatedUserDto.getId() != null) {
                existingUser.setId(updatedUserDto.getId());
            }

            if (updatedUserDto.getName() != null) {
                existingUser.setName(updatedUserDto.getName());
            }

            if (updatedUserDto.getBirthDay() != null) {
                existingUser.setBirthDay(updatedUserDto.getBirthDay());
            }


            User updatedUser = userRepository.save(existingUser);

            return convertToUserDto(updatedUser);
        }

        return null;
    }

}
