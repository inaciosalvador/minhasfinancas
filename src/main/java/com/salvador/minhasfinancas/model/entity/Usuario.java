package com.salvador.minhasfinancas.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario", schema = "financas")
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Data ele substitui todas as declarações acima
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

}
