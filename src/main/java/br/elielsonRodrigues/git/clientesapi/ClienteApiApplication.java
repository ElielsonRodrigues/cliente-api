package br.elielsonRodrigues.git.clientesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClienteApiApplication {

	/*
	@Bean 
	CommandLineRunner run(@Autowired ClienteRepository clienteRepository) {
		return args -> {
			Cliente cliente =  Cliente.builder().cpf("02195650230").nome("ELIELSON").build();
			clienteRepository.save(cliente);
		};
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteApiApplication.class, args);
	}

}
