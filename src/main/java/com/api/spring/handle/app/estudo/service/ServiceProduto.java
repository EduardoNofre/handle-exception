package com.api.spring.handle.app.estudo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.spring.handle.app.estudo.dao.ProdutoDao;
import com.api.spring.handle.app.estudo.entity.ProdutoEntity;
import com.api.spring.handle.app.estudo.exceptions.ProdutoNaoEncontradoAtualizarException;
import com.api.spring.handle.app.estudo.exceptions.ProdutoNaoEncontradoDeleteException;
import com.api.spring.handle.app.estudo.exceptions.ProdutoNaoEncontradoException;

@Service
public class ServiceProduto {

	@Autowired
	private ProdutoDao produtoDao;

	public List<ProdutoEntity> listaProduto() {

		return produtoDao.listaProduto();

	}

	public Optional<ProdutoEntity> porIdProduto(Long id) throws Exception{

		if (produtoDao.existeProduto(id).isPresent()) {
			
		return produtoDao.porIdProduto(id);
		
		}else {
			
			throw new ProdutoNaoEncontradoException();
		}
	}

	public ProdutoEntity cadastroProduto(String nome, String telefone) {

		return produtoDao.cadastroProduto(nome, telefone);

	}

	public ProdutoEntity atualizaProduto(ProdutoEntity ProdutoEntity) throws Exception {

		if (produtoDao.existeProduto(ProdutoEntity.getIdProduto()).isPresent()) {

			produtoDao.atualizaProduto(ProdutoEntity);

			return produtoDao.existeProduto(ProdutoEntity.getIdProduto()).get();

		} else {

			throw new ProdutoNaoEncontradoAtualizarException();
		}
	}

	public ProdutoEntity deleteProduto(Long idProduto) throws Exception {

		Optional<ProdutoEntity> optionalProduto = produtoDao.existeProduto(idProduto);

		if (optionalProduto.isPresent()) {

			produtoDao.deleteProduto(optionalProduto.get().getIdProduto());

			return produtoDao.existeProduto(idProduto).get();

		} else {

			throw new ProdutoNaoEncontradoDeleteException();
		}
	}

}
