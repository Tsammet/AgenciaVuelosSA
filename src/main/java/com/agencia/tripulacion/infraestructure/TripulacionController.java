package com.agencia.tripulacion.infraestructure;

import java.util.Scanner;

import com.agencia.tripulacion.application.CreateTripulacionUseCase;
import com.agencia.tripulacion.application.FindTripulacionUseCase;
import com.agencia.tripulacion.domain.entity.Tripulacion;

public class TripulacionController {

    private final CreateTripulacionUseCase createTripulacionUseCase;
    private final FindTripulacionUseCase findTripulacionUseCase;

    public TripulacionController(CreateTripulacionUseCase createTripulacionUseCase, FindTripulacionUseCase findTripulacionUseCase){
        this.createTripulacionUseCase = createTripulacionUseCase;
        this.findTripulacionUseCase = findTripulacionUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionTripulacion(){

        while (true) {
            
            System.out.println("1. Asignar tripulación: ");
            System.out.println("2. Encontrar Tripulación: ");
            System.out.println("3. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createTripulacion();
                    
                    break;

                case 2:

                    findTripulacion();
                    
                    break;
            
                case 3: 

                    return;

                default:
                    break;
            }

        }
        
    }
        public void createTripulacion(){

            System.out.println("Ingrese el id del empleado: ");
            int idEmpleado = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el id de la escala: ");
            int idconexion = scanner.nextInt();
            scanner.nextLine();

            Tripulacion tripulacion = new Tripulacion();

            tripulacion.setIdempleado(idEmpleado);
            tripulacion.setIdconexion(idconexion);

            createTripulacionUseCase.execute(tripulacion);
            System.out.println("Tripulación asignada correctamente.");

        }


        public void findTripulacion(){

            System.out.println("Cuál es el id de la escala: ");
            int idEscala = scanner.nextInt();
            scanner.nextLine();

            Tripulacion findTripulacion = findTripulacionUseCase.execute(idEscala);

            if (findTripulacion != null) {
                System.out.println("--------------------------------");
                System.out.println("TRIPULACIÓN PARA LA ESCALA");
                System.out.println("El id del empleado: " + findTripulacion.getIdempleado());
                System.out.println("El id de la escala es: " + findTripulacion.getIdconexion());
                System.out.println("--------------------------------");
            }



        }


}
