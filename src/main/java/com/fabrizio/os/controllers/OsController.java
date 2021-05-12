package com.fabrizio.os.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrizio.os.dtos.OSDTO;
import com.fabrizio.os.services.OsService;

@RestController
@RequestMapping(value = "/os")
public class OsController {

	@Autowired
	private OsService service;
	
	// BUSCA POR ID
	@GetMapping(value = "/{id}")	// GET localhost:8080/os/id
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id) {
		OSDTO obj = new OSDTO(service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
}
