package br.elielsonRodrigues.git.clientesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.elielsonRodrigues.git.clientesapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
