
package com.agencia.aeropuerto.infrastructure.in;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
import com.agencia.aeropuerto.domain.entity.Aeropuerto;

public class AeropuertoController {
    private CreateAeropuertoCase createAeropuertoCase;
    private FindAeropuertoCase findAeropuertoCase;
    private DeleteAeropuertoCase deleteAeropuertoCase;
    private UpdateAeropuertoCase updateAeropuertoCase;

    public AeropuertoController(CreateAeropuertoCase createAeropuertoCase, FindAeropuertoCase findAeropuertoCase,
            DeleteAeropuertoCase deleteAeropuertoCase, UpdateAeropuertoCase updateAeropuertoCase) {
        this.createAeropuertoCase = createAeropuertoCase;
        this.findAeropuertoCase = findAeropuertoCase;
        this.deleteAeropuertoCase = deleteAeropuertoCase;
        this.updateAeropuertoCase = updateAeropuertoCase;
    }

    public AeropuertoController(CreateAeropuertoCase createAeropuertoCase) {
        this.createAeropuertoCase = createAeropuertoCase;
    }

    public void crear() throws SQLException {
        String nombreae = JOptionPane.showInputDialog("Cual es el nombre del aeropuerto?");
        String idaeropuerto = JOptionPane.showInputDialog("Id del Aeropuerto");
        String idciudadae = JOptionPane.showInputDialog("Id de la ciudad: ");

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setNombreae(nombreae);
        aeropuerto.setId(idaeropuerto);
        aeropuerto.setIdciudadae(idciudadae);

        createAeropuertoCase.execute(aeropuerto);
        JOptionPane.showMessageDialog(null, "Aeropuerto Creado Correctamente!");
    }

    public void buscar() throws SQLException {
        String idaeropuerto = JOptionPane.showInputDialog("Ingrese ID del Aeropuerto");
        Aeropuerto aeropuerto = findAeropuertoCase.execute(idaeropuerto);

        if (aeropuerto != null) {
            System.out.println("Id: " + aeropuerto.getId());
            System.out.println("Nombre: " + aeropuerto.getNombreae());
            System.out.println("ID de la ciudad: " + aeropuerto.getIdciudadae());
        } else {
            JOptionPane.showMessageDialog(null, "Aeropuerto no encontrado!");
        }
    }

    public void actualizar() throws SQLException {
        String idaeropuerto = JOptionPane.showInputDialog("Ingrese ID del Aeropuerto a Modificar.");
        String nombreae = JOptionPane.showInputDialog("Cual es el nombre del aeropuerto?");
        String idciudadae = JOptionPane.showInputDialog("Id de la Ciudad?");

        Aeropuerto aeropuerto = new Aeropuerto();
        aeropuerto.setId(idaeropuerto);
        aeropuerto.setNombreae(nombreae);
        aeropuerto.setIdciudadae(idciudadae);

        updateAeropuertoCase.execute(aeropuerto);
        JOptionPane.showMessageDialog(null, "Aeropuerto Modificado Correctamente!");
    }

    public void eliminar() throws SQLException {
        String idaeropuerto = JOptionPane.showInputDialog("Id del Aeropuerto a Eliminar.");

        deleteAeropuertoCase.execute(idaeropuerto);
        JOptionPane.showMessageDialog(null, "Aeropuerto Eliminado Correctamente!");
    }
}
