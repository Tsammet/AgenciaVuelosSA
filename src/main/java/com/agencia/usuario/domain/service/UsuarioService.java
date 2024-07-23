package com.agencia.usuario.domain.service;

import com.agencia.usuario.domain.entity.Usuario;

public interface UsuarioService {

    Usuario validarUsuario(int id);
    void validarUsuario(Usuario usuario);
}
