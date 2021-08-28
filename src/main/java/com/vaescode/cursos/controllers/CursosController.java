package com.vaescode.cursos.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.cursos.model.Curso;

@RestController
public class CursosController {

	
	private List<Curso> cursos;
	
	@PostConstruct
	public void init() {
		cursos = new ArrayList<>();
		cursos.add(new Curso("JavaScript",20,"tarde"));
		cursos.add(new Curso("Ruby",25,"mañana"));
		cursos.add(new Curso("Scala",20,"mediodía"));
		cursos.add(new Curso("Phyton",30,"tarde"));
		cursos.add(new Curso("Java",80,"noche"));
		cursos.add(new Curso("SQL",20,"tarde"));
		cursos.add(new Curso("Spring",20,"tarde"));
	}
	
	@GetMapping(value="cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso>getCursos(){
		return cursos;
	}
	
	@GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java",100, "Mañana");
	}
	
	@GetMapping(value = "curso/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCurso(@PathVariable("name") String nombre) {
		List<Curso> aux = new ArrayList<>();
		for (Curso c : cursos) {
			if(c.getNombre().contains(nombre)) {
				aux.add(c);
			} 
		}
		
		return aux;
	}
}
