package io.novelis.demo.controller;

import io.novelis.demo.domain.User;
import io.novelis.demo.service.DTO.UserDTO;
import io.novelis.demo.service.UserService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api")
public class UserController {




    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id) {
        Optional<UserDTO> result = userService.findOneById(id);
        return ResponseEntity.ok(result.get());
    }

    @PostMapping("/user")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO result = userService.saveUser(userDTO);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser (@RequestBody UserDTO userDTO){
        UserDTO result = userService.updateUser(userDTO);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser (@PathVariable long id){
        userService.deleteUser(id);
    }
}


