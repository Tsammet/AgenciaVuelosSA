package com.agencia.escala.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.agencia.escala.application.AsignAvionUseCase;
import com.agencia.escala.application.DeleteEscalaUseCase;
import com.agencia.escala.application.FindEscalaUseCase;
import com.agencia.escala.application.UpdateEscalaUseCase;
import com.agencia.escala.domain.entity.Escala;



public class EscalaController {
    private final FindEscalaUseCase findEscalaUseCase;
    private final UpdateEscalaUseCase updateEscalaUseCase;
    private final DeleteEscalaUseCase deleteEscalaUseCase;
    private final AsignAvionUseCase asignAvionUseCase;

    public EscalaController(FindEscalaUseCase findEscalaUseCase, UpdateEscalaUseCase updateEscalaUseCase, DeleteEscalaUseCase deleteEscalaUseCase, AsignAvionUseCase asignAvionUseCase) {
        this.findEscalaUseCase = findEscalaUseCase;
        this.updateEscalaUseCase = updateEscalaUseCase;
        this.deleteEscalaUseCase = deleteEscalaUseCase;
        this.asignAvionUseCase = asignAvionUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionEscala() {

        while (true) {
            System.out.println("1. Encontrar Escala: ");
            System.out.println("2. Actualizar Escala: ");
            System.out.println("3. Eliminar Escala: ");
            System.out.println("4. Asignar Avión a escala: ");

            System.out.println("4. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    findEscalas();

                    break;

                case 2:

                    updateEscala();

                    break;

                case 3:

                    deleteEscala();

                    break;

                case 4:

                    asignAvion();

                case 5:
                    System.out.println("Saliendo...");
                    return;

                default:

                    break;

            }
        }

    }

   public void findEscalas() {
    System.out.println("¿Cuál es el id del trayecto del cual desea consultar las escalas?");
    int idViaje = scanner.nextInt();
    scanner.nextLine();
    List<Escala> escalas= new ArrayList<>();
    escalas = findEscalaUseCase.execute(idViaje); // Asumiendo que devuelve una lista de escalas

    if (!escalas.isEmpty()) {
        System.out.println(escalas);
        // escalas.forEach(escala -> System.out.println(escala.getId()));

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
}


    public void updateEscala() {

        System.out.println("Ingrese el id de la escala a actualizar: ");
        int idEscalaUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo id del avión ");
        int nuevoAvion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nuevo id del aeropuerto origen");
        String nuevoAeropuertoOrigen = scanner.nextLine();

        System.out.println("Ingrese el nuevo id del aeropuerto destino");
        String nuevoAeropuertoDestino = scanner.nextLine();

        Escala newEscala = new Escala();

        newEscala.setId(idEscalaUpdate);
        newEscala.setIdAvion(nuevoAvion);
        newEscala.setIdAeropuertoOrigen(nuevoAeropuertoOrigen);
        newEscala.setIdAeropuertoDestino(nuevoAeropuertoDestino);

        updateEscalaUseCase.execute(newEscala);

    }

    public void deleteEscala(){
        System.out.println("Ingrese el id de la escala que desea eliminar: ");
        int deleteEscala = scanner.nextInt();
        scanner.nextLine();

        // User userD = new User();
        deleteEscalaUseCase.execute(deleteEscala);

        if(deleteEscalaUseCase != null){
            System.out.println("Escala eliminada");
        }else{
            System.out.println("No eliminada");
        }
    }

    public void asignAvion(){

        System.out.println("Ingrese el id de la escala a la cual le deseas asignar un avión: ");
        int idEscalaAvion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Cuál es el id del avión que desea darle a la escala: ");
        int idAvion = scanner.nextInt();
        scanner.nextLine();

        Escala escala = new Escala();

        escala.setId(idEscalaAvion);
        escala.setIdAvion(idAvion);

        asignAvionUseCase.execute(escala);

        System.out.println("Avión asignado <3");

    }

}

