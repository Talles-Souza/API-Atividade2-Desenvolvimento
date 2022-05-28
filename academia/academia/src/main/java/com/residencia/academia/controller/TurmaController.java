package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.dto.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma() {
		List<Turma> turmas = turmaService.findAllTurma();
		if (null == turmas)
			throw new NoSuchElementFoundException("Nenhuma turma encontrada");
		else
			return new ResponseEntity<>(turmaService.findAllTurma(), HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (null == turma)
			throw new NoSuchElementFoundException("Não foi encontrada Turma com o id " + id);
		else
			return new ResponseEntity<>(turmaService.findTurmaById(id), HttpStatus.OK);
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findTurmaDTOById(id);
		if (null == turmaDTO)
			throw new NoSuchElementFoundException("Não foi encontrada  a Turma com o id " + id);
		else
			return new ResponseEntity<>(turmaDTO, HttpStatus.OK);
	}
	@PostMapping("/dto")
	public ResponseEntity<TurmaDTO> saveTurmaDTO(@RequestBody TurmaDTO turmaDto) {
		TurmaDTO turmaDTO = turmaService.saveTurmaDTO(turmaDto);
		return new ResponseEntity<>(turmaDTO, HttpStatus.CREATED);
	}

	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma) {
		Turma turma1 = turmaService.findTurmaById(turma.getIdTurma());
		if(null == turma1) 
			throw new NoSuchElementFoundException("Não foi possivel atualizar a Turma ");
		else
		return new ResponseEntity<>(turmaService.updateTurma(turma), HttpStatus.OK);
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Integer id) {
		Turma turma = turmaService.findTurmaById(id);
		if (null == turma)
			throw new NoSuchElementFoundException("Não foi possivel deletar a Turma com o id " + id);
		else
			turmaService.deleteTurma(id);
			return new ResponseEntity<>("", HttpStatus.OK);
	
	}
	
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurmaComConferencia(@PathVariable Integer id) {
		Boolean verificacao = turmaService.deleteTurmaComConferencia(id);
		if(verificacao)
			return new ResponseEntity<>("", HttpStatus.OK);
		else
			throw new NoSuchElementFoundException("Não foi possível excluir a Turma, "
					+ "pois não foi "
					+ "encontrada uma turma com o id " + id);
		
	}
	*/
	
}
