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

import com.api.spring.handle.app.estudo.entity.ClienteEntity;
import com.api.spring.handle.app.estudo.service.ServiceCliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1/cliente/")
@Tag(name = "Cliente Controller", description = "Cliente crud API handle")
public class ClienteController {

	@Autowired
	private ServiceCliente serviceCliente;

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 400.000 = Número do telefone informado não é valido: %s.<br/>" )})
	@Operation(summary = "Lista todos os cliente.", description = "Busca todos os cliente no banco de dados", tags = {"Lista todos os clientes" })
	@GetMapping(value = "clientes", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> listaCliente() {

		return new ResponseEntity<>(serviceCliente.listaCliente(), HttpStatus.OK);
	}

	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
			"Código da falha: 413.103 = Cliente não encontrada pelo id: %s. <br/>")})
	@Operation(summary = "Busca cliente por id", description = "Busca cliente por id no banco de dados", tags = {"Busca por id" })
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> buscaId(@Parameter(description = "id cliente.", required = true) @PathVariable Long id) throws Exception {

		return new ResponseEntity<>(serviceCliente.porIdCliente(id), HttpStatus.OK);
	}

	@Operation(summary = "Cadastro de cliente", description = "Cadastro de cliente no banco de dados", tags = {"Cadastro de cliente" })
	@PostMapping(path = "cadastro/{nome}/{telefone}/{email}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> cadastroCliente(@Parameter(description = "Nome do cliente.", required = true) @PathVariable String nome,
											 @Parameter(description = "Telefone do cliente.", required = true) @PathVariable String telefone,
											 @Parameter(description = "E-mail do cliente.", required = true) @PathVariable String email) {

		return new ResponseEntity<>(serviceCliente.cadastroCliente(nome, telefone, email), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.105 = Cliente não encontrado pelo id para ser atualizado: %s. <br/>")})
	@Operation(summary = "Atualiza o cliente", description = "Atualiza os dados do cliente no banco de dados", tags = {"Update Cliente" })
	@PutMapping(value = "atualiza/{IdCliente}", produces = { "application/json", "application/xml" }, consumes = {"application/json", "application/xml" })
	public ResponseEntity<?> atualizaCliente(@RequestBody @Valid ClienteEntity clienteEntity) throws Exception {

		return new ResponseEntity<>(serviceCliente.atualizaCliente(clienteEntity), HttpStatus.OK);
	}

	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"+
							"Código da falha: 413.104 = Cliente não encontrada pelo id para ser deletado: %s. <br/>")})
	@Operation(summary = "Deleta o cliente", description = "Deleta os dados do cliente no banco de dados", tags = {"Deleta Cliente" })
	@DeleteMapping(path = "Remove/id{idCliente}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> deleteCliente(@Parameter(description = "id cliente.", required = true) @PathVariable Long idCliente) throws Exception {

		return new ResponseEntity<>(serviceCliente.deleteCliente(idCliente), HttpStatus.OK);
	}
	
	
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Sucesso"),			
							@ApiResponse(responseCode = "400", description = "Processar a requisição <br/>"
					     + "Código da falha: 413.104 = Cliente não encontrada pelo id para ser deletado: %s. <br/>") })
	@Operation(summary = "Busca o cliente pelo e-mail", description = "Busca o cliente pelo e-mail no banco de dados", tags = {"Busca o cliente pelo e-mail" })
	@GetMapping(path = "email/{email}", produces = { "application/json", "application/xml" })
	public ResponseEntity<?> buscaEmailCliente(@Parameter(description = "E-mail do cliente.", required = true) @PathVariable String email)throws Exception {

		return new ResponseEntity<>(serviceCliente.buscaEmailCliente(email), HttpStatus.OK);
	}

}
