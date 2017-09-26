package edu.uclm.esi.iso2.multas.radar;

import java.util.ArrayList;

import edu.uclm.esi.iso2.multas.domain.Inquiry;

public class Radar {
	
	private boolean encendido;
	private Carretera tipoCarretera;
	
	private final int[] VELOCIDADES = {30, 40, 60, 70, 80, 90, 100, 110, 120};
	
	public Radar(Carretera tipoCarretera) {
		encendido = true;
		this.tipoCarretera = tipoCarretera;
	}
	
	
	public Carretera getTipoCarretera() {
		return tipoCarretera;
	}


	public void setTipoCarretera(Carretera tipoCarretera) {
		this.tipoCarretera = tipoCarretera;
	}


	public void apagarRadar() {
		encendido = false;
	}
	
	public void encenderRadar() {
		encendido = true;
	}
	
	public ArrayList<Inquiry> generarInfracciones() {
		ArrayList<Inquiry> listaInfracciones = new ArrayList<Inquiry>();
		Inquiry aux;
		
		// Si está apagado no hace nada
		if (!encendido) return listaInfracciones;
		
		int numGenerados = 1 + (int) (Math.random() * 50);
		
		for (int i = 0; i < numGenerados; i++) {
			String id;
			int velocidad;
			int velocidadMax;
			
			id = new String();
			id += String.valueOf((int) (Math.random() * 2));
			id += String.valueOf((int) (Math.random() * 9));
			id += String.valueOf((int) (Math.random() * 9));
			id += String.valueOf((int) (Math.random() * 9));
			
			if (tipoCarretera == Carretera.URBANA) {
				velocidad = 15 + (int) (Math.random() * 55);
			} else if (tipoCarretera == Carretera.NACIONAL) {
				velocidad = 60 + (int) (Math.random() * 70);
			} else {
				velocidad = 80 + (int) (Math.random() * 80);
			}
			
			if (tipoCarretera == Carretera.URBANA) {
				velocidadMax = VELOCIDADES[(int) (Math.random())];
			} else if (tipoCarretera == Carretera.NACIONAL) {
				velocidadMax = VELOCIDADES[2 + (int) (Math.random() * 5)];
			} else {
				velocidadMax = VELOCIDADES[8];
			}
			
			if (esInfraccion(velocidad)) {
				//listaInfracciones.add(new Inquiry(id, velocidad, tipoCarretera.name(), velocidadMax));
				aux = new Inquiry(id, velocidad, tipoCarretera.name(), velocidadMax);
				listaInfracciones.add(aux);
				aux.createSanctionFor(aux.getOwner().getDni());
			}
		}
		
		return listaInfracciones;
	}
	
	private boolean esInfraccion(int velocidad) {
		if (tipoCarretera == Carretera.URBANA) {
			if (velocidad > 50) return true;
		} else if (tipoCarretera == Carretera.NACIONAL) {
			if (velocidad > 100) return true;
		} else {
			if (velocidad > 120) return true;
		}
		return false;
	}
}
