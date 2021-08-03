package com.generationgreenremap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationgreenremap.model.Categoria;
import com.generationgreenremap.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		
		return ResponseEntity.ok(categoriaRepository.findAll());
		
	}
  
	@GetMapping("/{Id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id){
		
		return categoriaRepository.findById(id)
				.map(resp->ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
				
		
	}
	
}
