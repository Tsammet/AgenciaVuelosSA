
package com.agencia.aeropuerto.infrastructure.in;

import java.util.Scanner;

import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
import com.agencia.aeropuerto.domain.entity.Aeropuerto;

public class AeropuertoController {
    private final CreateAeropuertoCase createAeropuertoCase;
    private final FindAeropuertoCase findAeropuertoCase;
    private final DeleteAeropuertoCase deleteAeropuertoCase;
    private final UpdateAeropuertoCase updateAeropuertoCase;

    public AeropuertoController(CreateAeropuertoCase createAeropuertoCase, FindAeropuertoCase findAeropuertoCase,
            DeleteAeropuertoCase deleteAeropuertoCase, UpdateAeropuertoCase updateAeropuertoCase) {
        this.createAeropuertoCase = createAeropuertoCase;
        this.findAeropuertoCase = findAeropuertoCase;
        this.deleteAeropuertoCase = deleteAeropuertoCase;
        this.updateAeropuertoCase = updateAeropuertoCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionAeropuerto(){
        while(true){
            System.out.println("1. Crear Aeropuerto: ");
            System.out.println("2. Borrar Aeropuerto: ");
            System.out.println("3. Encontrar Aeropuerto: ");
            System.out.println("4. Actualizar Aeropuerto: ");
            System.out.println("5. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    createAeropuerto();
                    break;

                case 2:
                    deleteAeropuerto();           
                    break;

                case 3:
                    findAeropuerto();
                    break;

                case 4:
                    updateAeropuerto();
                    break;

                case 5: 

                    return;

                default:
                    break;
            }
        }
    }

    public void createAeropuerto(){

        System.out.println("Introduce el ID del aeropuerto: ");
        String idaeropuerto = scanner.nextLine();

        System.out.println("Introduce el nombre del aeropuerto: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el ID de la ciudad del aeropuerto: ");
        String idciudad = scanner.nextLine();

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setId(idaeropuerto);
        aeropuerto.setNombreAero(nombre);
        aeropuerto.setIdCiudad(idciudad);

        createAeropuertoCase.execute(aeropuerto);
        System.out.println("Aeropuerto Creado Correctamente!");
    }

    public void findAeropuerto(){
        System.out.println("Ingrese ID del Aeropuerto que desea encontrar: ");
        String idaeropuerto = scanner.nextLine();

        Aeropuerto foundAeropuerto = findAeropuertoCase.execute(idaeropuerto);

        if (foundAeropuerto != null) {
            System.out.println("Id: " + foundAeropuerto.getId());
            System.out.println("Nombre: " + foundAeropuerto.getNombreAero());
            System.out.println("ID de la ciudad: " + foundAeropuerto.getIdCiudad());
        } else {
            System.out.println("Aeropuerto no encontrado!");
        }
    }

    public void updateAeropuerto(){
        System.out.println("Ingrese el id para actualizar el aeropuerto: ");
        String idAeropuertoUpdate = scanner.nextLine();

        System.out.println("Ingrese el nuevo nombre del aeropuerto: ");
        String nuevoNombre = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID de la ciudad del aeropuerto: ");
        String nuevaCiudad = scanner.nextLine();

        Aeropuerto newAeropuerto = new Aeropuerto();

        newAeropuerto.setId(idAeropuertoUpdate);
        newAeropuerto.setNombreAero(nuevoNombre);
        newAeropuerto.setIdCiudad(nuevaCiudad);

        updateAeropuertoCase.execute(newAeropuerto);
        System.out.println("Aeropuerto actualizado correctamente!");
    }

    public void deleteAeropuerto(){
        System.out.println("Ingrese el id para eliminar el aeropuerto");
        String deleteAeropuerto = scanner.nextLine();

        // User userD = new User();
        deleteAeropuertoCase.execute(deleteAeropuerto);

        if(deleteAeropuertoCase != null){
            System.out.println("Aeropuerto eliminado");
        }else{
            System.out.println("Aeropuerto no encontrado");
        }
    }
}