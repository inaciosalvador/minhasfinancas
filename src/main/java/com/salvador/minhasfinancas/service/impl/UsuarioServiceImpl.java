package com.salvador.minhasfinancas.service.impl;

import com.salvador.minhasfinancas.exception.RegraNegocioException;
import com.salvador.minhasfinancas.model.entity.Usuario;
import com.salvador.minhasfinancas.model.repository.UsuarioRepository;
import com.salvador.minhasfinancas.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if (existe) {
            throw new RegraNegocioException("Já existe um usuario com este email. ");
        }
    }
}
