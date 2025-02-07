package com.example.productos.services;

import java.util.List;
import java.util.Optional;
//  Interface genérica para los metodos del CRUD	
public interface IService<T> {
	List<T> getAll();
	Optional<T> getById(Long id);
	T save(T item);
	Optional<T> deleteById(Long id);
}
