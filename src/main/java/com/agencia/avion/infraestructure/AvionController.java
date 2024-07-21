package com.agencia.avion.infraestructure;

import java.util.Scanner;

import com.agencia.avion.application.CreateAvionUseCase;
import com.agencia.avion.application.DeleteAvionUseCase;
import com.agencia.avion.application.FindAvionUseCase;
import com.agencia.avion.application.UpdateAvionUseCase;
import com.agencia.avion.domain.entity.Avion;

public class AvionController {

    private final CreateAvionUseCase createAvionUseCase;
    private final UpdateAvionUseCase updateAvionUseCase;
    private final DeleteAvionUseCase deleteAvionUseCase;
    private final FindAvionUseCase findAvionUseCase;

    public AvionController(CreateAvionUseCase createAvionUseCase, UpdateAvionUseCase updateAvionUseCase,
        DeleteAvionUseCase deleteAvionUseCase, FindAvionUseCase findAvionUseCase) {
        this.createAvionUseCase = createAvionUseCase;
        this.updateAvionUseCase = updateAvionUseCase;
        this.deleteAvionUseCase = deleteAvionUseCase;
        this.findAvionUseCase = findAvionUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionAvion(){


        while(true){
            System.out.println("1. Crear Avion: ");
            System.out.println("2. Borrar Avion: ");
            System.out.println("3. Encontrar Avion: ");
            System.out.println("4. Actualizar Avion: ");
            System.out.println("5. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createAvion();
                    
                    break;

                case 2:
                    
                    deleteAvion();            
    
                    break;

                case 3:
                
                    findAvion();
                    
                    break;

                case 4:

                    updateAvion();

                    break;

                
            
                default:
                    break;
            }
            
        }

    }

    public void createAvion(){
      

            System.out.println("Ingrese matrícula del avión:");
            String matricula = scanner.nextLine();
            
            System.out.println("Ingrese capacidad:");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            System.out.print("Fecha de Fabricación (YYYY-MM-DD): ");
            String fechaFabricacion = scanner.nextLine();
            
            System.out.print("ID Estado: ");
            int idEstado = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            System.out.print("ID Modelo: ");
            int idModelo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            System.out.print("ID Aerolínea: ");
            int idAerolinea = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            Avion avion = new Avion();
            avion.setMatricula(matricula);
            avion.setCapacidad(capacidad);
            avion.setFechaFabricacion(fechaFabricacion);
            avion.setIdEstado(idEstado);
            avion.setIdModelo(idModelo);
            avion.setIdAerolinea(idAerolinea);
            
            createAvionUseCase.execute(avion);
            System.out.println("Avión creado correctamente :D");
    

        
    }

    public void deleteAvion(){
        System.out.println("Ingrese el id para eliminar el avión");
        int deleteAvion = scanner.nextInt();
        scanner.nextLine();

        // User userD = new User();
        deleteAvionUseCase.execute(deleteAvion);

        if(deleteAvionUseCase != null){
            System.out.println("Eliminado");
        }else{
            System.out.println("No eliminado");
        }
    }

    public void updateAvion(){

        System.out.println("Ingrese el id para actualizar el avión: ");
        int idAvionUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva matricula: ");
        String nuevaMatricula = scanner.nextLine();

        System.out.println("Ingrese la capacidad del avión");
        int nuevaCapacidad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la fecha de fabricación: ");
        String nuevaFecha = scanner.nextLine();

        System.out.println("Ingrese el id del estado: ");
        int nuevoEstado = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el id del modelo: ");
        int nuevoModelo = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el id de la aerolínea: ");
        int nuevaAerolinea = scanner.nextInt();
        scanner.nextLine();

        Avion newAvion = new Avion();

        newAvion.setId(idAvionUpdate);
        newAvion.setMatricula(nuevaMatricula);
        newAvion.setCapacidad(nuevaCapacidad);
        newAvion.setFechaFabricacion(nuevaFecha);
        newAvion.setIdEstado(nuevoEstado);
        newAvion.setIdModelo(nuevoModelo);
        newAvion.setIdAerolinea(nuevaAerolinea);

        updateAvionUseCase.execute(newAvion);

    }

    public void findAvion(){

        System.out.println("Cuál es el id del avión que desea consultar: ");
        int idAvion = scanner.nextInt();
        scanner.nextLine();

        Avion foundAvion = findAvionUseCase.execute(idAvion);

        if(foundAvion != null){
            System.out.println("Avion id: " + foundAvion.getId());
            System.out.println("Avion Matricula: " + foundAvion.getMatricula());
            System.out.println("Avion Capacidad: " + foundAvion.getCapacidad());
            System.out.println("Avion fecha Fabricación: " + foundAvion.getFechaFabricacion());
            System.out.println("Avion id Estado: " + foundAvion.getIdEstado());
            System.out.println("Avion id Modelo: " + foundAvion.getIdModelo());
            System.out.println("Avion id Aerolínea: " + foundAvion.getIdAerolinea());
        }
        else{
            System.out.println("Avión no encontrado c:");
        }

    }
}
