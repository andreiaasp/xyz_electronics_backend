package com.example.xyzelectronic.xyz_electronicsbackend.controller;

import com.example.xyzelectronic.xyz_electronicsbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.xyzelectronic.xyz_electronicsbackend.entity.User;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.getReferenceById(id);
    }

    @PutMapping("/users/{id}")
    User updateUser(@PathVariable Long id, @RequestBody User updatedUser){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            return null;
        }

        // Get the existing user from the optional (we know it exists)
        User existingUser = optionalUser.get();

        // Apply the updates from the received user data to the existing user
        // You can also perform additional checks or validations here
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setName(updatedUser.getName());

        // Save the updated user to the database using the repository's save() method
        return userRepository.save(existingUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
