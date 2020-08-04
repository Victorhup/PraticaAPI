package com.farmacia.minhaFarmacia.controller;

import java.util.List;

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

import com.farmacia.minhaFarmacia.model.ProdutosModel;
import com.farmacia.minhaFarmacia.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutoRepository repository; 
	
	@GetMapping
	public ResponseEntity<List<ProdutosModel>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<ProdutosModel> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<ProdutosModel> post (@RequestBody ProdutosModel nome) {
	   return ResponseEntity.status(HttpStatus.CREATED)
			   .body(repository.save(nome));
	   } 
	
	@PutMapping
	public ResponseEntity<ProdutosModel> put (@RequestBody ProdutosModel nome) {
	   return ResponseEntity.ok(repository.save(nome));
			   
	   }
      
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
}
