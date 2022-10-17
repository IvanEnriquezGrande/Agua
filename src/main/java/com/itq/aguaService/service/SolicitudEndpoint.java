package com.itq.aguaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.itq.aguaService.business.SolicitudService;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.NewCliente;
import com.itq.aguaService.dto.NewSolicitud;
import com.itq.aguaService.dto.Solicitud;
import com.itq.aguaService.dto.SolicitudID;

@Endpoint
public class SolicitudEndpoint {
	@Autowired SolicitudService solicitudService;
	
	private static final String NAMESPACE_URI = "http://com.Agua";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "newSolicitud")
	@ResponsePayload
	public Ack Solicitudregistration(@RequestPayload NewSolicitud request) {
		Ack response = solicitudService.insertSolicitud(request);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "solicitudID")
	@ResponsePayload
	public Solicitud SolicitudRead(@RequestPayload SolicitudID request) {
		Solicitud response = solicitudService.readSolicitud(request);
		if(response == null) {
			return new Solicitud();
		}
		return response;
	}
}
