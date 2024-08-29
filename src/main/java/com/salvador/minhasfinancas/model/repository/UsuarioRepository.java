package com.salvador.minhasfinancas.model.repository;

import com.salvador.minhasfinancas.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Usando esta convenção para o nome, a JPA reconhece o metodo para verificar se o email existe
    //no banco de dados, inclusive reconhecendo a coluna email.
    //Pode-se usar esta convenção para verificar qualquer coluna, alterando apenas o nome do metodo
    // por exemplo existByNome()
    boolean existsByEmail(String email);
}
