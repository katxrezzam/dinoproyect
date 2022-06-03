package com.kat.dinocenter.controllers;

import com.kat.dinocenter.models.entity.Usuario;
import com.kat.dinocenter.models.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/index")
    public String index(Model model){
        List<Usuario> usuarios = usuarioService.listar();
        model.addAttribute("usuarios",usuarios);

        //
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "usuario/index";
    }
    @RequestMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute(usuario);
        return "usuario/form";
    }
    @RequestMapping("/form/{id}")
    public String modifiy(@PathVariable(value = "id")Long id, Model model){
        Usuario usuario = usuarioService.buscar(id);
        model.addAttribute("usuario", usuario);
        return "usuario/form";
    }
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public String save(Usuario usuario){
        usuarioService.guardar(usuario);
        return "redirect:/usuario/index";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        usuarioService.eliminar(id);
        return "redirect:/usuario/index";
    }
}
