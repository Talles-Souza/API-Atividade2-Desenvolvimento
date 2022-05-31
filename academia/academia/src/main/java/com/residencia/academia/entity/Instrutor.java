package com.residencia.academia.entity;

import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idInstrutor")
@Table(name = "instrutor")
public class Instrutor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_instrutor")
	private Integer idInstrutor;

	@Column(name = "rg")
	@NotBlank(message = "RG não informado")
	private Integer rg;

	@Column(name = "nome")
	@NotBlank(message = "Nome não informado")
	@Pattern(regexp = "^[A-Z]+(.)*", message = "O nome não pode começar com letras minúsculas.")
	private String nomeInstrutor;

	@Column(name = "nascimento")
	@NotBlank(message = "Data não informada")
	private Date dataNascimento;

	@Column(name = "titulacao")
	@NotBlank(message = "Titulação não informada")
	private Integer titulacaoInstrutor;

	@OneToMany(mappedBy = "instrutor")
	//@JsonManagedReference
	//@JsonIgnore
	//@NotBlank(message = "Campo não informado")
	private List<Turma> turmaList;

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTitulacaoInstrutor() {
		return titulacaoInstrutor;
	}

	public void setTitulacaoInstrutor(Integer titulacaoInstrutor) {
		this.titulacaoInstrutor = titulacaoInstrutor;
	}

	public List<Turma> getTurmaList() {
		return turmaList;
	}

	public void setTurmaList(List<Turma> turmaList) {
		this.turmaList = turmaList;
	}

	
}
