package com.kat.dinocenter.controllers;

import com.kat.dinocenter.models.entity.Distribuidor;
import com.kat.dinocenter.models.services.DistribuidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/distribuidor")
public class DistribuidorController {

    @Autowired
    private DistribuidorService distribuidorService;

    @RequestMapping("/index")
    public String index(Model model){

        List<Distribuidor> distribuidores = distribuidorService.listar();
        model.addAttribute("distribuidores", distribuidores);
        return "distribuidor/index";
    }
    @RequestMapping("/form")
    public String form(Model model){

        Distribuidor distribuidor = new Distribuidor();
        model.addAttribute("distribuidor", distribuidor);
        model.addAttribute("titulo","Nuevo distribuidor");
        return "distribuidor/form";
    }
    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String save(Distribuidor distribuidor){

        distribuidorService.guardar(distribuidor);
        return "redirect:/distribuidor/index";
    }
    @RequestMapping("/form/{id}")
    public String modifiy(@PathVariable(value = "id")Long id, Model model){

        Distribuidor distribuidor = distribuidorService.buscar(id);
        model.addAttribute("distributor", distribuidor);
        model.addAttribute("titulo","Modificar distribuidor");
        return "distribuidor/form";
    }
    @RequestMapping("/eliminar/{id}")
    public String delete(@PathVariable(value = "id")Long id){
        distribuidorService.eliminar(id);
        return "redirect:/distribuidor/index";
    }
}

