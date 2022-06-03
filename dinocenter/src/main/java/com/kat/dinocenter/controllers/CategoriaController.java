package com.kat.dinocenter.controllers;

import org.springframework.stereotype.Controller;

import com.kat.dinocenter.models.entity.Categoria;
import com.kat.dinocenter.models.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @RequestMapping("/index")
    public String index(Model model){

        List<Categoria> categorias = categoriaService.listar();
        model.addAttribute("categorias",categorias);

        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        return "categoria/index";
    }
    @RequestMapping(value = "/guardar",method = RequestMethod.POST)
    public  String save(Categoria categoria){
        categoriaService.guardar(categoria);
        return "redirect:/categoria/index";
    }
    @RequestMapping("/form")
    public String form(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("titulo","Nueva categoria");
        return "categoria/form";
    }
    @RequestMapping("/form/{id}")
    public String modify(@PathVariable(value = "id")Long id, Model model){
        Categoria categoria = categoriaService.buscar(id);
        model.addAttribute("categoria", categoria);
        return "categoria/form";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id")Long id){

        categoriaService.eliminar(id);
        return "redirect:/categoria/index";
    }
}

