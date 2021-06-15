package com.bancosangue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancosangue.entities.Pessoa;
import com.bancosangue.service.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaControler {
	
	@Autowired
	private PessoaService pessoaService;
	

	
	@PostMapping
	public ResponseEntity<List<Pessoa>> insert(@RequestBody List<Pessoa> dto) {
		dto = pessoaService.insert(dto);
		return ResponseEntity.ok(dto);
	}
	
	
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll(){
		List<Pessoa> list = pessoaService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
