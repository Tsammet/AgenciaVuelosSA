
package com.agencia.cliente.domain.service;

import com.agencia.cliente.domain.entity.Cliente;

public interface ClienteService {
    void createCliente(Cliente cliente);

    void updateCliente(Cliente cliente);

    Cliente findCliente(int id);

    void deleteCliente(int id);
}
