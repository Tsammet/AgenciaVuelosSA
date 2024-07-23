package com.agencia.tipoDocumento.infraestructure;

import java.util.Scanner;

import com.agencia.tipoDocumento.application.CreateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.DeleteTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.FindTipoDocumentoUseCase;
import com.agencia.tipoDocumento.application.UpdateTipoDocumentoUseCase;
import com.agencia.tipoDocumento.domain.entity.TipoDocumento;

public class TipoDocumentoController {

    private final CreateTipoDocumentoUseCase createTipoDocumentoUseCase;
    private final UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase;
    private final DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase;
    private final FindTipoDocumentoUseCase findTipoDocumentoUseCase;

    public TipoDocumentoController(CreateTipoDocumentoUseCase createTipoDocumentoUseCase,
            UpdateTipoDocumentoUseCase updateTipoDocumentoUseCase,
            DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase, FindTipoDocumentoUseCase findTipoDocumentoUseCase) {
        this.createTipoDocumentoUseCase = createTipoDocumentoUseCase;
        this.updateTipoDocumentoUseCase = updateTipoDocumentoUseCase;
        this.deleteTipoDocumentoUseCase = deleteTipoDocumentoUseCase;
        this.findTipoDocumentoUseCase = findTipoDocumentoUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionTipoDocumento() {
        while (true) {
            System.out.println("1. Crear tipo documento");
            System.out.println("2. Modificar tipo documento");
            System.out.println("3. Eliminar tipo documento");
            System.out.println("4. Buscar documento");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    createTipoDocumento();
                    break;
                case 2:
                    updateTipoDocumento();
                    break;
                case 3:
                    deleteTipoDocumento();
                    break;

                case 4:
                    findIdtipoDocumento();
                    break;

                case 5:
                    return;

                default:
                    break;
            }

        }

    }

    public void createTipoDocumento() {
        System.out.print("Ingrese nombre de tipo de documento: ");
        String nombre = scanner.nextLine();

        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setNombre(nombre);
        createTipoDocumentoUseCase.execute(tipoDocumento);
    }

    public void updateTipoDocumento() {
        System.out.println("Ingrese el ID del tipo de documento a modificar: ");
        int idUpdtTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese nuevo nombre del tipo de documento");
        String nombreupdtTipoDocumento = scanner.nextLine();

        TipoDocumento updttipoDocumento = new TipoDocumento();
        updttipoDocumento.setId(idUpdtTipoDocumento);
        updttipoDocumento.setNombre(nombreupdtTipoDocumento);

        updateTipoDocumentoUseCase.execute(updttipoDocumento);

    }

    public void deleteTipoDocumento() {
        System.out.println("Ingrese el ID del documento a eliminar");
        int idDeleteTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        TipoDocumento deletTipoDocumento = new TipoDocumento();
        deletTipoDocumento.setId(idDeleteTipoDocumento);

        deleteTipoDocumentoUseCase.execute(deletTipoDocumento);
    }

    public void findIdtipoDocumento() {
        System.out.println("Ingrese id a consultar");
        int idfindTipoDocumento = scanner.nextInt();
        scanner.nextLine();

        TipoDocumento encontrar = findTipoDocumentoUseCase.execute(idfindTipoDocumento);
        if (encontrar != null) {
            System.out.println("Id: " + encontrar.getId());
            System.out.println("Nombre: " + encontrar.getNombre());

        } else {
            System.out.println("No se encontro el tipo de documento");
        }

    }
}
