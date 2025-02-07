package com.example.productos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productos.entities.Producto;
import com.example.productos.services.ProductoServiceImpl;

@RestController
@RequestMapping("/products/*")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoController {
	
	@Autowired
	private ProductoServiceImpl service ;
	
	@GetMapping
	public ResponseEntity<List<Producto>> getAll(){
		return ResponseEntity.ok(service.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Producto> getById(@PathVariable Long id) {
		Optional<Producto> optionalProducto = service.getById(id);
		if(optionalProducto.isPresent()) return ResponseEntity.ok(optionalProducto.orElseThrow());
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Producto> create(@RequestBody Producto producto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto producto, @PathVariable Long id){
		Optional<Producto> op = service.getById(id);
		if(op.isPresent()) return ResponseEntity.status(HttpStatus.CREATED).body(service.save(producto));
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Producto> delete (@PathVariable Long id) {
		Optional<Producto> op = service.getById(id);
		if(op.isPresent()) {
			Producto productoDeleted = service.deleteById(id).orElseThrow();
			return ResponseEntity.status(HttpStatus.OK).body(productoDeleted);
		}
		return ResponseEntity.notFound().build();
	}

}
