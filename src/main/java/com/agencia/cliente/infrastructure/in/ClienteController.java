
package com.agencia.cliente.infrastructure.in;

import java.util.Scanner;

import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.entity.Cliente;

public class ClienteController {
    private final CreateClienteCase createClienteCase;
    private final FindClienteCase findClienteCase;
    private final DeleteClienteCase deleteClienteCase;
    private final UpdateClienteCase updateClienteCase;

    public ClienteController(CreateClienteCase createClienteCase,
            FindClienteCase findClienteCase, DeleteClienteCase deleteClienteCase,
            UpdateClienteCase updateClienteCase) {
        this.createClienteCase = createClienteCase;
        this.findClienteCase = findClienteCase;
        this.deleteClienteCase = deleteClienteCase;
        this.updateClienteCase = updateClienteCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionCliente() {
        while (true) {
            System.out.println("1. Crear Cliente: ");
            System.out.println("2. Borrar Cliente: ");
            System.out.println("3. Encontrar Cliente: ");
            System.out.println("4. Actualizar Cliente: ");
            System.out.println("5. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createCliente();

                    break;

                case 2:

                    deleteCliente();

                    break;

                case 3:

                    findCliente();

                    break;

                case 4:

                    updateCliente();

                    break;

                default:
                    break;
            }
        }
    }

    public void createCliente() {
        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad del cliente:");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ingrese el ID del tipo de documento:");
        int idTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el número de documento:");
        String numeroDocumento = scanner.nextLine();

        System.out.println("Ingrese el ID del rol: ");
        int idRol = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setIdtipodocumento(idTipoDocumento);
        cliente.setNumerodocumento(numeroDocumento);
        cliente.setRol(idRol);

        createClienteCase.execute(cliente);
        System.out.println("Cliente creado correctamente. ");
    }

    public void updateCliente() {

        System.out.println("Ingrese el id para actualizar el cliente: ");
        int idClienteUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del cliente:");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese la nueva edad del cliente:");
        int nuevaEdad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("ingrese el nuevo ID del tipo de documento:");
        int nuevoidTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo número de documento:");
        String nuevoNumeroDocumento = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID del rol: ");
        int nuevoIdRol = scanner.nextInt();
        scanner.nextLine();

        Cliente newCliente = new Cliente();

        newCliente.setId(idClienteUpdate);
        newCliente.setNombre(nuevoNombre);
        newCliente.setEdad(nuevaEdad);
        newCliente.setIdtipodocumento(nuevoidTipoDocumento);
        newCliente.setNumerodocumento(nuevoNumeroDocumento);
        newCliente.setRol(nuevoIdRol);

        updateClienteCase.execute(newCliente);
        System.out.println("Cliente actualizado correctamente!");
    }

    public void findCliente() {

        System.out.println("Ingrese el ID del cliente a buscar:");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente foundCliente = findClienteCase.execute(idCliente);

        if (foundCliente != null) {
            System.out.println("Id: " + foundCliente.getId());
            System.out.println("Nombre: " + foundCliente.getNombre());
            System.out.println("Edad: " + foundCliente.getEdad());
            System.out.println("ID Tipo Documento: " + foundCliente.getIdtipodocumento());
            System.out.println("Número Documento: " + foundCliente.getNumerodocumento());
            System.out.println("Rol: " + foundCliente.getRol());
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void deleteCliente() {
        System.out.println("Ingrese el ID del cliente a eliminar:");
        int deleteCliente = scanner.nextInt();
        scanner.nextLine();

        deleteClienteCase.execute(deleteCliente);

        if (deleteClienteCase != null) {
            System.out.println("Cliente eliminado");
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
