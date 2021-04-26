package com.api.spring.handle.app.estudo.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.spring.handle.app.estudo.dao.ProdutoDao;
import com.api.spring.handle.app.estudo.entity.ProdutoEntity;
import com.api.spring.handle.app.estudo.repository.ProdutoRepository;

@Component
public class ProdutoDaoImpl implements ProdutoDao {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<ProdutoEntity> listaProduto() {
		return produtoRepository.findAll();
	}

	@Override
	public Optional<ProdutoEntity> porIdProduto(Long id) {

		return produtoRepository.findById(id);
	}

	@Override
	public ProdutoEntity cadastroProduto(String nomeProduto, String descProduto) {

		ProdutoEntity produtoEntity = new ProdutoEntity();
		produtoEntity.setNomeProduto(nomeProduto);
		produtoEntity.setDescProduto(descProduto);

		return produtoRepository.save(produtoEntity);
	}

	@Override
	public void atualizaProduto(ProdutoEntity produtoEntity) {

		produtoRepository.save(produtoEntity);

	}

	@Override
	public void deleteProduto(Long id) {

		produtoRepository.deleteById(id);

	}

	@Override
	public Optional<ProdutoEntity> existeProduto(Long id) {

		return produtoRepository.findById(id);
	}

}
