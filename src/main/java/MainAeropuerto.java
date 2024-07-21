import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.agencia.aeropuerto.aplication.CreateAeropuertoCase;
import com.agencia.aeropuerto.aplication.DeleteAeropuertoCase;
import com.agencia.aeropuerto.aplication.FindAeropuertoCase;
import com.agencia.aeropuerto.aplication.UpdateAeropuertoCase;
import com.agencia.aeropuerto.domain.service.AeropuertoService;
import com.agencia.aeropuerto.infrastructure.in.AeropuertoController;
import com.agencia.aeropuerto.infrastructure.out.AeropuertoRepository;

import com.agencia.cliente.aplication.CreateClienteCase;
import com.agencia.cliente.aplication.DeleteClienteCase;
import com.agencia.cliente.aplication.FindClienteCase;
import com.agencia.cliente.aplication.UpdateClienteCase;
import com.agencia.cliente.domain.service.ClienteService;
import com.agencia.cliente.infrastructure.in.ClienteController;
import com.agencia.cliente.infrastructure.out.ClienteRepository;

public class MainAeropuerto {
    public static void main(String[] args) {
        try {
            Object[] options = { "aeropuertos", "clientes", "salir" };
            Object menu = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", "Menu Principal",
                    JOptionPane.QUESTION_MESSAGE, null, options, "aeropuertos");

            int selectedIndex = -1; // default value for no selection or "Seleccione"
            for (int i = 0; i < options.length; i++) {
                if (options[i].equals(menu)) {
                    selectedIndex = i;
                    break;
                }
            }

            switch (selectedIndex) {
                case 0:
                    AeropuertoService aeropuertoService = new AeropuertoRepository();
                    CreateAeropuertoCase createAeropuertoCase = new CreateAeropuertoCase(aeropuertoService);
                    FindAeropuertoCase findAeropuertoCase = new FindAeropuertoCase(aeropuertoService);
                    UpdateAeropuertoCase updateAeropuertoCase = new UpdateAeropuertoCase(aeropuertoService);
                    DeleteAeropuertoCase deleteAeropuertoCase = new DeleteAeropuertoCase(aeropuertoService);

                    AeropuertoController aeropuertoController = new AeropuertoController(
                        createAeropuertoCase, 
                        findAeropuertoCase, 
                        deleteAeropuertoCase, 
                        updateAeropuertoCase
                    );

                    Object[] optionsAeropuerto = { "Crear aeropuerto", "Buscar aeropuerto", "Editar aeropuerto", 
                        "Eliminar aeropuerto", "Salir" };
                    Object menuAeropuerto = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", 
                        "Aeropuertos", JOptionPane.QUESTION_MESSAGE, null, optionsAeropuerto, "Crear aeropuerto");

                    int selectedIndexAeropuerto = -1; // default value for no selection or "Seleccione"
                    for (int i = 0; i < optionsAeropuerto.length; i++) {
                        if (optionsAeropuerto[i].equals(menuAeropuerto)) {
                            selectedIndexAeropuerto = i;
                            break;
                        }
                    }

                    switch (selectedIndexAeropuerto) {
                        case 0:
                            aeropuertoController.crear();
                            break;
                        case 1:
                            aeropuertoController.buscar();
                            break;
                        case 2:
                            aeropuertoController.actualizar();
                            break;
                        case 3:
                            aeropuertoController.eliminar();
                            break;
                        default:
                            break;
                    }
                    break;
                    
                case 1:
                    ClienteService clienteService = new ClienteRepository();
                    CreateClienteCase createClienteCase = new CreateClienteCase(clienteService);
                    FindClienteCase findClienteCase = new FindClienteCase(clienteService);
                    UpdateClienteCase updateClienteCase = new UpdateClienteCase(clienteService);
                    DeleteClienteCase deleteClienteCase = new DeleteClienteCase(clienteService);

                    ClienteController clienteController = new ClienteController(
                        clienteService, 
                        createClienteCase, 
                        findClienteCase, 
                        deleteClienteCase, 
                        updateClienteCase
                    );

                    Object[] optionsCliente = { "Crear cliente", "Buscar cliente", "Editar cliente", 
                        "Eliminar cliente", "Salir" };
                    Object menuCliente = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", 
                        "Clientes", JOptionPane.QUESTION_MESSAGE, null, optionsCliente, "Crear cliente");

                    int selectedIndexCliente = -1; // default value for no selection or "Seleccione"
                    for (int i = 0; i < optionsCliente.length; i++) {
                        if (optionsCliente[i].equals(menuCliente)) {
                            selectedIndexCliente = i;
                            break;
                        }
                    }

                    switch (selectedIndexCliente) {
                        case 0:
                            clienteController.crear();
                            break;
                        case 1:
                            clienteController.buscar();
                            break;
                        case 2:
                            clienteController.actualizar();
                            break;
                        case 3:
                            clienteController.eliminar();
                            break;
                        default:
                            break;
                    }
                    break;

                default:
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
