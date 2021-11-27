package com.usa.reto4a.reto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 *
 */
@Data
@NoArgsConstructor //constructor sin argumentos
@AllArgsConstructor // constructor con todos los argumentos
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String name;
}
