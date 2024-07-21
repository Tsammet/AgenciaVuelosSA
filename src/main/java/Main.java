
import java.util.Scanner;

import com.agencia.avion.application.CreateAvionUseCase;
import com.agencia.avion.application.DeleteAvionUseCase;
import com.agencia.avion.application.FindAvionUseCase;
import com.agencia.avion.application.UpdateAvionUseCase;
import com.agencia.avion.infraestructure.AvionController;
import com.agencia.avion.infraestructure.AvionRepository;
import com.agencia.escala.application.AsignAvionUseCase;
import com.agencia.escala.application.DeleteEscalaUseCase;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.infraestructure.EscalaController;
import com.agencia.escala.infraestructure.EscalaRepository;
import com.agencia.revision.application.CreateRevisionUseCase;
import com.agencia.revision.application.DeleteRevisionUseCase;
import com.agencia.revision.application.FindRevisionUseCase;
import com.agencia.revision.application.UpdateRevisionUseCase;
import com.agencia.revision.infraestructure.RevisionController;
import com.agencia.revision.infraestructure.RevisionRepository;
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

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AvionRepository avionRepository = new AvionRepository();
        TrayectoRepository trayectoRepository = new TrayectoRepository();
        TipoDocumentoRepository tipoDocumentoRepository=new TipoDocumentoRepository();
        EscalaRepository escalaRepository = new EscalaRepository();
        RevisionRepository revisionRepository = new RevisionRepository();
        TripulacionRepository tripulacionRepository = new TripulacionRepository();

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
        
        while (true) {
            System.out.println("1. Gestion Avión");
            System.out.println("2. Gestion Trayectos");
            System.out.println("3. Gestion Escalas");
            System.out.println("4. Gestión tipo documento");
            System.out.println("5. Gestión revisión de mantenimiento de aviones");
            System.out.println("6. Gestion de tripulantes");
            System.out.println("7. Salir");

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