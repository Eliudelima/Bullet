package com.bullet.bullet.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;




@Entity
public class Estudante {
	@Id
	private String rg;
	private String nomeEstudante;
	
	@ManyToOne
	private Atividade atividade;
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNomeEstudante() {
		return nomeEstudante;
	}
	public void setNomeEstudante(String nomeEstudante) {
		this.nomeEstudante = nomeEstudante;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	
	

}