package com.bancosangue.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancosangue.entities.Pessoa;


public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	

}
