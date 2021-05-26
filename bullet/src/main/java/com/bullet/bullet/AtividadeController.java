package com.bullet.bullet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bullet.bullet.models.Atividade;
import com.bullet.bullet.models.Estudante;
import com.bullet.bullet.repository.AtividadeRepository;
import com.bullet.bullet.repository.EstudanteRepository;


@Controller
public class AtividadeController {

	
	@Autowired
	private AtividadeRepository ar;
	
	@Autowired
	private EstudanteRepository er;
	
	@RequestMapping(value="/cadastrarAtividade", method=RequestMethod.GET)
	public String form() {
		return "atividade/formAtividade";
	}
	
	@RequestMapping(value="/cadastrarAtividade", method=RequestMethod.POST)
	public String form(Atividade atividade, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{codigo}"; 
		}
		
		ar.save(atividade);
		attributes.addFlashAttribute("mensagem", "Atividade cadastrada com Sucesso!");
		return "redirect:/cadastrarAtividade";
	}
	@RequestMapping("/atividades")
	public ModelAndView listaAtividades() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Atividade> atividades = ar.findAll();
		mv.addObject("atividades", atividades);
		return mv;
	}
	
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesAtividade(@PathVariable("codigo") long codigo) {
		Atividade atividade = ar.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("atividade/detalhesAtividade");
		mv.addObject("atividade", atividade);
		
		Iterable<Estudante> estudantes = er.findByAtividade(atividade);
		mv.addObject("estudantes", estudantes);
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesAtividadePost(@PathVariable("codigo") long codigo, @Valid Estudante estudante, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{codigo}"; 
		}
		Atividade atividade = ar.findByCodigo(codigo);
		estudante.setAtividade(atividade);
		er.save(estudante);
		attributes.addFlashAttribute("mensagem", "Estudante adicionado com sucesso");
		return "redirect:/{codigo}";
	}
	
	
	
	
	
}
