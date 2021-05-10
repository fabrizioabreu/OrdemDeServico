package com.fabrizio.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.os.dtos.TecnicoDTO;
import com.fabrizio.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")		// localhost:8080/tecnicos
public class TecnicoController {
	
	@Autowired
	private TecnicoService service;
	
	@GetMapping(value = "/{id}")		// localhost:8080/tecnicos/id
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		TecnicoDTO objDTO = new TecnicoDTO(service.findById(id));
		return ResponseEntity.ok().body(objDTO);
	}
	
}
