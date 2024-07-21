package com.agencia.cliente.aplication;

import java.sql.SQLException;

import com.agencia.cliente.domain.service.ClienteService;

public class DeleteClienteCase {
    private final ClienteService clienteService;

    public DeleteClienteCase(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void execute(int id) throws SQLException{
        clienteService.deleteCliente(id);
    }
}
