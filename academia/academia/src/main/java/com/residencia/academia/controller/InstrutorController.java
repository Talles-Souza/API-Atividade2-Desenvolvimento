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
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.InstrutorService;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

	@Autowired
	private InstrutorService instrutorService;

	@GetMapping
	public ResponseEntity<List<Instrutor>> findAllInstrutor() {
		List<Instrutor> instrutorList = instrutorService.findAllInstrutor();
		if (null == instrutorList)
			throw new NoSuchElementFoundException("Nenhum Instrutor encontrado");
		else
			return new ResponseEntity<>(instrutorService.findAllInstrutor(), HttpStatus.OK);


	}

	@GetMapping("/dto/{id}")
	public ResponseEntity<InstrutorDTO> findInstrutorDTOById(@PathVariable Integer id) {
		InstrutorDTO instrutorDTO = instrutorService.findInstrutorDTOById(id);
		if (null == instrutorDTO)
			throw new NoSuchElementFoundException("Não foi encontrada Instrutor com o id " + id);
		else
			return new ResponseEntity<>(instrutorDTO, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> findInstrutorById(@PathVariable Integer id) {
		Instrutor instrutor = instrutorService.findInstrutorById(id);
		if (null == instrutor)
			throw new NoSuchElementFoundException("Não foi encontrado Instrutor com o id " + id);
		else
			return new ResponseEntity<>(instrutor, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
		Instrutor instrutorNovo = instrutorService.saveInstrutor(instrutor);
		return new ResponseEntity<>(instrutorNovo, HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	public ResponseEntity<InstrutorDTO> saveInstrutorDTO(@RequestBody InstrutorDTO instrutorDto) {
		InstrutorDTO instrutorDTO = instrutorService.saveInstrutorDTO(instrutorDto);
		return new ResponseEntity<>(instrutorDTO, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Instrutor> updateInstrutor(@RequestBody Instrutor instrutor) {
		Instrutor instrutorNovo = instrutorService.findInstrutorById(instrutor.getIdInstrutor());
		if (null == instrutorNovo) {
			throw new NoSuchElementFoundException("Não foi possivel atualizar o Instrutor ");
		}else
		return new ResponseEntity<>(instrutorService.updateInstrutor(instrutor), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteInstrutor(@PathVariable Integer id) {
		Instrutor instrutor = instrutorService.findInstrutorById(id);
		if (null == instrutor)
			throw new NoSuchElementFoundException("Não foi possivel deletar o Instrutor com o id " + id);
		else
			instrutorService.deleteInstrutor(id);
		return new ResponseEntity<>("", HttpStatus.OK);

	}
}
