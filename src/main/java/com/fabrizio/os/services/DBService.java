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
		Tecnico t2 = new Tecnico(null, "Antonio Carlos", "715.923.770-68", "(13) 96645-8440");
		Tecnico t3 = new Tecnico(null, "Roberto Marinho", "733.008.930-38", "(13) 96311-7869");
		Tecnico t4 = new Tecnico(null, "Marilda Mendonça", "798.322.190-86", "(13) 96656-0135");
		Tecnico t5 = new Tecnico(null, "Nando Reis", "782.186.530-31", "(13) 99147-0435");
		Tecnico t6 = new Tecnico(null, "Benedita Pinheiro", "476.033.680-06", "(13) 99946-9698");
		Tecnico t7 = new Tecnico(null, "Bruno Covas", "384.371.770-22", "(13) 99382-4165");
		Tecnico t8 = new Tecnico(null, "Maria Antonieta", "819.502.960-40", "(13) 99697-0629");
		Tecnico t9 = new Tecnico(null, "Dom Pedro", "630.084.530-31", "(13) 99876-4966");
		Tecnico t10 = new Tecnico(null, "Carlota Joaquina", "833.803.210-79", "(13) 99790-8234");
		Tecnico t11 = new Tecnico(null, "Alberto de Nobrega", "372.338.930-98", "(13) 99163-1563");
		
		Cliente c1 = new Cliente(null, "Betina Campos", "019.065.820-76", "(13) 99999-7777");
		Cliente c2 = new Cliente(null, "João Batista", "019.065.820-76", "(13) 99999-7237");
		Cliente c3 = new Cliente(null, "George Amado", "019.065.820-76", "(13) 99707-9087");
		Cliente c4 = new Cliente(null, "Candida Azevedo", "019.065.820-76", "(13) 92866-0287");
		Cliente c5 = new Cliente(null, "Luiz Carlos", "019.065.820-76", "(13) 96434-4932");
		Cliente c6 = new Cliente(null, "Paloma Cruz", "019.065.820-76", "(13) 99309-0099");
		Cliente c7 = new Cliente(null, "Priscila Meneguel", "019.065.820-76", "(13) 96153-8657");
		Cliente c8 = new Cliente(null, "Paulo Gustavo", "019.065.820-76", "(13) 90013-5539");
		Cliente c9 = new Cliente(null, "Poliana Almeida", "019.065.820-76", "(13) 92703-6145");
		Cliente c10 = new Cliente(null, "Bruno Amaral", "019.065.820-76", "(13) 93439-8541");
		Cliente c11 = new Cliente(null, "Nathália Guimarães", "019.065.820-76", "(13) 90832-6278");
		Cliente c12 = new Cliente(null, "Danilo Gentilli", "019.065.820-76", "(13) 94989-6984");
		Cliente c13 = new Cliente(null, "Thainá Silva", "019.065.820-76", "(13) 98372-9178");

		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS1", Status.ANDAMENTO, t1, c1);
		OS os2 = new OS(null, Prioridade.BAIXA, "Teste create OS2", Status.ANDAMENTO, t2, c3);
		OS os3 = new OS(null, Prioridade.ALTA, "Teste create OS3", Status.ANDAMENTO, t2, c3);
		OS os4 = new OS(null, Prioridade.MEDIA, "Teste create OS4", Status.ANDAMENTO, t1, c4);
		OS os5 = new OS(null, Prioridade.MEDIA, "Teste create OS5", Status.ANDAMENTO, t3, c2);
		OS os6 = new OS(null, Prioridade.ALTA, "Teste create OS6", Status.ANDAMENTO, t4, c4);
		OS os7 = new OS(null, Prioridade.ALTA, "Teste create OS7", Status.ANDAMENTO, t4, c1);
		

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13));
		oSRepository.saveAll(Arrays.asList(os1, os2, os3, os4, os5, os6, os7));
	}
}
