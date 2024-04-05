package br.elielsonRodrigues.git.clientesapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.elielsonRodrigues.git.clientesapi.model.Cliente;
import br.elielsonRodrigues.git.clientesapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/* SALVANDO UM CLIENTE*/
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	/*ATUALIZANDO UM CLIENTE POR CODIGO*/
	public Cliente update(Long codigo, Cliente cliente) {
		return clienteRepository
			.findById(codigo)
			.map(clienteUpdate -> {
				BeanUtils.copyProperties(cliente,clienteUpdate, "codigo");
				return clienteRepository.save(clienteUpdate);
			})
			.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	/*DELETANDO UM CLIENTE PELO CODIGO*/
	public void deleById(Long codigo) {
		 clienteRepository
		 	.findById(codigo)
		 	.map(cliente -> {
		 		clienteRepository.deleteById(codigo);
		 		return Void.TYPE;
		 	})
		 	.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}

	/*PESQUISANDO CLIENTE POR CODIGO*/
	public Cliente findById(Long codigo) {
		return clienteRepository.findById(codigo).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente não encontrado."));
	}
	
	/*LISTANDO TODOS OS CLIENTES*/
	public List<Cliente> findAll(){
		return clienteRepository.findAll();
	}
	
}
