package com.examplo.cursomc.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.examplo.cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepositoryImplementation<Pagamento, Integer> {
	
	
	

}
