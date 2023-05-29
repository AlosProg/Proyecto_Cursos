package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.CursosDao;
import com.curso.model.Curso;


@Service
public class CursoServiceImp implements CursosService {

	@Autowired
	CursosDao dao;
	
	@Override
	public List<Curso> altaCurso(Curso curso) {
		dao.save(curso);
		return dao.findAll();
	}

	@Override
	public List<Curso> eliminarCurso(int codCurso) {
		dao.deleteById(codCurso);
		return dao.findAll();
	}

	@Override
    public void actualizarDuracion(int codCurso, int nuevaDuracion) {
        dao.actualizarDuracion(codCurso, nuevaDuracion);
    }
	

	@Override
	public Curso buscarCurso(int codCurso) {
		return dao.findById(codCurso).orElse(null);
	}

	@Override
	public List<Curso> cursosPorPrecio(int precioMin, int precioMax) {
		return dao.cursosPorPrecio(precioMin, precioMax);
	}

}
