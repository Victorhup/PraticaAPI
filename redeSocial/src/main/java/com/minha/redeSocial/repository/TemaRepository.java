package com.minha.redeSocial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minha.redeSocial.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	public List<Tema> findAllByDescricaoIgnoreCase (String descricao);

}
