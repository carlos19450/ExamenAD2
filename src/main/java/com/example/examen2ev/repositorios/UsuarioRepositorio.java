package com.example.examen2ev.repositorios;

import com.example.examen2ev.modelos.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UsuarioRepositorio extends MongoRepository<Usuario, Integer> {
    Usuario findByNombre(String nombre);
    List<Usuario> findByNombreContaining(String nombre);
    void deleteByNombre(String nombre);
}
