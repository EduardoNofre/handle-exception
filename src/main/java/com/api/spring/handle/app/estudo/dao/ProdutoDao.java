package com.api.spring.handle.app.estudo.dao;

import java.util.List;
import java.util.Optional;

import com.api.spring.handle.app.estudo.entity.ProdutoEntity;

public interface ProdutoDao {

	List<ProdutoEntity> listaProduto();

	Optional<ProdutoEntity> porIdProduto(Long id);

	ProdutoEntity cadastroProduto(String nome, String telefone);

	void atualizaProduto(ProdutoEntity produtoEntity);

	void deleteProduto(Long id);

	Optional<ProdutoEntity> existeProduto(Long id);
}
