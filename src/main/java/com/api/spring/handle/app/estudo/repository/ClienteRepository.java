package com.api.spring.handle.app.estudo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.spring.handle.app.estudo.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	Optional<ClienteEntity>  findByEmail(String email);

}
