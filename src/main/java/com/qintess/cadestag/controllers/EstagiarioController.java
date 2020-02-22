package com.qintess.cadestag.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.cadestag.dtos.EstagiarioDTO;
import com.qintess.cadestag.models.Estagiario;
import com.qintess.cadestag.repositories.EstagRepository;

@RestController
@RequestMapping("/estagiarios")
public class EstagiarioController {
	
	@Autowired
	private EstagRepository estagRepo;

	@GetMapping
	public List<Estagiario> findEstagiarios() {
		System.out.println("findEstagiarios invocado");
		return (List<Estagiario>) estagRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Estagiario findEstagiario(@PathVariable int id) {
		System.out.println("findEstagiario invocado");
		
		Optional<Estagiario> op = estagRepo.findById(id);
		
		if(op.isPresent())
			return op.get();
		else
			return null;
	}
	
	@PutMapping
	@Transactional
	public void editEstagiario(@RequestBody EstagiarioDTO estagiario) {
		System.out.println("editEstagiario invocado");
		estagRepo.save(estagiario.transformModel());
	}
	
	@PostMapping
	@Transactional
	public void addEstagiario(@RequestBody EstagiarioDTO estagiario) {
		System.out.println("addEstagiario invocado");
		estagRepo.save(estagiario.transformModel());
	}
}
