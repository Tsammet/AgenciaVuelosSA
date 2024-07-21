package com.agencia.cliente.domain.service;

import java.sql.SQLException;

import com.agencia.cliente.domain.entity.Cliente;

public interface ClienteService {
    void createCliente(Cliente cliente) throws SQLException;
    void updateCliente(Cliente cliente) throws SQLException;
    Cliente findCliente(int id) throws SQLException;
    void deleteCliente(int id) throws SQLException;
}
