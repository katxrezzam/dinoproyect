package com.kat.dinocenter.models.servicesImplement;

import com.kat.dinocenter.models.entity.Categoria;
import com.kat.dinocenter.models.repository.CategoriaRepository;
import com.kat.dinocenter.models.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listar() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    public Categoria buscar(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}