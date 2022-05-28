package com.residencia.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.academia.dto.InstrutorDTO;
import com.residencia.academia.entity.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor,Integer> {

	
}
