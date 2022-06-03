package com.kat.dinocenter.models.services;

import com.kat.dinocenter.models.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> listar();
    public void guardar(Categoria categoria);
    public Categoria buscar(Long id);
    public void eliminar(Long id);


}
