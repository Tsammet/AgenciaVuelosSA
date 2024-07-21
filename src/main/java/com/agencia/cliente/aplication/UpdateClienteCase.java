package com.agencia.cliente.aplication;

import java.sql.SQLException;

import com.agencia.cliente.domain.entity.Cliente;
import com.agencia.cliente.domain.service.ClienteService;

public class UpdateClienteCase {
    private final ClienteService clienteService;

    public UpdateClienteCase(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    public void execute(Cliente cliente) throws SQLException{
        clienteService.updateCliente(cliente);
    }
}
