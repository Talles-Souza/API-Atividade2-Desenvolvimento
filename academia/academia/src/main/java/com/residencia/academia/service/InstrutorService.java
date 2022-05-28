package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {

	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAllInstrutor() {
	 return instrutorRepository.findAll().isEmpty() ? null : instrutorRepository.findAll();
	}

	public Instrutor findInstrutorById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get() : null;
	}

	public InstrutorDTO findInstrutorDTOById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get()
				: null;
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if (null != instrutor) {

			instrutorDTO = convertendoEntidadeParaDTO(instrutor);
			return instrutorDTO;
		}
		return null;
	}

	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public InstrutorDTO saveInstrutorDTO(InstrutorDTO instrutorDto) {
        Instrutor instrutor = new Instrutor();
		instrutor = convertendoDTOparaEntidade(instrutorDto);
		Instrutor instrutorNovo = instrutorRepository.save(instrutor);

		return convertendoEntidadeParaDTO(instrutorNovo);
	}

	public Instrutor updateInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public void deleteInstrutor(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).get();
		instrutorRepository.delete(instrutor);
	}

	/*public void deleteInstrutor(Instrutor Instrutor) {
		instrutorRepository.delete(Instrutor);

	}*/

	private InstrutorDTO convertendoEntidadeParaDTO(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
		instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
		instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
		instrutorDTO.setRg(instrutor.getRg());
		instrutorDTO.setTitulacaoInstrutor(instrutor.getTitulacaoInstrutor());

		List<TurmaDTO> listTurmaDTO = new ArrayList<>();
		if (null != instrutor.getTurmaList()) {
			for (Turma turma : instrutor.getTurmaList()) {
				TurmaDTO turmaDTO = new TurmaDTO();
				turmaDTO.setDataFim(turma.getDataFim());
				turmaDTO.setDataInicio(turma.getDataInicio());
				turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
				turmaDTO.setHorarioTurma(turma.getHorarioTurma());
				turmaDTO.setIdTurma(turma.getIdTurma());

				listTurmaDTO.add(turmaDTO);
			}
			instrutorDTO.setTurmaDTOList(listTurmaDTO);
		}

		return instrutorDTO;
	}

	private Instrutor convertendoDTOparaEntidade(InstrutorDTO instrutorDto) {
		Instrutor instrutor = new Instrutor();
		instrutor.setDataNascimento(instrutorDto.getDataNascimento());
		instrutor.setIdInstrutor(instrutorDto.getIdInstrutor());
		instrutor.setNomeInstrutor(instrutorDto.getNomeInstrutor());
		instrutor.setRg(instrutorDto.getRg());
		instrutor.setTitulacaoInstrutor(instrutorDto.getTitulacaoInstrutor());
        
		return instrutor;
	}

}
