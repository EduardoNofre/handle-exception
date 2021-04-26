package com.api.spring.handle.app.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.spring.handle.app.estudo.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
