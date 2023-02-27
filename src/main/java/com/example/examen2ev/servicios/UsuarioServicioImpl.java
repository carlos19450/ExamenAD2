package com.example.examen2ev.servicios;

import com.example.examen2ev.modelos.Usuario;
import com.example.examen2ev.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;


    @Override
    public List<Usuario> findAllUsuarios() {
        return usuarioRepositorio.findAll();
    }

    @Override
    public Usuario findUsuario(String nombre) {
        return usuarioRepositorio.findByNombre(nombre);
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    public void deleteUsuario(String nombre) {
        usuarioRepositorio.deleteByNombre(nombre);
    }
}
