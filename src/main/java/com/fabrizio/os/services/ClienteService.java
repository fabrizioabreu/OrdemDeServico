package com.fabrizio.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrizio.os.domain.Cliente;
import com.fabrizio.os.domain.Pessoa;
import com.fabrizio.os.dtos.ClienteDTO;
import com.fabrizio.os.repositories.ClienteRepository;
import com.fabrizio.os.repositories.PessoaRepository;
import com.fabrizio.os.services.exceptions.DataIntegratyViolationException;
import com.fabrizio.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	// BUSCA POR ID
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não entcontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	// BUSCAR TODOS
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	// CRIANDO CLIENTE
	public Cliente create(ClienteDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	// ATUALIZANDO CLIENTE
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		
		return repository.save(oldObj);
	}
	
	// VALIDANDO SE EXISTE CPF CADASTRADO
	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}
}
