package com.kat.dinocenter.models.services;

import com.kat.dinocenter.models.entity.Distribuidor;

import java.util.List;

public interface DistribuidorService {

    public List<Distribuidor> listar();
    public void guardar(Distribuidor distribuidor);
    public Distribuidor buscar(Long id);
    public void eliminar(Long id);
}
