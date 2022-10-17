package com.itq.aguaService.business;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.itq.aguaService.dto.Ack;
import com.itq.aguaService.dto.Cliente;
import com.itq.aguaService.dto.ClienteId;
import com.itq.aguaService.dto.NewCliente;

@Component
public class ClienteService {
	private static ArrayList<Cliente> clientes = new ArrayList<>();
	private static int cont = 0;
	
	public Ack insertCliente(NewCliente cliente) {
		Ack ack = new Ack();
		System.out.println("Cliente recibido: '" + cliente.getNombres() + "'");
		
		Cliente c = new Cliente();
		c.setIdCliente(cont);
		c.setNombres(cliente.getNombres());
		c.setPrimerApellido(cliente.getPrimerApellido());
		c.setSegundoApellido(cliente.getSegundoApellido());
		c.setZona(cliente.getZona());
		clientes.add(c);
		ClienteService.cont++;
		
		ack.setDescription(c.getNombres() + " " + c.getPrimerApellido() + " registrado, id: " + c.getIdCliente());
		ack.setCode(0);
		return ack;
	}
	
	public Cliente readCliente(ClienteId clienteID) {
		Cliente cliente = new Cliente();
		cliente = buscarCliente(clienteID.getIdCliente());
		if(cliente == null) {
			System.out.println("El cliente no existe");
			return null;
		}
		System.out.println("Cliente encontrado " + cliente.getIdCliente() + " " + cliente.getNombres());
		return cliente;
	}
	
	private Cliente buscarCliente(int id) {
		for(Cliente c : clientes) {
			if(c.getIdCliente() == id) {
				return c;
			}
		}
		return null;
	}
}
