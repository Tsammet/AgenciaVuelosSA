package com.agencia.reserva.infraestructure.in;

import java.util.Scanner;

import com.agencia.reserva.application.CancelReservaClienteUseCase;
import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.application.DeleteReservaAgenteUseCase;
import com.agencia.reserva.application.FindReservaAgenteUseCase;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.application.PagarValorReservaUseCase;

public class ReservaController {
    private final CreateReservaAgenteUseCase createReservaAgenteUseCase;
    private final FindReservaAgenteUseCase findReservaAgenteUseCase;
    private final DeleteReservaAgenteUseCase deleteReservaAgenteUseCase;
    private final CancelReservaClienteUseCase cancelReservaClienteUseCase;
   

    public ReservaController(CreateReservaAgenteUseCase createReservaAgenteUseCase,
            FindReservaAgenteUseCase findReservaAgenteUseCase, DeleteReservaAgenteUseCase deleteReservaAgenteUseCase,
            CancelReservaClienteUseCase cancelReservaClienteUseCase) {
        this.createReservaAgenteUseCase = createReservaAgenteUseCase;
        this.findReservaAgenteUseCase = findReservaAgenteUseCase;
        this.deleteReservaAgenteUseCase = deleteReservaAgenteUseCase;
        this.cancelReservaClienteUseCase = cancelReservaClienteUseCase;
      

    }

    Scanner scanner = new Scanner(System.in);

    public void gestionReservaCliente() {
        while (true) {
            System.out.println("1. Consultar reserva");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Salir");
            

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findReservaAgente();
                    break;

                case 2:
                    cancelarReserva();
                    break;
            
                case 3:
                    return;

                default:
                    System.out.println("opción no valida");
                    break;
            }

        }
    }

    public void gestionReservaAgenteVentas(){

        while (true) {
            System.out.println("1. Crear Reserva");
            System.out.println("2. Eliminar reserva");
            System.out.println("3. Consultar reserva");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    createReserva();

                    break;
                
                case 2:

                    deleteReservaAgente();

                    break;


                case 3:

                    findReservaAgente();

                    break;

                case 4:

                    return;

                default:
                    System.out.println("opción no valida");
                    break;
            }

        }

    }

    public void createReserva() {
        System.out.println("ingrese la fecha de la reserva (AAAA-MM-DD)");
        String fechaInput = scanner.nextLine();

        System.out.println("Ingrese el ID del vuelo: ");
        int idVueloReservaAgente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID del cliente");
        int idClienteReservaAgente = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el ID de la tarifa");
        int idTarifa = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = new Reserva();
        reserva.setFechaReserva(fechaInput);
        reserva.setIdVuelo(idVueloReservaAgente);
        reserva.setIdCliente(idClienteReservaAgente);
        reserva.setIdtarifa(idTarifa);
        createReservaAgenteUseCase.execute(reserva);
        System.out.println("Reserva creada exitosamente. ");

    }

    public void findReservaAgente() {

        System.out.println("Ingrese ID de la reserva: ");
        int idReservaAgente = scanner.nextInt();
        scanner.nextLine();

        Reserva reserva = findReservaAgenteUseCase.execute(idReservaAgente);
        
        if (reserva != null) {
            System.out.println("Id Reserva: " + reserva.getId());
            System.out.println("Fecha: " + reserva.getFechaReserva());
            System.out.println("Aeropuerto Origen: " + reserva.getAeropuertoOrigen());
            System.out.println("Aeropuerto Destino: " + reserva.getAeropuertoDestino());
            System.out.println("Nombre Cliente: " + reserva.getNombreCliente());
            System.out.println("Precio Vuelo: " + reserva.getPrecio());
            System.out.println("Estado Reserva: " + reserva.getEstado());

        } else {
            System.out.println("Reserva no encontrada");
        }

    }

    public void deleteReservaAgente() {
        System.out.println("Ingrese ID de la reserva a eliminar");
        int idReservaAgente = scanner.nextInt();
        scanner.nextLine();

        Reserva elimina = new Reserva();
        elimina.setId(idReservaAgente);
        deleteReservaAgenteUseCase.execute(elimina);
        System.out.println("Reserva eliminada con éxito");

    }

    public void cancelarReserva() {
        System.out.println("ingrese ID de la reserva que desea cancelar: ");
        int idReservaAgente = scanner.nextInt();
        scanner.nextLine();
        // Reserva cancela = new Reserva();
        Reserva reserva = findReservaAgenteUseCase.execute(idReservaAgente);
        if (reserva != null) {
            System.out.println("Detalles de la Reserva:");
            System.out.println("ID Reserva: " + reserva.getId());
            System.out.println("Fecha: " + reserva.getFechaReserva());
            System.out.println("Aeropuerto Origen: " + reserva.getAeropuertoOrigen());
            System.out.println("Aeropuerto Destino: " + reserva.getAeropuertoDestino());
            System.out.println("Nombre Cliente: " + reserva.getNombreCliente());
            System.out.println("Precio Vuelo: " + reserva.getPrecio());
            System.out.println("Estado Reserva: " + reserva.getEstado());
            System.out.println("¿Está seguro de que desea cancelar esta reserva? (S/N)");
            String confirmacion = scanner.nextLine();
            if (confirmacion.equalsIgnoreCase("S")) {
                cancelReservaClienteUseCase.execute(reserva);
            } else {
                System.out.println("Cancelación de la reserva abortada.");
            }
        } else {
            System.out.println("Reserva no encontrada.");
        }

    }
    
}