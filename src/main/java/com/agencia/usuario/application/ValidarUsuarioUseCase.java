package com.agencia.usuario.application;

import com.agencia.usuario.domain.entity.Usuario;
import com.agencia.usuario.domain.service.UsuarioService;

public class ValidarUsuarioUseCase {

    private final UsuarioService usuarioService;

    public ValidarUsuarioUseCase(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public Usuario execute(Usuario usuario){
        return usuarioService.validarUsuario(usuario);
    }
}