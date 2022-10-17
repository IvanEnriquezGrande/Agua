package com.itq.aguaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.itq.aguaService.business.TanqueService;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.NewTanque;
import com.itq.aguaService.dto.Tanque;
import com.itq.aguaService.dto.TanqueID;

@Endpoint
public class TanqueEndpoint {
	private static final String NAMESPACE_URI = "http://com.Agua";
	@Autowired TanqueService tanqueService;
	
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "newTanque")
	@ResponsePayload
	public Ack tanqueRegistration(@RequestPayload NewTanque request) {
		Ack response = tanqueService.insertTanque(request);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "tanqueID")
	@ResponsePayload
	public Tanque tanqueRead(@RequestPayload TanqueID request) {
		Tanque response = tanqueService.readTanque(request);
		if(response == null) {
			return new Tanque();
		}
		return response;
	}
	
}
