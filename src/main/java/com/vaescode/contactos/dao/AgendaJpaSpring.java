package com.vaescode.contactos.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vaescode.contactos.model.Contacto;

public interface AgendaJpaSpring extends JpaRepository<Contacto, Integer> {

	Contacto findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query("Delete from Contacto c Where c.email=?1")
	void eliminarPorEmail(String email);
}
