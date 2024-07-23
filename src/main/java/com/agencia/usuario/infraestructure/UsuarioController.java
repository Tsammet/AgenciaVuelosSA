package com.agencia.usuario.infraestructure;

import java.util.Scanner;

import com.agencia.usuario.application.ValidarUsuarioUseCase;
import com.agencia.usuario.domain.entity.Usuario;

public class UsuarioController {

    private final ValidarUsuarioUseCase validarUsuarioUseCase;

    public UsuarioController(ValidarUsuarioUseCase validarUsuarioUseCase) {
        this.validarUsuarioUseCase = validarUsuarioUseCase;
    }

    Scanner scanner = new Scanner(System.in);
    
    public void validarUsuario(){

        System.out.println("Ingrese el usuario: ");
        String user = scanner.nextLine();

        System.out.println("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setUsuario(user);
        usuario.setContrasena(contrasena);

        validarUsuarioUseCase.execute(usuario);
        System.out.println("VALIDADO");
        
    }   

}
