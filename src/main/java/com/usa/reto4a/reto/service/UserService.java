package com.usa.reto4a.reto.service;

import com.usa.reto4a.reto.model.User;
import com.usa.reto4a.reto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
    return userRepository.getUser(id);
    }
    public void save(User user){
        if (user.getId() == null ){
            userRepository.save(user);
        }else if(userRepository.getUser(user.getId()).isEmpty()){
            userRepository.save(user);
        }
    }

    public boolean emailExists(String email){
        if(userRepository.emailExists(email).isEmpty()){
            return false;
        }
        return true;
    }

    public Optional<User> userExists(String email, String password){
        Optional<User> user = userRepository.userExists(email, password);//va a la bd y verifica que el usuario exista
        if (user.isEmpty()){
            return Optional.of(new User(null, email, password, "NO DEFINIDO"));
        }
        return user;
    }
}
