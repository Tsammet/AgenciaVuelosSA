import java.util.Scanner;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.infraestructure.in.TarifaController;
import com.agencia.tarifa.infraestructure.out.TarifaRepository;
import com.agencia.trayecto.application.AsignAvionTrayectoUseCase;
import com.agencia.vuelo.application.AddPasajeroUseCase;
import com.agencia.vuelo.application.AsignarAsientoUseCase;
import com.agencia.vuelo.application.CreateReservaxClienteUseCase;
import com.agencia.vuelo.application.FindvueloUseCase;
import com.agencia.vuelo.application.MostrarAsientoUseCase;
import com.agencia.vuelo.application.SearchVueloxCiudadUseCase;
import com.agencia.vuelo.infraestructure.vueloController;
import com.agencia.vuelo.infraestructure.vueloRepository;

public class mainsebastian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
    
        while(true){
            System.out.println("1. Gestor de Tarifas: ");
            System.out.println("2. Gestor de Vuelos");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    tarifaController.gestionTarifas();

                    break;
            
                case 2:

                    vueloController.gestionVuelo();

                case 3:

                    return;

                default:
                    break;
            }
        }
            
     
    }
}
