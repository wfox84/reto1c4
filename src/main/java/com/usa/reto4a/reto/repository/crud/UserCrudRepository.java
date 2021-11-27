package com.usa.reto4a.reto.repository.crud;

import com.usa.reto4a.reto.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
    public Optional<User> findByEmailAndPassword(String email, String password);
}
