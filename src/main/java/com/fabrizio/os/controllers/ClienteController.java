package com.fabrizio.os.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fabrizio.os.domain.Cliente;
import com.fabrizio.os.dtos.ClienteDTO;
import com.fabrizio.os.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	// BUSCA POR ID
	@GetMapping(value = "/{id}")	// GET localhost:8080/clientes/id
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id) {
		ClienteDTO objDTO = new ClienteDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
	// BUSCAR TODOS
	@GetMapping 	// GET localhost:8080/clientes
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> listDTO = service.findAll().stream().map(obj -> new ClienteDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	// CRIANDO CLIENTE
	@PostMapping	// POST localhost:8080/clientes
	public ResponseEntity<ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO) {
		Cliente newObj = service.create(objDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// ATUALIZANDO CLIENTE
	@PutMapping(value = "/{id}")		// PUT localhost:8080/clientes/id
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO) {
		ClienteDTO newObj = new ClienteDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	// DELETAR CLIENTE
	@DeleteMapping(value = "/{id}") 	// DELETE localhost:8080/clientes/id
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}







