package com.farmacia.minhaFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.minhaFarmacia.model.ProdutosModel;

public interface ProdutoRepository extends JpaRepository<ProdutosModel, Long> {
	public List<ProdutosModel> findAllByNomeContainingIgnoreCase(String nome);

    
}
