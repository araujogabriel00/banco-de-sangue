package com.bancosangue.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bancosangue.entities.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	private Float peso;
	private Double altura;
	private String pai;
	private String mae;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date nascimento = new Date();
	private Set<String> telefone = new HashSet<>();

	public PessoaDTO() {

	}

	public PessoaDTO(Long id, String nome, String cpf, String rg, String email, Float peso, Double altura, String pai,
			String mae, Date nascimento, Set<String> telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.pai = pai;
		this.mae = mae;
		this.nascimento = nascimento;
		this.telefone = telefone;
	}

	public PessoaDTO(Pessoa pessoa) {
		id = pessoa.getId();
		nome = pessoa.getNome();
		cpf = pessoa.getCpf();
		rg = pessoa.getRg();
		email = pessoa.getEmail();
		peso = pessoa.getPeso();
		altura = pessoa.getAltura();
		pai = pessoa.getPai();
		mae = pessoa.getMae();
		nascimento = pessoa.getNascimento();
		telefone = pessoa.getTelefone();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Set<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Set<String> telefone) {
		this.telefone = telefone;
	}

}
