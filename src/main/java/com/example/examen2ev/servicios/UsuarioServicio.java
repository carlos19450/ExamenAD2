package com.example.examen2ev.servicios;

import com.example.examen2ev.modelos.Usuario;

import java.util.List;

public interface UsuarioServicio {
    List<Usuario> findAllUsuarios();
    Usuario findUsuario(String nombre);
    Usuario createUsuario(Usuario piloto);
    Usuario updateUsuario(Usuario piloto);
    void deleteUsuario(String nombre);
}
