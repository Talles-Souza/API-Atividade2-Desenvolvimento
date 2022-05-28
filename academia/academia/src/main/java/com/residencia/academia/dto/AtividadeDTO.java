package com.residencia.academia.dto;

import java.util.List;

import com.residencia.academia.entity.Turma;

public class AtividadeDTO {

    private Integer idAtividade;
	private String nomeAtividade;
	private List<TurmaDTO> turmaList;
	
	@Override
	public String toString() {
		return "AtividadeDTO [idAtividade=" + idAtividade + ", nomeAtividade=" + nomeAtividade + ", turmaList="
				+ turmaList + "]";
	}
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
	public List<TurmaDTO> getTurmaList() {
		return turmaList;
	}
	public void setTurmaList(List<TurmaDTO> turmaList) {
		this.turmaList = turmaList;
	}
	
	
	
}
