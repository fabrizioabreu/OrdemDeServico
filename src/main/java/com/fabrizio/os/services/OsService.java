package com.fabrizio.os.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrizio.os.domain.OS;
import com.fabrizio.os.repositories.OSRepository;
import com.fabrizio.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository repository;
	
	// BUSCA POR ID
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + OS.class.getName()));
	}
}
