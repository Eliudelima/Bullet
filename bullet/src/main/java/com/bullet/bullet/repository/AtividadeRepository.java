package com.bullet.bullet.repository;

import org.springframework.data.repository.CrudRepository;

import com.bullet.bullet.models.Atividade;


	public interface AtividadeRepository extends CrudRepository<Atividade, String>{
		Atividade findByCodigo(long codigo);
}




