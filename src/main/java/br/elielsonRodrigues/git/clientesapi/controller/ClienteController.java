package br.elielsonRodrigues.git.clientesapi.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.elielsonRodrigues.git.clientesapi.model.Cliente;
import br.elielsonRodrigues.git.clientesapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(value = "http://localhost:8081")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	/*END-POINT DE PESQUISA DE CLIENTE POR CODIGO*/
	@GetMapping("/{codigo}")
	public ResponseEntity<Cliente> findById(@PathVariable Long codigo){
		Cliente cliente = clienteService.findById(codigo);
		return ResponseEntity.ok(cliente);
	}

	/*END-POINT DE LISTAGEM TODOS OS CLIENTES*/
	@GetMapping()
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> clientes = clienteService.findAll();
		return ResponseEntity.ok(clientes);
	}
	
	/*END-POINT DE CADASTRO DE UM NOVO CLIENTE*/
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente){
		Cliente clSave = clienteService.save(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(clSave.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(clSave);
	}
	
	/*END-POINT DE ATUALIZAÇÃO DE UM CLIENTE*/
	@PutMapping("/{codigo}")
	public ResponseEntity<Cliente> save(@PathVariable Long codigo, @RequestBody @Valid Cliente cliente){
		Cliente clienteUpdate =  clienteService.update(codigo, cliente);
		return ResponseEntity.ok(clienteUpdate);
	}
	
	/*END-POINT DE EXCLUSÃO DE CLIENTE PELO CODIGO*/
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> deleEntity(@PathVariable Long codigo){
		clienteService.deleById(codigo);
		return ResponseEntity.noContent().build();
	}
	
}
