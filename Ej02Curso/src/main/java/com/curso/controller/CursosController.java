package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Curso;

import com.curso.service.CursosService;


@RestController
public class CursosController {

	@Autowired
	CursosService service;
	
	
	//http://localhost:8080/cursos/333
	@GetMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso buscarCurso(@PathVariable int codCurso) {
			return service.buscarCurso(codCurso);
	}
	
	
	//http://localhost:8080/cursos
	@PostMapping(value="cursos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaCurso(@RequestBody Curso curso) {
			service.altaCurso(curso);
	}
	
	//http://localhost:8080/cursos/333 
	@DeleteMapping(value="cursos/{codCurso}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> eliminarCurso(@PathVariable int codCurso){
		return service.eliminarCurso(codCurso);
	}
	
	// http://localhost:8080/cursos/111/duracion?nuevaDuracion=60
	@PutMapping(value = "cursos/{codCurso}/duracion", consumes=MediaType.APPLICATION_JSON_VALUE)
    public void actualizarDuracion(@PathVariable int codCurso, @RequestParam int nuevaDuracion) {
        service.actualizarDuracion(codCurso, nuevaDuracion);
    }
	
	// http://localhost:8080/cursos/por-precio?precioMin=100&precioMax=400
	@GetMapping(value = "/cursos/por-precio", produces=MediaType.APPLICATION_JSON_VALUE )
    public List<Curso> obtenerCursosPorPrecio(@RequestParam int precioMin, @RequestParam int precioMax) {
        return service.cursosPorPrecio(precioMin, precioMax);
    }
	
	
}
