package com.agencia.vuelo.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.agencia.asientos.domain.entity.Asiento;
import com.agencia.asientos.domain.entity.AsientoDetalle;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;
import com.agencia.reserva.domain.entity.Reserva;
import com.agencia.vuelo.application.AddPasajeroUseCase;
import com.agencia.vuelo.application.AsignarAsientoUseCase;
import com.agencia.vuelo.application.MostrarAsientoUseCase;
import com.agencia.vuelo.application.PagarValorReservaUseCase;
import com.agencia.vuelo.application.CreateReservaxClienteUseCase;
import com.agencia.vuelo.application.FindvueloUseCase;
import com.agencia.vuelo.application.SearchVueloxCiudadUseCase;
import com.agencia.vuelo.domain.entity.DetalleReserva;
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
    private final FindEscalaUseCase findEscalaUseCase;
    private final PagarValorReservaUseCase pagarValorReservaUseCase;

    public vueloController(FindvueloUseCase findvueloUseCase, SearchVueloxCiudadUseCase searchVueloxCiudadUseCase, CreateReservaxClienteUseCase createReservaxClienteUseCase, AddPasajeroUseCase addPasajeroUseCase,
    MostrarAsientoUseCase mostrarAsientoUseCase, AsignarAsientoUseCase asignarAsientoUseCase, FindEscalaUseCase findEscalaUseCase,
    PagarValorReservaUseCase pagarValorReservaUseCase) {
        this.findvueloUseCase = findvueloUseCase;
        this.searchVueloxCiudadUseCase = searchVueloxCiudadUseCase;
        this.createReservaxClienteUseCase = createReservaxClienteUseCase;
        this.addPasajeroUseCase = addPasajeroUseCase;
        this.mostrarAsientoUseCase = mostrarAsientoUseCase;
        this.asignarAsientoUseCase = asignarAsientoUseCase;
        this.findEscalaUseCase = findEscalaUseCase;
        this.pagarValorReservaUseCase = pagarValorReservaUseCase;
       }



    Scanner scanner = new Scanner(System.in);

    public void gestionVueloCliente(){

        while (true) {
            System.out.println("1. Consultar Vuelo: ");
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

    public void gestionVueloAdminAgente(){

        while (true) {
            System.out.println("1. Consultar Vuelo: ");
            System.out.println("2. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findVuelo();
                    
                    break;
            
                case 2: 

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
            System.out.println("----------------------------------");
            System.out.println("Id vuelo: " + vuelo.getId());
            System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
            System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
            System.out.println("id origen viaje: " + vuelo.getIdorigen());
            System.out.println("id destino viaje: " + vuelo.getIddestino());
            System.out.println("----------------------------------");
        }else{
            System.out.println("Vuelo no encontrado");
        }

    }

    public void searchVueloxCiudad(){
        System.out.println("Ingrese el ID de la ciudad de origen: ");
        String ciudadOrigen = scanner.nextLine();

        System.out.println("Ingrese el ID de la ciudad de destino: ");
        String ciudadDestino = scanner.nextLine();

        System.out.println("Ingrese la fecha del vuelo: ");
        String fechaviaje = scanner.nextLine();


        List<Vuelos> vuelos = new ArrayList<>();
        vuelos = searchVueloxCiudadUseCase.execute(ciudadOrigen, ciudadDestino, fechaviaje);

        if (!vuelos.isEmpty()) {
            System.out.println("-------------------------------------------");
            System.out.println("Estos son los vuelos disponibles: ");

            for (Vuelos vuelo : vuelos ) {
                System.out.println("-------------------");
                System.out.println("Id vuelo: " + vuelo.getId());
                System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
                System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
                System.out.println("id origen viaje: " + vuelo.getIdorigen());
                System.out.println("id destino viaje: " + vuelo.getIddestino());
                System.out.println("-------------------");
            }
            
        }else{
            System.out.println("Vuelo no encontrado");
        }

        System.out.println("Digite el id del vuelo que desea seleccionar : ");
        int idViajeEscoger = scanner.nextInt();
        scanner.nextLine();
        Vuelos vuelo = findvueloUseCase.execute(idViajeEscoger);

        if (vuelo != null) {
            System.out.println("Usted ha seleccionado el siguiente vuelo: ");
            System.out.println("Id vuelo: " + vuelo.getId());
            System.out.println("Fecha de viaje: " + vuelo.getFechaviaje());
            System.out.println("Precio  viaje: " + vuelo.getPrecioviaje());
            System.out.println("id origen viaje: " + vuelo.getIdorigen());
            System.out.println("id destino viaje: " + vuelo.getIddestino());
        }else{
            System.out.println("Vuelo no encontrado");
        }
        System.out.println("-------------------------------------------------------");
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
            System.out.println("Reserva realizada satisfactoriamente.");

            this.lastReservaId = reserva.getId();
            
        }else{
            System.out.println("Adios");
        }


        System.out.println("Desea agregar un pasajero? (Si / No)");
        String agregarPasajero = scanner.nextLine().trim().toLowerCase();
        
        while (agregarPasajero.equals("si")) {
            
            System.out.println("Digite el ID del pasajero: ");
            int idPasajero = scanner.nextInt();
            scanner.nextLine();

            DetalleReserva detalleReserva = new DetalleReserva();

            System.out.println("Digite el ID de la tarifa: ");
            int idTarifa = scanner.nextInt();
            scanner.nextLine();

            detalleReserva.setIdReserva(this.lastReservaId);
            detalleReserva.setIdPasajero(idPasajero);
            detalleReserva.setIdTarifa(idTarifa);

            addPasajeroUseCase.execute(detalleReserva);

            this.lastDetalleReservaId = detalleReserva.getId();

            System.out.println("Pasajero agregado");

            //  FUNCION DE "SELECCIONAR ASIENTOS"

            List<Escala> escalas= new ArrayList<>();
            escalas = findEscalaUseCase.execute(idViajeEscoger); // Asumiendo que devuelve una lista de escalas

            if (!escalas.isEmpty()) {
                System.out.println(escalas);

                System.out.println("Las escalas de este vuelo son las siguientes: ");
                System.out.println("-----------------------------------------------------");

                for (Escala escala : escalas) {
                    System.out.println("Escala id: " + escala.getId());
                    System.out.println("Número de conexión: " + escala.getNumeroConexion());
                    System.out.println("Id trayecto: " + escala.getIdViaje());
                    System.out.println("Id Avión: " + escala.getIdAvion());
                    System.out.println("Id aeropuerto origen: " + escala.getIdAeropuertoOrigen());
                    System.out.println("Id aeropuerto destino: " + escala.getIdAeropuertoDestino());
                    System.out.println("------------"); 
                }
            } else {
                System.out.println("No se encontraron escalas para el id de viaje proporcionado.");
            }

            System.out.println("Digite el ID de la escala para la cual desea seleccionar asiento: ");
            int escalaSeleccionada = scanner.nextInt();
            scanner.nextLine();

            List<Asiento> asiento = mostrarAsientoUseCase.execute(idViajeEscoger);
            System.out.println("----------------------------------");
            System.out.println("Asientos disponibles:");

            for (Asiento asientos : asiento) {
                System.out.println("ID: " + asientos.getId() + ", Numero Asiento: " + asientos.getNumeroAsiento());
            }

            System.out.println("Selecciona el ID de asiento deseas elegir: ");
            int asientoElegir = scanner.nextInt();
            scanner.nextLine();

            AsientoDetalle asientoDetalle = new AsientoDetalle();
            asientoDetalle.setIdAsientos(asientoElegir);

            asientoDetalle.setIdConexion(escalaSeleccionada);

            asientoDetalle.setIdDetalleReserva(this.lastDetalleReservaId);

            asignarAsientoUseCase.execute(asientoDetalle);

            System.out.println("Asiento asignado correctamente. ");


            System.out.println("Desea agregar otro pasajero? (Si / No)");
            agregarPasajero = scanner.nextLine().trim().toLowerCase();

        }

        System.out.println("Ingrese el método de pago que va a utilizar(TD=Tarjeta Debito / TC=Tarjeta Credito): ");
        String metodoPago = scanner.nextLine().trim().toLowerCase();

        System.out.println("Ingrese el número de la tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.println("Ingrese el código de confirmacion CVC: ");
        String codigoPago = scanner.nextLine();

        System.out.println("Pago registrado exitosamente. ");


        Reserva pagoReserva = new Reserva();

        pagoReserva.setId(lastReservaId);
        pagoReserva.setMetodoPago(metodoPago);

        pagarValorReservaUseCase.execute(pagoReserva);



    }

}
