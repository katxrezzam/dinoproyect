package com.kat.dinocenter.models.services;

import com.kat.dinocenter.models.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public List<Usuario> listar();
    public void guardar(Usuario usuario);
    public Usuario buscar(Long id);
    public void eliminar(Long id);
}
