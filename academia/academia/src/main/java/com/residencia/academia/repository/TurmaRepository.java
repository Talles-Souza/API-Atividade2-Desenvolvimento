package com.residencia.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.residencia.academia.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma,Integer> {
 
	//Turma findByDataInicio(Date datainicio);
}
