package com.usa.reto4a.reto.repository;

import com.usa.reto4a.reto.model.User;
import com.usa.reto4a.reto.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    /**
     *
     * @return
     */
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    /**
     *
     * @param user
     * @return
     */

    public User save(User user){
        return userCrudRepository.save(user);
    }

    /**
     *
     * @param email
     * @return
     */
    public Optional<User> emailExists(String email){
        return userCrudRepository.findByEmail(email);
    }

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public Optional<User> userExists(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
