package com.bancosangue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bancosangue.entities.Cidade;
import com.bancosangue.entities.Endereco;
import com.bancosangue.entities.Estado;
import com.bancosangue.entities.Pessoa;
import com.bancosangue.repositories.CidadeRepository;
import com.bancosangue.repositories.EnderecoRepository;
import com.bancosangue.repositories.EstadoRepository;
import com.bancosangue.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Transactional
	public List<Pessoa> insert(List<Pessoa> dto) {
		dto = pessoaRepository.saveAll(dto);
		for (Pessoa pessoa : dto) {
			

			Cidade cidade = new Cidade(null, pessoa.getCidade(), null);
			
			cidade = cidadeRepository.save(cidade);
			
			Estado estado = new Estado(null, pessoa.getEstado(), null);
			estado = estadoRepository.save(estado);
			
			
			Endereco endereco = new Endereco(null, pessoa.getNumero(), pessoa.getCep(), pessoa.getBairro(), pessoa.getEndereco(), pessoa,cidade);
			endereco = enderecoRepository.save(endereco);
			
			
		}
		return dto;

	}

//	public Pessoa fromDTO(PessoaNewDTO dto) {
//		Endereco endereco = new Endereco(null, dto.getNumero(), dto.getCep(), dto.getBairro(), dto.getEndereco(), null, dto.getCidade());
//		Pessoa pessoa = new Pessoa(null, dto.getNome(), dto.getCpf(), dto.getRg(), dto.getEmail(), dto.getPeso(), dto.getAltura(), dto.getPai(), dto.getMae(), dto.getData_nasc(), dto.getNumero(), dto.getCep(), dto.getBairro(), dto.getEndereco(), dto.getTelefone(), dto.getEndereco());
//		return pessoa;
//	
//		
//	}
//	

	@Transactional(readOnly = true)
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();

	}

}
