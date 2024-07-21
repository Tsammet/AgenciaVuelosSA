package com.agencia.trayecto.infraestructure;

import java.util.Scanner;

import com.agencia.trayecto.application.DeleteTrayectoUseCase;
import com.agencia.trayecto.application.FindTrayectoUseCase;
import com.agencia.trayecto.application.UpdateTrayectoUseCase;
import com.agencia.trayecto.domain.entity.Trayecto;

public class TrayectoController {

    private final FindTrayectoUseCase findTrayectoUseCase;
    private final UpdateTrayectoUseCase updateTrayectoUseCase;
    private final DeleteTrayectoUseCase deleteTrayectoUseCase;

    public TrayectoController(FindTrayectoUseCase findTrayectoUseCase, UpdateTrayectoUseCase updateTrayectoUseCase, DeleteTrayectoUseCase deleteTrayectoUseCase){
        this.findTrayectoUseCase = findTrayectoUseCase;
        this.updateTrayectoUseCase = updateTrayectoUseCase;
        this.deleteTrayectoUseCase = deleteTrayectoUseCase;
    }


    Scanner scanner = new Scanner(System.in);

    public void gestionTrayecto(){

        while (true) {
            
            System.out.println("1. Encontrar trayecto: ");
            System.out.println("2. Actualizar trayecto: ");
            System.out.println("3. Eliminar Trayecto");
            System.out.println("3. Salir: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    
                    findTrayecto();

                    break;
                
                case 2:

                    updateTrayecto();

                case 3:

                    deleteTrayecto();

                case 4: 

                    return;

                default:
                    break;
            }

        }

    }

    public void findTrayecto(){

        System.out.println("Cuál es el id del trayecto que desea consultar: ");
        int idTrayecto = scanner.nextInt();
        scanner.nextLine();

        Trayecto foundTrayecto = findTrayectoUseCase.execute(idTrayecto);

        if(foundTrayecto != null){
            System.out.println("Trayecto id: " + foundTrayecto.getId());
            System.out.println("Trayecto fecha viaje: " + foundTrayecto.getFechaViaje());
            System.out.println("Precio viaje trayecto: " + foundTrayecto.getPrecioViaje());
            System.out.println("Aeropuerto Origen Trayecto: " + foundTrayecto.getIdOrigenAeropuerto());
            System.out.println("Aeropuerto Destino Trayecto: " + foundTrayecto.getIdDestinoAeropuerto());
        }else{
            System.out.println("Trayecto no encontrado :c");
        }

    }

    public void updateTrayecto(){

        System.out.println("Ingrese el id para actualizar el trayecto: ");
        int idTrayectoUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva fecha de viaje: ");
        String nuevaFecha = scanner.nextLine();

        System.out.println("Ingrese el precio del trayecto: ");
        int nuevoPrecio = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el id del aeropuerto de origen:  ");
        String nuevoAeropuerto = scanner.nextLine();

        System.out.println("Ingrese el ide del aeropuerto de destino: ");
        String destinoAeropuerto = scanner.nextLine();

        Trayecto updateTrayecto = new Trayecto();

        updateTrayecto.setId(idTrayectoUpdate);
        updateTrayecto.setFechaViaje(nuevaFecha);
        updateTrayecto.setPrecioViaje(nuevoPrecio);
        updateTrayecto.setIdOrigenAeropuerto(nuevoAeropuerto);
        updateTrayecto.setIdDestinoAeropuerto(destinoAeropuerto);

        updateTrayectoUseCase.execute(updateTrayecto);

    }

    public void deleteTrayecto(){
        System.out.println("Ingrese el id del trayecto para eliminarlo: ");
        int deleteTrayecto = scanner.nextInt();
        scanner.nextLine();
        
        deleteTrayectoUseCase.execute(deleteTrayecto);

        if (deleteTrayectoUseCase != null) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No eliminado");
        }
    }

}
