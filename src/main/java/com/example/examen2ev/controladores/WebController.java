package com.example.examen2ev.controladores;

import com.example.examen2ev.modelos.Usuario;
import com.example.examen2ev.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class WebController {
    @Autowired
    private UsuarioServicio usuarioServicio;
    @RequestMapping(value = {"/", "/usuarios"})
    public String index(Model model) {
        model.addAttribute("usuarios", usuarioServicio.findAllUsuarios());
        return "index";
    }

    @RequestMapping(value = "/usuarios")
    public String indexUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.findAllUsuarios());
        return "indexUsuario";
    }

    @GetMapping(value = "/usuarios/nuevo")
    public String nuevoUsuario(Model model) {
        Usuario usuario= new Usuario();
        model.addAttribute("usuario", usuario);
        return "createUsuario";
    }

    @GetMapping(value = "/usuarios/{nombre}")
    public String editarUsuario(@PathVariable String nombre, Model model) {
        Usuario usuario = usuarioServicio.findUsuario(nombre);
        model.addAttribute("usuario", usuario);
        return "updateUsuario";
    }

    @PostMapping(value = "/usuarios/{nombre}")
    public String actualizarUsuario(@PathVariable String nombre, @ModelAttribute("usuario") Usuario usuario) {
        Usuario usuarioExistente = usuarioServicio.findUsuario(nombre);

        usuarioExistente.setUsername(nombre + "123");

        usuarioServicio.updateUsuario(usuarioExistente);
        return "redirect:/usuarios";
    }

    @RequestMapping(value = "/usuarios/delete/{nombre}")
    public String eliminarUsuario(@PathVariable String nombre, Model model) {
        usuarioServicio.deleteUsuario(nombre);
        return "redirect:/usuarios";
    }
}
