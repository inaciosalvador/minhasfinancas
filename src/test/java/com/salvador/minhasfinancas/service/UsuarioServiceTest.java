package com.salvador.minhasfinancas.service;

import com.salvador.minhasfinancas.exception.RegraNegocioException;
import com.salvador.minhasfinancas.model.entity.Usuario;
import com.salvador.minhasfinancas.model.repository.UsuarioRepository;
import com.salvador.minhasfinancas.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveValidarEmail(){

        // Cenario
        repository.deleteAll();

        // ação
        service.validarEmail("inacio@gmail.com");


    }

    @Test
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastrado() {
        // Cenário
        Usuario usuario = Usuario.builder().nome("inacio").email("inacio@gmail.com").build();
        repository.save(usuario);

        // Ação e validação da exceção
        RegraNegocioException exception = assertThrows(RegraNegocioException.class, () ->
                service.validarEmail("inacio@gmail.com")
        );

        System.out.println(exception.getMessage());
    }
}
