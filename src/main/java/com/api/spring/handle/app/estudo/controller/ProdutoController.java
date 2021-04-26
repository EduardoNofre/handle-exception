package com.api.spring.handle.app.estudo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.spring.handle.app.estudo.entity.ProdutoEntity;
import com.api.spring.handle.app.estudo.service.ServiceProduto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/produto/")
@Tag(name = "Produto Controller", description = "Produto crud API handle")
public class ProdutoController {

	@Autowired
	private ServiceProduto serviceProduto;

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.104 = Cliente não encontrada pelo id para ser deletado: %s. <br/>")})
	@Operation(summary = "Lista todos os Produto.", description = "Busca todos os Produto no banco de dados", tags = {"Lista todos os Produtos"})
	@GetMapping(value = "Produtos", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> listaProduto() {

		return new ResponseEntity<>(serviceProduto.listaProduto(), HttpStatus.OK);
	}
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.106 = Produto não encontrada pelo id: %s. <br/>")})
	@Operation(summary = "Busca Produto por id", description = "Busca Produto por id no banco de dados", tags = {"Busca por id" })
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> buscaId(@Parameter(description = "id Produto.", required = true) @PathVariable Long id) throws Exception {

		return new ResponseEntity<>(serviceProduto.porIdProduto(id), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso")})
	@Operation(summary = "Cadastro de Produto", description = "Cadastro de Produto no banco de dados", tags = {"Cadastro de Produto" })
	@PostMapping(path = "cadastro/{nome}/{telefone}", produces = {"application/json", "application/xml" })
	public ResponseEntity<?> cadastroProduto(@Parameter(description = "Nome do Produto.", required = true) @PathVariable String nome,
											 @Parameter(description = "Telefone do Produto.", required = true) @PathVariable String telefone) {

		return new ResponseEntity<>(serviceProduto.cadastroProduto(nome, telefone), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.108 = Produto não encontrado pelo id para ser atualizado: %s. <br/>")})
	@Operation(summary = "Atualiza o Produto", description = "Atualiza os dados do Produto no banco de dados", tags = {"Update Produto" })
	@PutMapping(value = "atualiza/{IdProduto}", produces = { "application/json", "application/xml" }, consumes = {"application/json", "application/xml" })
	public ResponseEntity<?> atualizaProduto(@RequestBody @Valid ProdutoEntity ProdutoEntity) throws Exception {

		return new ResponseEntity<>(serviceProduto.atualizaProduto(ProdutoEntity), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.107 = Produto não encontrada pelo id para ser deletado: %s. <br/>")})
	@DeleteMapping(path = "Remove/id{idProduto}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> deleteProduto(@Parameter(description = "id Produto.", required = true) @PathVariable Long idProduto) throws Exception {

		return new ResponseEntity<>(serviceProduto.deleteProduto(idProduto), HttpStatus.OK);
	}

}
