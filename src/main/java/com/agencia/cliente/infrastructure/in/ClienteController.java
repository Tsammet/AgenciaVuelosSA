package com.agencia.cliente.infrastructure.in;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.entity.Cliente;
import com.agencia.cliente.domain.service.ClienteService;

public class ClienteController {
    private ClienteService clienteService;
    private CreateClienteCase createClienteCase;
    private FindClienteCase findClienteCase;
    private DeleteClienteCase deleteClienteCase;
    private UpdateClienteCase updateClienteCase;

    public ClienteController(ClienteService clienteService, CreateClienteCase createClienteCase, 
                             FindClienteCase findClienteCase, DeleteClienteCase deleteClienteCase, 
                             UpdateClienteCase updateClienteCase) {
        this.clienteService = clienteService;
        this.createClienteCase = createClienteCase;
        this.findClienteCase = findClienteCase;
        this.deleteClienteCase = deleteClienteCase;
        this.updateClienteCase = updateClienteCase;
    }

    public void crear() throws SQLException {
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));
        int idtipodocumento = Integer.parseInt(JOptionPane.showInputDialog("ID del tipo de documento:"));
        String numerodocumento = JOptionPane.showInputDialog("Número de documento:");
        int rol = Integer.parseInt(JOptionPane.showInputDialog("Rol:"));

        Cliente cliente = new Cliente(rol, numerodocumento, rol, rol, numerodocumento, rol);
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setIdtipodocumento(idtipodocumento);
        cliente.setNumerodocumento(numerodocumento);
        cliente.setRol(rol);

        clienteService.createCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente creado correctamente!");
    }

    public void actualizar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a actualizar:"));
        String nombre = JOptionPane.showInputDialog("Nombre del cliente:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del cliente:"));
        int idtipodocumento = Integer.parseInt(JOptionPane.showInputDialog("ID del tipo de documento:"));
        String numerodocumento = JOptionPane.showInputDialog("Número de documento:");
        int rol = Integer.parseInt(JOptionPane.showInputDialog("Rol:"));

        Cliente cliente = new Cliente(rol, numerodocumento, rol, rol, numerodocumento, rol);
        cliente.setId(id);
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setIdtipodocumento(idtipodocumento);
        cliente.setNumerodocumento(numerodocumento);
        cliente.setRol(rol);

        clienteService.updateCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente!");
    }

    public void buscar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a buscar:"));
        Cliente cliente = clienteService.findCliente(id);

        if (cliente != null) {
            System.out.println("Id: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Edad: " + cliente.getEdad());
            System.out.println("ID Tipo Documento: " + cliente.getIdtipodocumento());
            System.out.println("Número Documento: " + cliente.getNumerodocumento());
            System.out.println("Rol: " + cliente.getRol());
            System.out.println("Tipo Documento: "+cliente.getTipodocumento());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado!");
        }
    }

    public void eliminar() throws SQLException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente a eliminar:"));
        clienteService.deleteCliente(id);
        JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente!");
    }
}
