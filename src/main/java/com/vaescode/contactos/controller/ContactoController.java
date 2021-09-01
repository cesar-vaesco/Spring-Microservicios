package com.vaescode.contactos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vaescode.contactos.model.Contacto;
import com.vaescode.contactos.service.AgendaService;

@RestController
public class ContactoController {

	@Autowired
	AgendaService service;

	@GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> recuperarContactos() {
		return service.recuperarContactos();
	}

	@SuppressWarnings("unchecked")
	@GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> recuperarContactos(@PathVariable("id") int id) {
		return (List<Contacto>) service.buscarContacto(id);
	}

	@PostMapping(value = "contacto", 
					consumes = MediaType.APPLICATION_JSON_VALUE, 
					produces = MediaType.APPLICATION_JSON_VALUE)
	public String guardarContacto(@RequestBody Contacto contacto) {
		 return String.valueOf(service.agregarContacto(contacto));
	}
	
	@PutMapping(value = "contacto", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void editarContacto(@RequestBody Contacto contacto) {
		service.actualizarContacto(contacto);
	}
	
	@DeleteMapping(value="eliminar/{id}")
	public void eliminarPorId(@PathVariable("id") int id) {
		service.eliminarContacto(id);
	}

}
