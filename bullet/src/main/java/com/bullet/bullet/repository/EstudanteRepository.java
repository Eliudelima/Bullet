package com.bullet.bullet.repository;

import org.springframework.data.repository.CrudRepository;

import com.bullet.bullet.models.Atividade;
import com.bullet.bullet.models.Estudante;

public interface EstudanteRepository extends CrudRepository<Estudante, String>{
	Iterable<Estudante> findByAtividade(Atividade atividade);

}
