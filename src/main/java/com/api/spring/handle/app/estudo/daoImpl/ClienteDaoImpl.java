package com.api.spring.handle.app.estudo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.spring.handle.app.estudo.dao.ClienteDao;
import com.api.spring.handle.app.estudo.entity.ClienteEntity;
import com.api.spring.handle.app.estudo.repository.ClienteRepository;

@Component
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<ClienteEntity> listaCliente() {

		return clienteRepository.findAll();

	}

	@Override
	public Optional<ClienteEntity> porIdCliente(Long id) {

		return clienteRepository.findById(id);

	}

	@Override
	public ClienteEntity cadastroCliente(String nome, String telefone,String email) {

		ClienteEntity clienteEntity = new ClienteEntity();
		clienteEntity.setNome(nome);
		clienteEntity.setTelefone(telefone);
		clienteEntity.setEmail(email);
		

		return clienteRepository.save(clienteEntity);

	}

	@Override
	public void atualizaCliente(ClienteEntity clienteEntity) {

		clienteRepository.save(clienteEntity);
	}

	@Override
	public Optional<ClienteEntity> existeCliente(Long id) {

		return clienteRepository.findById(id);
	}

	@Override
	public void deleteCliente(Long idCliente) {

		clienteRepository.deleteById(idCliente);

	}

	@Override
	public Optional<ClienteEntity> buscaEmailCliente(String email) {
				
		return clienteRepository.findByEmail(email);

	}
}
