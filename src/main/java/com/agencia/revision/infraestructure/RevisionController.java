package com.agencia.revision.infraestructure;

import java.util.Scanner;

import com.agencia.revision.application.CreateRevisionUseCase;
import com.agencia.revision.application.DeleteRevisionUseCase;
import com.agencia.revision.application.FindRevisionUseCase;
import com.agencia.revision.application.UpdateRevisionUseCase;
import com.agencia.revision.domain.entity.Revision;

public class RevisionController{
    private final CreateRevisionUseCase createRevisionUseCase;
    private final UpdateRevisionUseCase updateRevisionUseCase;
    private final FindRevisionUseCase findRevisionUseCase;
    private final DeleteRevisionUseCase deleteRevisionUseCase;

    

    public RevisionController(CreateRevisionUseCase createRevisionUseCase, UpdateRevisionUseCase updateRevisionUseCase, FindRevisionUseCase findRevisionUseCase, DeleteRevisionUseCase deleteRevisionUseCase) {
        this.createRevisionUseCase = createRevisionUseCase;
        this.updateRevisionUseCase = updateRevisionUseCase;
        this.findRevisionUseCase = findRevisionUseCase;
        this.deleteRevisionUseCase = deleteRevisionUseCase;

    }

    Scanner scanner = new Scanner(System.in);

    public void gestionRevision(){


        while(true){
            System.out.println("1. Crear Revision: ");
            System.out.println("2. Borrar Revision: ");
            System.out.println("3. Encontrar Revision: ");
            System.out.println("4. Actualizar Revision: ");
            System.out.println("5. Salir: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    createRevision();
                    break;

                case 2:
                    deleteRevision();
                    break;


                case 3:
                    findRevision();
                    break;

                case 4:
                    updateRevision();
                    break;
            }
        }
    }

    public void createRevision(){

        System.out.println("Ingrese la fecha de la revisión (YYYY-MM-DD):");
        String fechaRevision = scanner.nextLine();
        
        System.out.println("Ingrese el ID del avion:");
        int idAvion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt
        
        System.out.print("Ingrese la descripción de la revisión ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese el id del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de nextInt

        Revision revision = new Revision();

        revision.setFechaRevision(fechaRevision);
        revision.setIdAvion(idAvion);
        revision.setDescripcion(descripcion);
        revision.setIdEmpleado(idEmpleado);

        createRevisionUseCase.execute(revision);
        System.out.println("Revision creada exitosamente. ");

    }

    public void findRevision(){

        System.out.println("Cuál es el id de la revisión que desea consultar: ");
        int idRevision = scanner.nextInt();
        scanner.nextLine();

        Revision foundRevision = findRevisionUseCase.execute(idRevision);

        if(foundRevision != null){
            System.out.println("Revision id: " + foundRevision.getId());
            System.out.println("Fecha revisión: " + foundRevision.getFechaRevision());
            System.out.println("ID Avión: " + foundRevision.getIdAvion());
            System.out.println("Descripción de la revisión: " + foundRevision.getDescripcion());
            System.out.println("ID empleado encargado: " + foundRevision.getIdEmpleado());
           
        }
        else{
            System.out.println("Revisión no encontrada c:");
        }

    }


    public void updateRevision(){


        System.out.println("Ingrese el id de la revisión que desea actualizar: ");
        int revisionUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva fecha de la revisión: ");
        String nuevaFecha = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID del avión: ");
        int nuevoAvion = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva descripción de la revisión: ");
        String nuevaDescripcion = scanner.nextLine();

        System.out.println("Ingrese el nuevo ID del empleado: ");
        int nuevoEmpleado = scanner.nextInt();

        Revision newRevision = new Revision();

        newRevision.setId(revisionUpdate);
        newRevision.setFechaRevision(nuevaFecha);
        newRevision.setIdAvion(nuevoAvion);
        newRevision.setDescripcion(nuevaDescripcion);
        newRevision.setIdEmpleado(nuevoEmpleado);

        updateRevisionUseCase.execute(newRevision);

    }


    public void deleteRevision(){
        System.out.println("Ingrese el id para eliminar la revisión: ");
        int deleteRevision = scanner.nextInt();
        scanner.nextLine();

        deleteRevisionUseCase.execute(deleteRevision);

        if(deleteRevisionUseCase != null){
            System.out.println("Revisión eliminada");
        }else{
            System.out.println("Revisión no eliminada");
        }
    }







}





