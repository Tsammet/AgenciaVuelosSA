
import java.util.Scanner;

import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
import com.agencia.aeropuerto.infrastructure.in.AeropuertoController;
import com.agencia.aeropuerto.infrastructure.out.AeropuertoRepository;
import com.agencia.avion.application.CreateAvionUseCase;
import com.agencia.avion.application.DeleteAvionUseCase;
import com.agencia.avion.application.FindAvionUseCase;
import com.agencia.avion.application.UpdateAvionUseCase;
import com.agencia.avion.infraestructure.AvionController;
import com.agencia.avion.infraestructure.AvionRepository;
import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.infrastructure.in.ClienteController;
import com.agencia.cliente.infrastructure.out.ClienteRepository;
import com.agencia.escala.application.AsignAvionUseCase;
import com.agencia.escala.application.DeleteEscalaUseCase;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.infraestructure.EscalaController;
import com.agencia.escala.infraestructure.EscalaRepository;
import com.agencia.reserva.application.CancelReservaClienteUseCase;
import com.agencia.reserva.application.CreateReservaAgenteUseCase;
import com.agencia.reserva.application.DeleteReservaAgenteUseCase;
import com.agencia.reserva.application.FindReservaAgenteUseCase;
import com.agencia.reserva.application.PagarValorReservaUseCase;
import com.agencia.reserva.infraestructure.in.ReservaController;
import com.agencia.reserva.infraestructure.out.ReservaRepository;
import com.agencia.revision.application.CreateRevisionUseCase;
import com.agencia.revision.application.DeleteRevisionUseCase;
import com.agencia.revision.application.FindRevisionUseCase;
import com.agencia.revision.application.UpdateRevisionUseCase;
import com.agencia.revision.infraestructure.RevisionController;
import com.agencia.revision.infraestructure.RevisionRepository;
import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.infraestructure.in.TarifaController;
import com.agencia.tarifa.infraestructure.out.TarifaRepository;
import com.agencia.tipoDocumento.application.CreateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.DeleteTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.FindTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.UpdateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.infraestructure.TipoDocumentoController;
import com.agencia.tipoDocumento.infraestructure.TipoDocumentoRepository;
import com.agencia.trayecto.application.DeleteTrayectoUseCase;
import com.agencia.trayecto.application.FindTrayectoUseCase;
import com.agencia.trayecto.application.UpdateTrayectoUseCase;
import com.agencia.trayecto.infraestructure.TrayectoController;
import com.agencia.trayecto.infraestructure.TrayectoRepository;
import com.agencia.tripulacion.application.CreateTripulacionUseCase;
import com.agencia.tripulacion.application.FindTripulacionUseCase;
import com.agencia.tripulacion.infraestructure.TripulacionController;
import com.agencia.tripulacion.infraestructure.TripulacionRepository;
import com.agencia.vuelo.application.AddPasajeroUseCase;
import com.agencia.vuelo.application.AsignarAsientoUseCase;
import com.agencia.vuelo.application.CreateReservaxClienteUseCase;
import com.agencia.vuelo.application.FindvueloUseCase;
import com.agencia.vuelo.application.MostrarAsientoUseCase;
import com.agencia.vuelo.application.SearchVueloxCiudadUseCase;
import com.agencia.vuelo.infraestructure.vueloController;
import com.agencia.vuelo.infraestructure.vueloRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvionRepository avionRepository = new AvionRepository();
        TrayectoRepository trayectoRepository = new TrayectoRepository();
        TipoDocumentoRepository tipoDocumentoRepository=new TipoDocumentoRepository();
        EscalaRepository escalaRepository = new EscalaRepository();
        RevisionRepository revisionRepository = new RevisionRepository();
        TripulacionRepository tripulacionRepository = new TripulacionRepository();
        ClienteRepository clienteRepository = new ClienteRepository();
        AeropuertoRepository aeropuertoRepository = new AeropuertoRepository();
        ReservaRepository reservaRepository=new ReservaRepository();

        FindAvionUseCase findAvionUseCase = new FindAvionUseCase(avionRepository);
        CreateAvionUseCase createAvionUseCase = new CreateAvionUseCase(avionRepository);
        DeleteAvionUseCase deleteAvionUseCase = new DeleteAvionUseCase(avionRepository);
        UpdateAvionUseCase updateAvionUseCase = new UpdateAvionUseCase(avionRepository);

        FindEscalaUseCase findEscalaUseCase = new FindEscalaUseCase(escalaRepository);
        UpdateEscalaUseCase updateEscalaUseCase = new UpdateEscalaUseCase(escalaRepository);
        DeleteEscalaUseCase deleteEscalaUseCase = new DeleteEscalaUseCase(escalaRepository);
        AsignAvionUseCase asignAvionUseCase = new AsignAvionUseCase(escalaRepository);

        CreateRevisionUseCase createRevisionUseCase = new CreateRevisionUseCase(revisionRepository);
        UpdateTrayectoUseCase updateTrayectoUseCase = new UpdateTrayectoUseCase(trayectoRepository);
        DeleteTrayectoUseCase deleteTrayectoUseCase = new DeleteTrayectoUseCase(trayectoRepository);

        CreateTripulacionUseCase createTripulacionUseCase = new CreateTripulacionUseCase(tripulacionRepository);
        FindTripulacionUseCase findTripulacionUseCase=new FindTripulacionUseCase(tripulacionRepository);
        TripulacionController tripulacionController = new TripulacionController(createTripulacionUseCase, findTripulacionUseCase);

        AvionController avionController = new AvionController(createAvionUseCase, updateAvionUseCase, deleteAvionUseCase, findAvionUseCase);
        EscalaController escalaController = new EscalaController(findEscalaUseCase, updateEscalaUseCase, deleteEscalaUseCase, asignAvionUseCase);
        FindTrayectoUseCase findTrayectoUseCase = new FindTrayectoUseCase(trayectoRepository);
        TrayectoController trayectoController = new TrayectoController(findTrayectoUseCase,updateTrayectoUseCase,deleteTrayectoUseCase); 
        
        FindRevisionUseCase findRevisionUseCase = new FindRevisionUseCase(revisionRepository);
        UpdateRevisionUseCase updateRevisionUseCase = new UpdateRevisionUseCase(revisionRepository);
        DeleteRevisionUseCase deleteRevisionUseCase = new DeleteRevisionUseCase(revisionRepository);
        RevisionController revisionController = new RevisionController(createRevisionUseCase, updateRevisionUseCase, findRevisionUseCase, deleteRevisionUseCase);

        CreateTipoDocumentoUseCase createTipoDocumentoUseCase=new CreateTipoDocumentoUseCase(tipoDocumentoRepository);
        UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase=new UpdateTipoDocumentoUseCase(tipoDocumentoRepository);
        DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase=new DeleteTipoDocumentoUseCase(tipoDocumentoRepository);
        FindTipoDocumentoUseCase findTipoDocumentoUseCase=new FindTipoDocumentoUseCase(tipoDocumentoRepository);
        TipoDocumentoController tipoDocumentoController=new TipoDocumentoController(createTipoDocumentoUseCase, updateTipoDocumentoUseCase,deleteTipoDocumentoUseCase,findTipoDocumentoUseCase);
       
        CreateClienteCase createClienteCase = new CreateClienteCase(clienteRepository);
        FindClienteCase findClienteCase = new FindClienteCase(clienteRepository);
        UpdateClienteCase updateClienteCase = new UpdateClienteCase(clienteRepository);
        DeleteClienteCase deleteClienteCase = new DeleteClienteCase(clienteRepository);
        ClienteController clienteController = new ClienteController(createClienteCase, findClienteCase, deleteClienteCase, updateClienteCase);
        
        CreateAeropuertoCase createAeropuertoCase = new CreateAeropuertoCase(aeropuertoRepository);
        FindAeropuertoCase findAeropuertoCase = new FindAeropuertoCase(aeropuertoRepository);
        UpdateAeropuertoCase updateAeropuertoCase = new UpdateAeropuertoCase(aeropuertoRepository);
        DeleteAeropuertoCase deleteAeropuertoCase = new DeleteAeropuertoCase(aeropuertoRepository);
        AeropuertoController aeropuertoController = new AeropuertoController(createAeropuertoCase, findAeropuertoCase, deleteAeropuertoCase, updateAeropuertoCase);

        CreateReservaAgenteUseCase createReservaAgenteUseCase=new CreateReservaAgenteUseCase(reservaRepository);
        FindReservaAgenteUseCase findReservaAgenteUseCase=new FindReservaAgenteUseCase(reservaRepository); 
        DeleteReservaAgenteUseCase deleteReservaAgenteUseCase=new DeleteReservaAgenteUseCase(reservaRepository);   
        CancelReservaClienteUseCase cancelReservaClienteUseCase=new  CancelReservaClienteUseCase(reservaRepository); 
        PagarValorReservaUseCase pagarValorReservaUseCase = new PagarValorReservaUseCase(reservaRepository);
        ReservaController reservaController= new ReservaController(createReservaAgenteUseCase,findReservaAgenteUseCase,
        deleteReservaAgenteUseCase,cancelReservaClienteUseCase, pagarValorReservaUseCase);

        
        TarifaRepository tarifaRepository = new TarifaRepository();
        CreateTarifaUseCase createTarifaUseCase = new CreateTarifaUseCase(tarifaRepository);
        FindTarifaUseCase findTarifaUseCase = new FindTarifaUseCase(tarifaRepository);
        DeleteTarifaUseCase deleteTarifaUseCase = new DeleteTarifaUseCase(tarifaRepository);
        UpdateTarifaUseCase updateTarifaUseCase = new UpdateTarifaUseCase(tarifaRepository);

        TarifaController tarifaController = new TarifaController(createTarifaUseCase, findTarifaUseCase, deleteTarifaUseCase, updateTarifaUseCase);
            
        vueloRepository vueloRepository = new vueloRepository();
        FindvueloUseCase findvueloUseCase = new FindvueloUseCase(vueloRepository);
        SearchVueloxCiudadUseCase searchVueloxCiudadUseCase = new SearchVueloxCiudadUseCase(vueloRepository);
        CreateReservaxClienteUseCase createReservaxClienteUseCase = new CreateReservaxClienteUseCase(vueloRepository);
        AddPasajeroUseCase addPasajeroUseCase = new AddPasajeroUseCase(vueloRepository);
        MostrarAsientoUseCase mostrarAsientoUseCase = new MostrarAsientoUseCase(vueloRepository);
        AsignarAsientoUseCase asignarAsientoUseCase = new AsignarAsientoUseCase(vueloRepository);

        vueloController vueloController = new vueloController(findvueloUseCase, searchVueloxCiudadUseCase, createReservaxClienteUseCase, addPasajeroUseCase, mostrarAsientoUseCase, asignarAsientoUseCase);
    


        while (true) {
            
            System.out.println("1. Gestion Avión");
            System.out.println("2. Gestion Trayectos");
            System.out.println("3. Gestion Escalas");
            System.out.println("4. Gestión tipo documento");
            System.out.println("5. Gestión revisión de mantenimiento de aviones");
            System.out.println("6. Gestion de tripulantes");
            System.out.println("7. Gestion de clientes");
            System.out.println("8. Gestion de aeropuertos");
            System.out.println("9. Gestion de reservas");
            System.out.println("10. Gestion de Tarifas");
            System.out.println("11. Gestion de Vuelos");
            System.out.println("12. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            switch (opcion) {
                case 1:

                    avionController.gestionAvion();
                    break;
                    
                case 2: 
                
                    trayectoController.gestionTrayecto();
                    break;
                    
                case 3: 
                
                    escalaController.gestionEscala();
                    break;

                case 4:
                
                    tipoDocumentoController.gestionTipoDocumento();
                    break;

                case 5:

                    revisionController.gestionRevision();
                    break;

                case 6:

                    tripulacionController.gestionTripulacion();
                    break;


                case 7:

                    clienteController.gestionCliente();
                    break;

                case 8:

                    aeropuertoController.gestionAeropuerto();
                    break;

                case 9:

                    reservaController.gestionReserva();
                    break;

                case 10:

                    tarifaController.gestionTarifas();
                    break;

                case 11:

                    vueloController.gestionVuelo();
                    break;

                case 12:

                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:

                    System.out.println("Opción inválida");
                    break;

            }
        }
    }
}