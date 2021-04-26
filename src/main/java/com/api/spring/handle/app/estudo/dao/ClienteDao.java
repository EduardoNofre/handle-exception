package com.api.spring.handle.app.estudo.dao;

import java.util.List;
import java.util.Optional;

import com.api.spring.handle.app.estudo.entity.ClienteEntity;

public interface ClienteDao {

	List<ClienteEntity> listaCliente();

	Optional<ClienteEntity> porIdCliente(Long id);

	ClienteEntity cadastroCliente(String nome, String telefone, String email);

	void atualizaCliente(ClienteEntity clienteEntity);
	
	void deleteCliente(Long id);

	Optional<ClienteEntity> existeCliente(Long id);
	
	Optional<ClienteEntity> buscaEmailCliente(String email);
}
