package com.usa.reto4a.reto.controller;

import com.usa.reto4a.reto.model.User;
import com.usa.reto4a.reto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired //Injecta dependencias, levanta las instancias de un objeto
    private UserService userService;

    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("/{email}")
    public boolean emailExists(@PathVariable("email") String email){
        return userService.emailExists(email);
    }

    @GetMapping("/{email}/{password}")
    public Optional<User> userExists(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.userExists(email,password);
    }

}
