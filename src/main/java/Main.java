import java.util.Scanner;
import com.agencia.usuario.application.ValidarUsuarioUseCase;
import com.agencia.usuario.infraestructure.UsuarioController;
import com.agencia.usuario.infraestructure.UsuarioRepository;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        UsuarioRepository usuarioRepository = new UsuarioRepository();
        ValidarUsuarioUseCase validarUsuarioUseCase = new ValidarUsuarioUseCase(usuarioRepository);
        UsuarioController usuarioController = new UsuarioController(validarUsuarioUseCase);

        while (true) {

            System.out.println("  ");
            System.out.println("███████╗    █████╗         █████╗ ██╗██████╗ ██╗     ██╗███╗   ██╗███████╗\n" + //
                            "██╔════╝   ██╔══██╗       ██╔══██╗██║██╔══██╗██║     ██║████╗  ██║██╔════╝\n" + //
                            "███████╗   ███████║       ███████║██║██████╔╝██║     ██║██╔██╗ ██║█████╗  \n" + //
                            "╚════██║   ██╔══██║       ██╔══██║██║██╔══██╗██║     ██║██║╚██╗██║██╔══╝  \n" + //
                            "███████║██╗██║  ██║██╗    ██║  ██║██║██║  ██║███████╗██║██║ ╚████║███████╗\n" + //
                            "╚══════╝╚═╝╚═╝  ╚═╝╚═╝    ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝╚══════╝╚═╝╚═╝  ╚═══╝╚══════╝");
            System.out.println("¡Bienvenido a S.A. AIRLINE!");
            
            System.out.println("1 Iniciar sesión");
            System.out.println("2. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
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