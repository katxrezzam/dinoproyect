package com.kat.dinocenter.models.services;

import com.kat.dinocenter.models.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> listar();
    public void guardar(Producto producto);
    public Producto buscar(Long id);
    public void eliminar(Long id);
}
