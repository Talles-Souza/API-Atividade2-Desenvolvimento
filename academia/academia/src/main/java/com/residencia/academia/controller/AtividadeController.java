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

import com.residencia.academia.entity.Atividade;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.AtividadeService;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

	@Autowired 
	private AtividadeService atividadeService;
	
	@GetMapping
	public ResponseEntity<List<Atividade>> findAllAtividade() {
		List<Atividade> atividade = atividadeService.findAllAtividade();
		if (null == atividade)
			throw new NoSuchElementFoundException("Nenhuma atividade encontrada");
		else
		    return new ResponseEntity<>(atividadeService.findAllAtividade(), HttpStatus.OK);

	}
	@PostMapping
	public ResponseEntity<Atividade> saveAtividade(@RequestBody @Valid Atividade atividade) {
		return new ResponseEntity<>(atividadeService.saveAtividade(atividade), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atividade> findAtividadeById(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findAtividadeById(id);
		if (null == atividade)
			throw new NoSuchElementFoundException("Não foi encontrada Atividade com o id " + id);
		else
			return new ResponseEntity<>(atividadeService.findAtividadeById(id), HttpStatus.OK);
	} 

	@PutMapping
	public ResponseEntity<Atividade> updateAtividade(@RequestBody @Valid Atividade atividade) {
		return new ResponseEntity<>(atividadeService.updateAtividade(atividade), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAtividade(@PathVariable Integer id) {
		Atividade atividade = atividadeService.findAtividadeById(id);
		if (null == atividade)
			throw new NoSuchElementFoundException("Não foi possivel deletar a Atividade com o id " + id);
		else
			atividadeService.deleteAtividade(id);
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
