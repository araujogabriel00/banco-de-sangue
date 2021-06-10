package com.bancosangue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancosangue.dto.PessoaDTO;
import com.bancosangue.entities.Pessoa;
import com.bancosangue.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa pessoa = new Pessoa(dto.getId(), dto.getNome(), dto.getCpf(), dto.getRg(), dto.getEmail(), dto.getPeso(),
				dto.getAltura(), dto.getPai(), dto.getMae(), dto.getNascimento(), dto.getTelefone());
		pessoa = pessoaRepository.save(pessoa);
		return new PessoaDTO(pessoa);

	}

	@Transactional(readOnly = true)
	public List<PessoaDTO> findAll() {
		List<Pessoa> list = pessoaRepository.findAll();
		return list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());

	};

}
