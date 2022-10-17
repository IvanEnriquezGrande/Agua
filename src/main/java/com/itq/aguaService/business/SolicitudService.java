package com.itq.aguaService.business;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.NewSolicitud;
import com.itq.aguaService.dto.Solicitud;
import com.itq.aguaService.dto.SolicitudID;

@Component
public class SolicitudService {
	private static ArrayList<Solicitud> solicitudes = new ArrayList<>();
	private static int cont = 0;

	public Ack insertSolicitud(NewSolicitud solicitud) {
		Ack ack = new Ack();
		System.out.println("solicitud recibida: " + solicitud.getIdCliente() + ", Litros" + solicitud.getLitros());
		Solicitud s = new Solicitud();

		s.setIdSolicitud(cont);
		s.setIdCliente(solicitud.getIdCliente());
		s.setIdTanque(1);
		s.setLitros(solicitud.getLitros());
		s.setFecha(solicitud.getFecha());
		solicitudes.add(s);
		cont++;

		ack.setDescription("solicitud recibida: " + solicitud.getIdCliente() + ", Litros" + solicitud.getLitros());
		ack.setCode(0);
		return ack;
	}

	public Solicitud readSolicitud(SolicitudID solicitudID) {
		Solicitud solicitud = new Solicitud();
		solicitud = buscarSolicitud(solicitudID.getIdConsulta());
		if(solicitud == null) {
			System.out.println("La solicitud no existe");
			return null;
		}
		System.out.println("Solicitud encontrada: id, " + solicitud.getIdSolicitud() + ", cliente: " + solicitud.getIdCliente());
		return solicitud;
	}

	private Solicitud buscarSolicitud(int id) {
		for (Solicitud s : solicitudes) {
			if (s.getIdSolicitud() == id) {
				return s;
			}
		}
		return null;
	}
}
