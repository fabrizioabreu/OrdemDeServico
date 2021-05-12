package com.fabrizio.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrizio.os.domain.Cliente;
import com.fabrizio.os.domain.OS;
import com.fabrizio.os.domain.Tecnico;
import com.fabrizio.os.domain.enuns.Prioridade;
import com.fabrizio.os.domain.enuns.Status;
import com.fabrizio.os.dtos.OSDTO;
import com.fabrizio.os.repositories.OSRepository;
import com.fabrizio.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OSRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	// BUSCA POR ID
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + OS.class.getName()));
	}
	
	// BUSCAR TODOS
	public List<OS> findAll() {
		return repository.findAll();
	}
	
	// CRIAR OS
	public OS create(@Valid OSDTO obj) {
		return fromDTO(obj);
	}
	
	private OS fromDTO(OSDTO obj) {
		OS newObj = new OS();
		newObj.setId(obj.getId());
		newObj.setObservacoes(obj.getObservacoes());
		newObj.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		newObj.setStatus(Status.toEnum(obj.getStatus()));
		
		Tecnico tec = tecnicoService.findById(obj.getTecnico());
		Cliente cli = clienteService.findById(obj.getCliente());
		
		newObj.setTecnico(tec);
		newObj.setCliente(cli);
		
		return repository.save(newObj);
	}
}





