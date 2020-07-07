package com.examplo.cursomc.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.examplo.cursomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepositoryImplementation<Pedido, Integer> {
	
	
	

}
