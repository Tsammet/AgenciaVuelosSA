package com.agencia.vuelo.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.agencia.asientos.domain.entity.Asiento;
import com.agencia.asientos.domain.entity.AsientoDetalle;
import com.agencia.reserva.domain.entity.DetalleReserva;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.application.AddPasajeroUseCase;
import com.agencia.vuelo.application.AsignarAsientoUseCase;
import com.agencia.vuelo.application.MostrarAsientoUseCase;
import com.agencia.vuelo.application.CreateReservaxClienteUseCase;
import com.agencia.vuelo.application.FindvueloUseCase;
import com.agencia.vuelo.application.SearchVueloxCiudadUseCase;
import com.agencia.vuelo.domain.entity.Vuelos;

public class vueloController {
    private int lastReservaId; 
    private int lastDetalleReservaId;

    private final FindvueloUseCase findvueloUseCase;
    private final SearchVueloxCiudadUseCase searchVueloxCiudadUseCase;
    private final CreateReservaxClienteUseCase createReservaxClienteUseCase;
    private final AddPasajeroUseCase addPasajeroUseCase;
    private final MostrarAsientoUseCase mostrarAsientoUseCase;
    private final AsignarAsientoUseCase asignarAsientoUseCase;

    public vueloController(FindvueloUseCase findvueloUseCase, SearchVueloxCiudadUseCase searchVueloxCiudadUseCase, CreateReservaxClienteUseCase createReservaxClienteUseCase, AddPasajeroUseCase addPasajeroUseCase,
    MostrarAsientoUseCase mostrarAsientoUseCase, AsignarAsientoUseCase asignarAsientoUseCase) {
        this.findvueloUseCase = findvueloUseCase;
        this.searchVueloxCiudadUseCase = searchVueloxCiudadUseCase;
        this.createReservaxClienteUseCase = createReservaxClienteUseCase;
        this.addPasajeroUseCase = addPasajeroUseCase;
        this.mostrarAsientoUseCase = mostrarAsientoUseCase;
        this.asignarAsientoUseCase = asignarAsientoUseCase;
       }



    Scanner scanner = new Scanner(System.in);

    public void gestionVuelo(){

        while (true) {
            System.out.println("1.Encontrar Vuelo: ");
            System.out.println("2. Buscar Vuelo");
            System.out.println("3. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findVuelo();
                    
                    break;
            
                case 2:

                    searchVueloxCiudad();
                    break;

                case 3: 

                    return;
                
                default:
                    break;
            }
        }
    }

    public void findVuelo(){

        System.out.println("Digite el id del vuelo: ");
        int idVuelo = scanner.nextInt();
        scanner.nextLine();

        Vuelos vuelo = findvueloUseCase.execute(idVuelo);

        if (vuelo != null) {
            System.out.println("Id vuelo: " + vuelo.getId());
            System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
            System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
            System.out.println("id origen viaje: " + vuelo.getIdorigen());
            System.out.println("id destino viaje: " + vuelo.getIddestino());
        }else{
            System.out.println("Vuelo no encontrado");
        }

    }

    public void searchVueloxCiudad(){
        System.out.println("Cuál es la ciudad de origen: ");
        String ciudadOrigen = scanner.nextLine();

        System.out.println("Cuál es la ciudad de destino: ");
        String ciudadDestino = scanner.nextLine();

        List<Vuelos> vuelos = new ArrayList<>();
        vuelos = searchVueloxCiudadUseCase.execute(ciudadOrigen, ciudadDestino);

        if (!vuelos.isEmpty()) {

            for (Vuelos vuelo : vuelos ) {
                System.out.println("-------------------");
                System.out.println("Id vuelo: " + vuelo.getId());
                System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
                System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
                System.out.println("id origen viaje: " + vuelo.getIdorigen());
                System.out.println("id destino viaje: " + vuelo.getIddestino());
            }
            
        }else{
            System.out.println("Vuelo no encontrado");
        }

        System.out.println("Digite el id del viaje que deseas escoger: ");
        int idViajeEscoger = scanner.nextInt();
        scanner.nextLine();
        Vuelos vuelo = findvueloUseCase.execute(idViajeEscoger);

        if (vuelo != null) {
            System.out.println("Id vuelo: " + vuelo.getId());
            System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
            System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
            System.out.println("id origen viaje: " + vuelo.getIdorigen());
            System.out.println("id destino viaje: " + vuelo.getIddestino());
        }else{
            System.out.println("Vuelo no encontrado");
        }

        System.out.println("Deseas confirmar la selección del vuelo? (Si / No) : ");
        String eleccionReserva = scanner.nextLine().trim().toLowerCase();

        if (eleccionReserva.equals("si")) {

            Reserva reserva = new Reserva();
            reserva.setFechaReserva(vuelo.getFechaviaje());
            reserva.setIdVuelo(idViajeEscoger);
            System.out.println("Cuál es el id del cliente: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine();
            reserva.setIdCliente(idCliente);

            createReservaxClienteUseCase.execute(reserva);
            System.out.println("Reserva hecha.");

            this.lastReservaId = reserva.getId();
            
        }else{
            System.out.println("Adios");
        }

        System.out.println("Desea agregar un pasajero? (Si / No)");
        String agregarPasajero = scanner.nextLine().trim().toLowerCase();
        
        while (agregarPasajero.equals("si")) {
            
            System.out.println("Cuál es el id del pasajero: ");
            int idPasajero = scanner.nextInt();
            scanner.nextLine();

            DetalleReserva detalleReserva = new DetalleReserva();

            System.out.println("Cuál es el id de la tarifa: ");
            int idTarifa = scanner.nextInt();
            scanner.nextLine();

            detalleReserva.setIdReserva(this.lastReservaId);
            detalleReserva.setIdPasajero(idPasajero);
            detalleReserva.setIdTarifa(idTarifa);

            addPasajeroUseCase.execute(detalleReserva);

            this.lastDetalleReservaId = detalleReserva.getId();

            System.out.println("Pasajero agregado");

            List<Asiento> asiento = mostrarAsientoUseCase.execute(idViajeEscoger);
            System.out.println("Asientos disponibles:");

            for (Asiento asientos : asiento) {
                System.out.println("ID: " + asientos.getId() + ", Numero Asiento: " + asientos.getNumeroAsiento());
            }

            System.out.println("Que id de asiento deseas elegir: ");
            int asientoElegir = scanner.nextInt();
            scanner.nextLine();

            AsientoDetalle asientoDetalle = new AsientoDetalle();
            asientoDetalle.setIdAsientos(asientoElegir);

            System.out.println("Que conexión id es: ");
            int idConexion = scanner.nextInt();
            scanner.nextLine();
            asientoDetalle.setIdConexion(idConexion);

            asientoDetalle.setIdDetalleReserva(this.lastDetalleReservaId);

            asignarAsientoUseCase.execute(asientoDetalle);


            System.out.println("Desea agregar otro pasajero? (Si / No)");
            agregarPasajero = scanner.nextLine().trim().toLowerCase();
        }

    }

}
