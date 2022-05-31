package com.residencia.academia.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atividade")
	private Integer idAtividade;
	
	@Column(name = "nome")
	@NotBlank(message = "Campo não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O nome não pode começar com letras minúsculas.")
	private String nomeAtividade;
	
	@OneToMany(mappedBy = "atividade")
	//@JsonManagedReference
	//@JsonIgnore
	//@NotBlank(message = "Campo não informado")
	private List<Turma> turmaList;

	public Integer getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(Integer idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}

	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		this.turmaList = turmaList;
	}
	
	

}
