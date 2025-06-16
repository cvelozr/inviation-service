package com.wolff.invitation.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Invitacion {
	 @Id
	    private String id;
	    private String nombre;
	    private int personas;
	    private int mesa;
	    private boolean checkin;
	    private LocalDateTime horaLlegada;

	    public Invitacion() {}

	    public Invitacion(String id, String nombre, int personas) {
	        this.id = id;
	        this.nombre = nombre;
	        this.personas = personas;
	        this.checkin = false;
	        this.horaLlegada = null;
	    }

	    // Getters y Setters

	    public String getId() { return id; }
	    public void setId(String id) { this.id = id; }

	    public String getNombre() { return nombre; }
	    public void setNombre(String nombre) { this.nombre = nombre; }

	    public int getPersonas() { return personas; }
	    public void setPersonas(int personas) { this.personas = personas; }

	    public boolean isCheckin() { return checkin; }
	    public void setCheckin(boolean checkin) { this.checkin = checkin; }

	    public LocalDateTime getHoraLlegada() { return horaLlegada; }
	    public void setHoraLlegada(LocalDateTime horaLlegada) { this.horaLlegada = horaLlegada; }

		public int getMesa() {
			return mesa;
		}

		public void setMesa(int mesa) {
			this.mesa = mesa;
		}

}
