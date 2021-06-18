package com.bullet.bullet.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bullet.bullet.models.Atividade;

import com.bullet.bullet.repository.AtividadeRepository;

@RestController
@RequestMapping(value="/bullet")
public class AtividadeResource {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@GetMapping("/atividades")
	public List<Atividade>listaAtividades(){
		return (List<Atividade>) atividadeRepository.findAll();
	}
	@GetMapping("/atividade/{codigo}")
	public Atividade listaAtividadeUnica(@PathVariable(value="codigo") long codigo) {
		return atividadeRepository.findByCodigo(codigo);
	}
	@PostMapping("/atividade")
	public Atividade salvaAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
	@DeleteMapping("/atividade")
	public void deletaAtividade(@RequestBody Atividade atividade) {
		atividadeRepository.delete(atividade);
	}
	@PutMapping("/atividade")
	public Atividade atualizaAtividade(@RequestBody Atividade atividade) {
		return atividadeRepository.save(atividade);
	}
}
