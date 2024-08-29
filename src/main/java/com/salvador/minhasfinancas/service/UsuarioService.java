package com.salvador.minhasfinancas.service;

import com.salvador.minhasfinancas.model.entity.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);
    Usuario salvarUsuario(Usuario usuario);
    void validarEmail(String email); // Para validar se este email já está no banco (só pode um email por Usuario)




}
