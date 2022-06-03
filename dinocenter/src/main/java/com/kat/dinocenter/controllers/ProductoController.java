package com.kat.dinocenter.controllers;

import com.kat.dinocenter.models.entity.Categoria;
import com.kat.dinocenter.models.entity.Distribuidor;
import com.kat.dinocenter.models.entity.Producto;
import com.kat.dinocenter.models.services.CategoriaService;
import com.kat.dinocenter.models.services.DistribuidorService;
import com.kat.dinocenter.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private DistribuidorService distribuidorService;
    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping("/index")
    public String index(Model model){

        List<Producto> productos = productoService.listar();
        model.addAttribute("productos", productos);
        //
        Producto producto = new Producto();
        model.addAttribute("producto", producto);

        return "producto/index";
    }
    @RequestMapping("/form")
    public String form(Model model){

        Producto producto = new Producto();
        List<Categoria> categorias = categoriaService.listar();
        List<Distribuidor> distribuidores = distribuidorService.listar();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        model.addAttribute("distribuidores", distribuidores);
        model.addAttribute("titulo", "Nuevo producto");

        return  "producto/form";
    }
    @RequestMapping( value = "/guardar", method = RequestMethod.POST)
    public String save(Producto producto){

        productoService.guardar(producto);

        return "redirect:/producto/index";
    }
    @RequestMapping("/form/{id}")
    public String modify(@PathVariable(value = "id")Long id, Model model){

        Producto producto = productoService.buscar(id);
        List<Categoria> categorias = categoriaService.listar();
        List<Distribuidor> distribuidores = distribuidorService.listar();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        model.addAttribute("distribuidores", distribuidores);
        model.addAttribute("titulo", "Modificar producto");

        return "producto/form";
    }
    @RequestMapping("/eliminar{id}")
    public String delete(@PathVariable(value = "id")Long id){

        productoService.eliminar(id);
        return "redirect:/producto/index";
    }
}
