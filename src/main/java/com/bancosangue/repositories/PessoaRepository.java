package com.bancosangue.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancosangue.entities.Pessoa;

///CONSULTA AO BANCO
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findAll();

	

}
