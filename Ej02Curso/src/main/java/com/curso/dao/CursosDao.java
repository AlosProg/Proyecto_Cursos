package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Curso;

import jakarta.transaction.Transactional;

public interface CursosDao extends JpaRepository<Curso, Integer> {

	@Transactional
    @Modifying
    @Query("UPDATE cursos c SET c.duracion = :nuevaDuracion WHERE c.codCurso = :codCurso")
    void actualizarDuracion(int codigo, int nuevaDuracion);
	
	@Query("SELECT c FROM cursos c WHERE c.precio >= :minPrecio AND c.precio <= :maxPrecio")
    List<Curso> cursosPorPrecio(int minPrecio, int maxPrecio);
			
}
