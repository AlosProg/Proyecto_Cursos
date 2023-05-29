package com.curso.service;

import java.util.List;

import com.curso.model.Curso;


public interface CursosService {
	
	List<Curso> altaCurso(Curso curso);
	List<Curso> eliminarCurso(int codCurso);
	void actualizarDuracion(int codCurso, int nuevaDuracion);
	Curso buscarCurso(int codCurso);
	List<Curso> cursosPorPrecio(int precioMin, int precioMax);
	
}
