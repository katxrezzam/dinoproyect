package com.kat.dinocenter.models.repository;

import com.kat.dinocenter.models.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
}
