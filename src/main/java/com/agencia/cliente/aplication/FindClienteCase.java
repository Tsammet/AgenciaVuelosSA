package com.agencia.cliente.aplication;

import java.sql.SQLException;

import com.agencia.cliente.domain.entity.Cliente;
import com.agencia.cliente.domain.service.ClienteService;

public class FindClienteCase {
    private final ClienteService clienteService;

    public FindClienteCase(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public Cliente execute(int iddocumento) throws SQLException{
        return clienteService.findCliente(iddocumento);
    }
    
}
