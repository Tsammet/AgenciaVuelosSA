import java.util.Scanner;

import com.agencia.usuario.application.ValidarUsuarioUseCase;
import com.agencia.usuario.infraestructure.UsuarioController;
import com.agencia.usuario.infraestructure.UsuarioRepository;


public class main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ValidarUsuarioUseCase validarUsuarioUseCase = new ValidarUsuarioUseCase(usuarioRepository);
        UsuarioController usuarioController = new UsuarioController(validarUsuarioUseCase);

        while (true) {

            
            System.out.println("1. Gestion Usuario");
            System.out.println("1. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de nextInt
            
            switch (opcion) {
                case 1:

                    usuarioController.validarUsuario();
                    break;
                    
                case 2:

                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                
                default:

                    System.out.println("Opción inválida");
                    break;

            }
        }
    }
}