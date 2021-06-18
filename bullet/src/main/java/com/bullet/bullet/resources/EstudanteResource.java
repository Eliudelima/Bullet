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
import com.bullet.bullet.repository.EstudanteRepository;


import com.bullet.bullet.models.Estudante;


@RestController
@RequestMapping(value="/bullet")
public class EstudanteResource {
	
	@Autowired
	private EstudanteRepository estudanteRepository;
	
	@GetMapping("/estudantes")
	public List<Estudante>listaEstudantes(){
		return (List<Estudante>) estudanteRepository.findAll();
	}
	@GetMapping("/estudante/{rg}")
	public Estudante listaEstudanteUnico(@PathVariable (value="rg") String rg) {
		return estudanteRepository.findByRg(rg);

	}
	@PostMapping("/estudante")
	public Estudante salvaEstudante(@RequestBody Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	@DeleteMapping("/estudante")
	public void deletaEstudante(@RequestBody Estudante estudante) {
		estudanteRepository.delete(estudante);
	}
	@PutMapping("/estudante")
	public Estudante atualizaEstudante(@RequestBody Estudante estudante) {
		return estudanteRepository.save(estudante);
	}

}
