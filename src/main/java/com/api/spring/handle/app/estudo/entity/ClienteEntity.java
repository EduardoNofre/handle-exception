package com.api.spring.handle.app.estudo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Id cliente.", example = "123", required = true)
	@Column(name = "idCliente", length = 9)
	private Long idCliente;

	@Schema(description = "Nome do cliente.", example = "06720-450", required = true)
	@Size(max = 50)
	@Column(name = "nome", length = 100)
	private String nome;

	@Schema(description = "Idade do cliente.", example = "123", required = true)
	@Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "numero de telefone")
	@Size(max = 20)
	@Column(name = "telefone", length = 20)
	private String telefone;
	
	@Schema(description = "Email do cliente.", example = "123", required = true, nullable = false)
	@Size(max = 40)
	@Column(name = "email", length = 40)
	private String email;
	
	
}
