package com.itq.aguaService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.itq.aguaService.business.ClienteService;
import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Cliente;
import com.itq.aguaService.dto.ClienteId;
import com.itq.aguaService.dto.NewCliente;

@Endpoint
public class ClientesEndpoint {
	@Autowired ClienteService clienteService;
	
	private static final String NAMESPACE_URI = "http://com.Agua";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "newCliente")
	@ResponsePayload
	public Ack clienteRegistration(@RequestPayload NewCliente request) {
		Ack response = clienteService.insertCliente(request); 
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "clienteId")
	@ResponsePayload
	public Cliente clienteRead(@RequestPayload ClienteId request) {
		Cliente response = clienteService.readCliente(request);
		if(response == null) {
			return new Cliente();
		}
		return response;
	}

}
