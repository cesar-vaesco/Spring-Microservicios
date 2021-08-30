package com.vaescode.cursos.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.cursos.model.Curso;

/**
 * @author Cesar_Dev
 *
 */
@RestController
public class CursosController {

	private List<Curso> cursos;

	@PostConstruct
	public void init() {
		cursos = new ArrayList<>();
		cursos.add(new Curso("JavaScript", 20, "tarde"));
		cursos.add(new Curso("Ruby", 25, "mañana"));
		cursos.add(new Curso("Scala", 20, "mediodía"));
		cursos.add(new Curso("Phyton", 30, "tarde"));
		cursos.add(new Curso("Java", 80, "noche"));
		cursos.add(new Curso("SQL", 20, "tarde"));
		cursos.add(new Curso("Spring", 20, "tarde"));
	}

	@GetMapping(value = "cursos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos() {
		return cursos;
	}

	@GetMapping(value = "curso", produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java", 100, "Mañana");
	}

	@GetMapping(value = "curso/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCurso(@PathVariable("name") String nombre) {
		List<Curso> aux = new ArrayList<>();
		for (Curso c : cursos) {
			if (c.getNombre().contains(nombre)) {
				aux.add(c);
			}
		}

		return aux;
	}

	@DeleteMapping(value = "curso/{name}")
	public void eliminarCurso(@PathVariable("name") String nombre) {
		cursos.removeIf(c -> c.getNombre().equals(nombre));
	}

	@PostMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> altaCurso(@RequestBody Curso curso) {
		cursos.add(curso);
		return cursos;
	}

	@PutMapping(value = "curso", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> actualizaCurso(@RequestBody Curso curso) {
		for (int i = 0; i < cursos.size(); i++) {
			if (cursos.get(i).getNombre().equals(curso.getNombre())) {
				cursos.set(i, curso);
			}
		}
		return cursos;
	}

	/* -------------------------- */

	@GetMapping(value = "cursos-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public List<Curso> getCursosXML() {
		return cursos;
	}

	@GetMapping(value = "curso-xml", produces = MediaType.APPLICATION_XML_VALUE)
	public Curso getCursoXML() {
		return new Curso("Java", 100, "Mañana");
	}

}
