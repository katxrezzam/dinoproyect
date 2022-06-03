package com.kat.dinocenter.models.repository;

import com.kat.dinocenter.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
