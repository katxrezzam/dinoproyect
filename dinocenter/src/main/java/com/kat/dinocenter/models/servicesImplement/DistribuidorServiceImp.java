package com.kat.dinocenter.models.servicesImplement;

import com.kat.dinocenter.models.entity.Distribuidor;
import com.kat.dinocenter.models.repository.DistribuidorRepository;
import com.kat.dinocenter.models.services.DistribuidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorServiceImp implements DistribuidorService {

    @Autowired
    private DistribuidorRepository distribuidorRepository;
    @Override
    public List<Distribuidor> listar() {
        return (List<Distribuidor>) distribuidorRepository.findAll();
    }

    @Override
    public void guardar(Distribuidor distribuidor) {
        distribuidorRepository.save(distribuidor);
    }

    @Override
    public Distribuidor buscar(Long id) {
        return distribuidorRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        distribuidorRepository.deleteById(id);
    }
}