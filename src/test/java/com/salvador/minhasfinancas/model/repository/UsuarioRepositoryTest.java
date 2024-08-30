package com.salvador.minhasfinancas.model.repository;

import com.salvador.minhasfinancas.model.entity.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
// 1º teste de integração, pois o teste depende de um componente externo
// neste caso, o banco de dados postgres
public class UsuarioRepositoryTest {

    @Autowired // injetanco a intancia dessa interface
    UsuarioRepository repository;

    @Test
    //Todos os metodos de test tem return void
    public void deveVerificarAExistenciaDdeUmEmail() {
        // Para o testar a quary method existByEmail precisamos de 3 elementos que são os seguintes:

        // 1º Cenario
        Usuario usuario = Usuario.builder().nome("Inacio").email("inacio@email.com").build(); //
        repository.save(usuario);

        // 2º Ação & execução
        boolean result = repository.existsByEmail("inacio@email.com");

        // 3º Verificação
        Assertions.assertTrue(result);
    }

}
