package com.api.spring.handle.app.estudo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProdutoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Schema(description = "Id produto.", example = "123", required = true)
	@Column(name = "idProduto", length = 9)
	private Long idProduto;

	@Schema(description = "Nome do produto.", example = "abc", required = true)
	@Size(max = 50)
	@Column(name = "nomeProduto", length = 100)
	private String nomeProduto;

	@Schema(description = "descrição do produto do cliente.", example = "abc", required = true)
	@Size(max = 50)
	@Column(name = "descProduto", length = 100)
	private String descProduto;

}
