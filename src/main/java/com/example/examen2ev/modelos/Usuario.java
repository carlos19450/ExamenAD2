package com.example.examen2ev.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", unique = true)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name", unique = true)
    private String nombre;
    @Column(name = "last_name")
    private String apellido;
    @Column(name = "email")
    private String email;
}
