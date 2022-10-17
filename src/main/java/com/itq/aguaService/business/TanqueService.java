package com.itq.aguaService.business;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.itq.aguaService.dto.Ack;

import com.itq.aguaService.dto.NewTanque;
import com.itq.aguaService.dto.Tanque;
import com.itq.aguaService.dto.TanqueID;

@Component
public class TanqueService {
	private static ArrayList<Tanque> tanques = new ArrayList<>();
	private static int cont = 0;
	
	public Ack insertTanque(NewTanque tanque) {
		Ack ack = new Ack();
		System.out.println("Tanque recibido, capacidad: " + tanque.getCapacidad());
		Tanque t = new Tanque();
		t.setCapacidad(tanque.getCapacidad());
		t.setIdTanque(cont);
		t.setTiempoLlenado(tanque.getTiempoLlenado());
		t.setZona(tanque.getZona());
		cont++;
		tanques.add(t);
		
		ack.setCode(0);
		ack.setDescription("Tanque recibido, capacidad: " + tanque.getCapacidad());
		return ack;
	}
	
	public Tanque readTanque(TanqueID tanque) {
		Tanque t = new Tanque();
		t = buscarTanque(tanque.getIdTanque());
		if(t == null) {
			System.out.println("El tanque no existe");
			return null;
		}
		System.out.println("Tanque encontrado, id: " + t.getIdTanque()+ ", capacidad:" + t.getCapacidad());
		return t;
	}
	
	private Tanque buscarTanque(int id) {
		for(Tanque t : tanques) {
			if(t.getIdTanque() == id) {
				return t;
			}
		}
		return null;
	}
}
