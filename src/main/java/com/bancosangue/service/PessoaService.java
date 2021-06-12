package com.bancosangue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancosangue.entities.Endereco;
import com.bancosangue.entities.Pessoa;
import com.bancosangue.repositories.EnderecoRepository;
import com.bancosangue.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public Pessoa insert(Pessoa dto) {
		dto = pessoaRepository.save(dto);
		Endereco endereco = new Endereco(null, dto.getNumero(), dto.getCep(), dto.getBairro(), dto.getEndereco(), dto);
		enderecoRepository.save(endereco);
		return dto;

	}

	@Transactional(readOnly = true)
	public List<Pessoa> findAll() {

		return pessoaRepository.findAll();

	}

}
