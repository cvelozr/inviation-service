package com.wolff.invitation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wolff.invitation.model.Invitacion;
import com.wolff.invitation.service.InvitationService;

@RestController
@RequestMapping("/api/inv")
@CrossOrigin(origins = "*")
public class InvitationController {

	@Autowired
	private InvitationService service;

	@GetMapping("/validar")
	public Object validar(@RequestParam String id) {
		return service.validarInvitacion(id).map(inv -> Map.of("valida", true, "nombre", inv.getNombre(), "personas",
				inv.getPersonas(), "checkin", inv.isCheckin(),"mesa", inv.getMesa())).orElse(Map.of("valida", false));
	}

	@PostMapping("/checkin")
	public Map<String, Object> checkin(@RequestBody Map<String, String> body) {
		boolean exito = service.hacerCheckin(body.get("id"));
		return Map.of("exito", exito);
	}

	@GetMapping("/todos")
	public List<Invitacion> todos() {
		return service.obtenerTodas();
	}

	@PostMapping("/agregar")
	public Map<String, Object> agregar(@RequestBody List<Invitacion> lista) {
		service.agregarInvitaciones(lista);
		return Map.of("agregados", lista.size());
	}
	
	@DeleteMapping("/borrar-todo")
	public Map<String, Object> borrarTodo() {
		service.deleteAll();
	    return Map.of("estado", "todos eliminados");
	}
}
