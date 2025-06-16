package com.wolff.invitation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolff.invitation.config.IDGenerator;
import com.wolff.invitation.model.Invitacion;
import com.wolff.invitation.repository.InvitacionRepository;

@Service
public class InvitationService {

	@Autowired
	private InvitacionRepository repository;

	public Optional<Invitacion> validarInvitacion(String id) {
		return repository.findById(id);
	}

	public boolean hacerCheckin(String id) {
		Optional<Invitacion> opt = repository.findById(id);
		if (opt.isPresent()) {
			Invitacion inv = opt.get();
			if (inv.isCheckin())
				return false;

			inv.setCheckin(true);
			inv.setHoraLlegada(LocalDateTime.now());
			repository.save(inv);
			return true;
		}
		return false;
	}

	public List<Invitacion> obtenerTodas() {
		return repository.findAll();
	}

	public void agregarInvitaciones(List<Invitacion> lista) {
	    for (Invitacion inv : lista) {
	        if (inv.getId() == null || inv.getId().isBlank()) {
	            inv.setId(IDGenerator.generarID());
	        }
	    }
		repository.saveAll(lista);
	}

	public void deleteAll() {
		repository.deleteAll();
	}
}
