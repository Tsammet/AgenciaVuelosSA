package com.agencia.tarifa.infraestructure.in;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.agencia.tarifa.application.CreateTarifaUseCase;
import com.agencia.tarifa.application.DeleteTarifaUseCase;
import com.agencia.tarifa.application.FindTarifaUseCase;
import com.agencia.tarifa.application.UpdateTarifaUseCase;
import com.agencia.tarifa.domain.entity.Tarifa;

public class TarifaController {
    private CreateTarifaUseCase createTarifaUseCase;
    private FindTarifaUseCase findTarifaUseCase;
    private DeleteTarifaUseCase deleteTarifaUseCase;
    private UpdateTarifaUseCase updateTarifaUseCase;

    public TarifaController(CreateTarifaUseCase createTarifaUseCase, FindTarifaUseCase findTarifaUseCase,
            DeleteTarifaUseCase deleteTarifaUseCase, UpdateTarifaUseCase updateTarifaUseCase) {
        this.createTarifaUseCase = createTarifaUseCase;
        this.findTarifaUseCase = findTarifaUseCase;
        this.deleteTarifaUseCase = deleteTarifaUseCase;
        this.updateTarifaUseCase = updateTarifaUseCase;
    }

    public TarifaController(CreateTarifaUseCase createTarifaUseCase) {
        this.createTarifaUseCase = createTarifaUseCase;
    }

    public void crear() throws SQLException {

        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
        String detalle = JOptionPane.showInputDialog("Ingrese detalle");
        String valorString = JOptionPane.showInputDialog("Ingrese valor");
        BigDecimal valor = new BigDecimal(valorString);
        Tarifa tarifa = new Tarifa();
        tarifa.setDescripcion(descripcion);
        tarifa.setDetalles(detalle);
        tarifa.setValor(valor);

        createTarifaUseCase.execute(tarifa);
        JOptionPane.showMessageDialog(null, "Tarifa creada correctamnte!  ");

    }

    public void buscar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese descripcion");
        int id = Integer.parseInt(idString);
        Tarifa tarifa = new Tarifa();
        
        tarifa = findTarifaUseCase.execute(id);
        System.out.println("Id: " + tarifa.getId());
        System.out.println("Detalle: " + tarifa.getDetalles());
        System.out.println("Descripcion: " + tarifa.getDescripcion());
        System.out.println("Valor: " + tarifa.getValor());

    }

    public void actualizar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id modificar");
        int id = Integer.parseInt(idString);
        String descripcion = JOptionPane.showInputDialog("Ingrese descripcion");
        String detalle = JOptionPane.showInputDialog("Ingrese detalle");
        String valorString = JOptionPane.showInputDialog("Ingrese valor");
        Tarifa tarifa = new Tarifa();
        BigDecimal valor = new BigDecimal(valorString);
        tarifa.setId(id);
        tarifa.setDescripcion(descripcion);
        tarifa.setDetalles(detalle);
        tarifa.setValor(valor);
        updateTarifaUseCase.execute(tarifa);
    }
    
    public void eliminar() throws SQLException {
        String idString = JOptionPane.showInputDialog("Ingrese id a eliminar");
        int id = Integer.parseInt(idString);
        deleteTarifaUseCase.execute(id);
    }
}
