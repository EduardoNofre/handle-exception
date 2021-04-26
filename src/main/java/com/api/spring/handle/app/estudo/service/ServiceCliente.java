package com.api.spring.handle.app.estudo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.spring.handle.app.estudo.dao.ClienteDao;
import com.api.spring.handle.app.estudo.entity.ClienteEntity;
import com.api.spring.handle.app.estudo.exceptions.ClienteNaoEncontradoAtualizarException;
import com.api.spring.handle.app.estudo.exceptions.ClienteNaoEncontradoDeleteException;
import com.api.spring.handle.app.estudo.exceptions.ClienteNaoEncontradoException;
import com.api.spring.handle.app.estudo.exceptions.EmailCaracterArrobaException;
import com.api.spring.handle.app.estudo.exceptions.EmailCaracterPontoException;
import com.api.spring.handle.app.estudo.exceptions.EmailCaracterPontosQuantidadeException;
import com.api.spring.handle.app.estudo.exceptions.EmailNaoEncontradoException;

/** 
 * 
 * @author nofre
 *
 * Essa classe foi feita para estudo na validação do email logico queria iria utulizar expressão regular.
 *
 */

@Service
public class ServiceCliente {

	@Autowired
	private ClienteDao clienteDao;

	public List<ClienteEntity> listaCliente() {

		return clienteDao.listaCliente();

	}

	public Optional<ClienteEntity> porIdCliente(Long id) throws Exception{

		if (clienteDao.existeCliente(id).isPresent()) {

			return clienteDao.porIdCliente(id);

		} else {

			throw new ClienteNaoEncontradoException();
		}
	}

	public ClienteEntity cadastroCliente(String nome, String telefone,String email) {

		return clienteDao.cadastroCliente(nome, telefone, email);

	}

	public ClienteEntity atualizaCliente(ClienteEntity clienteEntity) throws Exception {

		if (clienteDao.existeCliente(clienteEntity.getIdCliente()).isPresent()) {

			clienteDao.atualizaCliente(clienteEntity);

			return clienteDao.existeCliente(clienteEntity.getIdCliente()).get();

		} else {

			throw new ClienteNaoEncontradoAtualizarException();
		}
	}

	public ClienteEntity deleteCliente(Long idcliente) throws Exception {

		Optional<ClienteEntity> optionalCliente = clienteDao.existeCliente(idcliente);

		if (optionalCliente.isPresent()) {

			clienteDao.deleteCliente(optionalCliente.get().getIdCliente());

			return clienteDao.existeCliente(idcliente).get();

		} else {

			throw new ClienteNaoEncontradoDeleteException();
		}
	}
	
	public ClienteEntity buscaEmailCliente(String email) throws Exception {

		if(!(email.contains("@"))) {

			throw new EmailCaracterArrobaException();

		}else if(!(email.contains("."))) {

			throw new EmailCaracterPontoException();

		}else if(email.contains(".")) {

			String [] arrayDot = email.split("\\.");

			if(!(arrayDot.length > 0 && (arrayDot.length == 2 || arrayDot.length == 1))) {

				throw new EmailCaracterPontosQuantidadeException();
			}
		}
		if(!clienteDao.buscaEmailCliente(email).isPresent()) {

			throw new EmailNaoEncontradoException();
		}

		return clienteDao.buscaEmailCliente(email).get();

	}
}
