package com.salvador.minhasfinancas.model.repository;

import com.salvador.minhasfinancas.model.entity.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest // Cria uma instancia de db em memoria (temporaria)
public class UsuarioRepositoryTest {

    @Autowired // injetando a intancia dessa interface
    UsuarioRepository repository;

    @Autowired
    TestEntityManager entityManager; // Contem operações de CRUD na base de dados em teste

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {
        // Para o testar a query method existByEmail precisamos de 3 elementos que são os seguintes:

        // 1º Cenario
        Usuario usuario = Usuario.builder().nome("Inacio").email("inacio@email.com").build();
        Usuario persist = entityManager.persist(usuario);

        // 2º Ação ou execução
        boolean result = repository.existsByEmail("inacio@email.com");

        // 3º Verificação
        Assertions.assertTrue(result);
    }

    @Test
    public void deveRetornarFalsoSeNaoExisteEmail(){
        // 1º cenario
        // repository.deleteAll(); Não utiliza-se mais.

        // 2º Ação ou execução
        boolean result = repository.existsByEmail("inacio@email.com");

        // 3º Verificação
        Assertions.assertFalse(result);

    }



}

// tentar conectar outro banco no proprio postgress.