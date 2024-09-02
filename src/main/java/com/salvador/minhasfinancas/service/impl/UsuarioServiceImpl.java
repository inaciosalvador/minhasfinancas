package com.salvador.minhasfinancas.service.impl;

import com.salvador.minhasfinancas.exception.ErroAutenticacao;
import com.salvador.minhasfinancas.exception.RegraNegocioException;
import com.salvador.minhasfinancas.model.entity.Usuario;
import com.salvador.minhasfinancas.model.repository.UsuarioRepository;
import com.salvador.minhasfinancas.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        Optional<Usuario> usuario = repository.findByEmail(email);

        if (!usuario.isPresent()) {
            throw new ErroAutenticacao("Usuario não encontrado para o email informado");
        }

        if (!usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha invalida.");
        }

        return usuario.get();

    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public void validarEmail(String email) {
        // aqui utiliza-se a Query Method (existByEmail) criada no UsuarioRepository
        boolean existe = repository.existsByEmail(email);
        if (existe) {
            // Exception personalizada
            throw new RegraNegocioException("Já existe um usuario com este email. ");
        }
    }
}
