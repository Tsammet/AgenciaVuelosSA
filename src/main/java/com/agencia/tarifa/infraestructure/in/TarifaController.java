package com.agencia.tarifa.infraestructure.in;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.domain.entity.Tarifa;

public class TarifaController {
    private final CreateTarifaUseCase createTarifaUseCase;
    private final FindTarifaUseCase findTarifaUseCase;
    private final DeleteTarifaUseCase deleteTarifaUseCase;
    private final UpdateTarifaUseCase updateTarifaUseCase;

    public TarifaController(CreateTarifaUseCase createTarifaUseCase, FindTarifaUseCase findTarifaUseCase,
            DeleteTarifaUseCase deleteTarifaUseCase, UpdateTarifaUseCase updateTarifaUseCase) {
        this.createTarifaUseCase = createTarifaUseCase;
        this.findTarifaUseCase = findTarifaUseCase;
        this.deleteTarifaUseCase = deleteTarifaUseCase;
        this.updateTarifaUseCase = updateTarifaUseCase;
    }

    Scanner scanner = new Scanner(System.in);

    public void gestionTarifas(){

        System.out.println("1. Crear Tarifa: ");
        System.out.println("2. Borrar Tarifa: ");
        System.out.println("3. Encontrar Tarifa: ");
        System.out.println("4. Actualizar Tarifa: ");
        System.out.println("5. Salir: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
            
                crear();

                break;
        
            case 2:

                eliminar();

                break;

            case 3:

                buscarTarifa();

                break;

            case 4:

                actualizar();

                break;

            case 5:

                return;

            default:
                break;
        }
    }


    public void crear(){

        System.out.println("Ingrese la descripción: ");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese el detalle: ");
        String detalle = scanner.nextLine();

        System.out.println("Ingrese el valor: ");
        String valorString = scanner.nextLine();
        BigDecimal valor = new BigDecimal(valorString);

        Tarifa tarifa = new Tarifa();
        tarifa.setDescripcion(descripcion);
        tarifa.setDetalles(detalle);
        tarifa.setValor(valor);

        createTarifaUseCase.execute(tarifa);
        System.out.println("Tarifa creada correctamnte!  ");

    }

    public void buscarTarifa(){

        System.out.println("Ingrese el id de la tarifa que desea buscar ");
        int idTarifa = scanner.nextInt();
        scanner.nextLine();

        Tarifa findTarifa = findTarifaUseCase.execute(idTarifa);

        if (findTarifa != null) {
            
        System.out.println("Id: " + findTarifa.getId());
        System.out.println("Detalle: " + findTarifa.getDetalles());
        System.out.println("Descripcion: " + findTarifa.getDescripcion());
        System.out.println("Valor: " + findTarifa.getValor());

        }

    }

    public void actualizar(){

        System.out.println("Ingrese el id de la tarifa que deseas modificar: ");
        int idTarifaMod = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la descripción: ");
        String descripcionMod = scanner.nextLine();

        System.out.println("Ingrese el detalle: ");
        String detalleMod = scanner.nextLine();

        System.out.println("Ingrese el valor: ");
        String valorMod = scanner.nextLine();
        BigDecimal valor = new BigDecimal(valorMod);


        Tarifa tarifa = new Tarifa();
        tarifa.setId(idTarifaMod);
        tarifa.setDescripcion(descripcionMod);
        tarifa.setDetalles(detalleMod);
        tarifa.setValor(valor);

        updateTarifaUseCase.execute(tarifa);
    }
    
    public void eliminar(){
        System.out.println("Ingrese el id de la tarifa para eliminar: ");
        int idTarifaEli = scanner.nextInt();
        scanner.nextLine();

        deleteTarifaUseCase.execute(idTarifaEli);

        if (deleteTarifaUseCase != null) {
            System.out.println("Eliminado");
        }else{
            System.out.println("No eliminado");
        }
    }
}
