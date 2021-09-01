package com.vaescode.contactos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.vaescode.contactos.model.Contacto;

@Repository
public class AgendaDaoImpl implements AgendaDao {

	@Autowired
	AgendaJpaSpring agenda;

	@Override
	public void agregarContacto(Contacto contacto) {
		agenda.save(contacto);
	}

	@Override
	public Contacto recuperarContacto(String email) {
		// TODO Auto-generated method stub
		return agenda.findByEmail(email);
	}

	@Override
	public void eliminarContacto(String email) {
		// TODO Auto-generated method stub
		agenda.eliminarPorEmail(email);
	}

	@Override
	public List<Contacto> devolverContactos() {
		// TODO Auto-generated method stub
		return agenda.findAll();
	}

	@Override
	public void eliminarContacto(int idContacto) {
		// TODO Auto-generated method stub
		agenda.deleteById(idContacto);
	}

	@Override
	public Contacto recuperarContacto(int idContacto) {
		// TODO Auto-generated method stub
		return agenda.findById(idContacto).orElse(null);
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		// TODO Auto-generated method stub
			agenda.save(contacto);
	}

}
