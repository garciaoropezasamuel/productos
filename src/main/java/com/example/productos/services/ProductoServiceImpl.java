package com.example.productos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.productos.entities.Producto;
import com.example.productos.repositories.ProductoRepository;
// Service que implementa los metodos de la interface IService
@Service
public class ProductoServiceImpl implements IService<Producto> {
	
	// Inyeccion de dependencias, en este caso del repositorio JPA
	@Autowired
	private ProductoRepository productoRepositorio ;

	// Metodo que retorna la lista de todos los productos existentes
	@Transactional(readOnly = true)
	@Override
	public List<Producto> getAll() {
		return (List<Producto>) productoRepositorio.findAll();
	}

	// metodo que retorna un opcional Producto de acuerdo al ID
	@Transactional(readOnly = true)
	@Override
	public Optional<Producto> getById(Long id) {
		return productoRepositorio.findById(id);
	}

	// metodo para guardar en la base de datos un Producto, si trae un ID 
	// actualiza, en caso contrario realiza la insersion de nuevo registro
	@Transactional
	@Override
	public Producto save(Producto item) {
		return productoRepositorio.save(item);
	}

	// metodo para realizar la eliminacion de un registro
	@Transactional
	@Override
	public Optional<Producto> deleteById(Long id) {
		Optional<Producto> producOpt = productoRepositorio.findById(id);
		
		if (producOpt.isPresent()) {
			productoRepositorio.deleteById(id);
			return producOpt ;
		}
		return null;
	}

}
