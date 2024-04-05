package br.elielsonRodrigues.git.clientesapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
public class Cliente {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long codigo;
		
		@NotEmpty(message = "Nome é obrigatório.")
		@Size(min = 3, max = 150 , message = "Nome no mínimo 3 letras no máximo 150.")
		private String nome;
		
		@NotEmpty(message = "Cpf é obrigatório")
		@CPF(message = "Este Cpf é inválido.")
		private String cpf;
		
		@Min(value = 1, message = "Idade minima de 1 ano.")
		@Max(value = 100, message = "Idade maxima de 100 anos.")
		private Integer idade;
		
		
}
