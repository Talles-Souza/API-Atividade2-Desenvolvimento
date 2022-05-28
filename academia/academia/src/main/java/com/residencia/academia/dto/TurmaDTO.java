package com.residencia.academia.dto;

import java.util.Date;

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.entity.Instrutor;

public class TurmaDTO {

	private Integer idTurma;
	private Date horarioTurma;
	private Integer duracaoTurma;
	private Date dataInicio;
	private Date dataFim;
	private InstrutorDTO instrutorDTO;
	private AtividadeDTO atividadeDTO;
	

	@Override
	public String toString() {
		return "TurmaDTO [idTurma=" + idTurma + ", horarioTurma=" + horarioTurma + ", duracaoTurma=" + duracaoTurma
				+ ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Date getHorarioTurma() {
		return horarioTurma;
	}

	public void setHorarioTurma(Date horarioTurma) {
		this.horarioTurma = horarioTurma;
	}

	public Integer getDuracaoTurma() {
		return duracaoTurma;
	}

	public void setDuracaoTurma(Integer duracaoTurma) {
		this.duracaoTurma = duracaoTurma;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public InstrutorDTO getInstrutorDTO() {
		return instrutorDTO;
	}

	public void setInstrutorDTO(InstrutorDTO instrutorDTO) {
		this.instrutorDTO = instrutorDTO;
	}

	public AtividadeDTO getAtividadeDTO() {
		return atividadeDTO;
	}

	public void setAtividadeDTO(AtividadeDTO atividadeDTO) {
		this.atividadeDTO = atividadeDTO;
	}
	

}