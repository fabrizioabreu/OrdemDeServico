package com.fabrizio.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabrizio.os.domain.Cliente;
import com.fabrizio.os.domain.OS;
import com.fabrizio.os.domain.Tecnico;
import com.fabrizio.os.domain.enuns.Prioridade;
import com.fabrizio.os.domain.enuns.Status;
import com.fabrizio.os.repositories.ClienteRepository;
import com.fabrizio.os.repositories.OSRepository;
import com.fabrizio.os.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository oSRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null, "Fabrizio Abreu", "623.813.710-01", "(13) 99999-8888");
		Cliente c1 = new Cliente(null, "Betina Campos", "019.065.820-76", "(13) 99999-7777");

		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		oSRepository.saveAll(Arrays.asList(os1));
	}
}
