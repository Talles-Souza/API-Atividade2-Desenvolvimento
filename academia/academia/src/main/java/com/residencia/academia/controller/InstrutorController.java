package com.residencia.academia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<Instrutor> saveInstrutor(@RequestBody @Valid Instrutor instrutor) {
		Instrutor instrutorNovo = instrutorService.saveInstrutor(instrutor);
		return new ResponseEntity<>(instrutorNovo, HttpStatus.CREATED);
	}

	@PostMapping("/dto")
	public ResponseEntity<InstrutorDTO> saveInstrutorDTO(@RequestBody @Valid InstrutorDTO instrutorDto) {
		InstrutorDTO instrutorDTO = instrutorService.saveInstrutorDTO(instrutorDto);
		return new ResponseEntity<>(instrutorDTO, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Instrutor> updateInstrutor(@RequestBody @Valid Instrutor instrutor) {
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
	//Validação
	
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
				Map<String, String> errors = new HashMap<>();
			
				ex.getBindingResult().getAllErrors().forEach((error) -> {
					String fieldName = ((FieldError) error).getField();
					String errorMessage = error.getDefaultMessage();
					errors.put(fieldName, errorMessage);
				});
				
			return errors;
		}
}
