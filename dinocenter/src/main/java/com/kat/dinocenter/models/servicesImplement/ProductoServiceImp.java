package com.kat.dinocenter.models.servicesImplement;

import com.kat.dinocenter.models.entity.Producto;
import com.kat.dinocenter.models.repository.ProductoRepository;
import com.kat.dinocenter.models.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> listar() {
        return (List<Producto>) productoRepository.findAll();
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public Producto buscar(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
