package com.salvador.minhasfinancas.model.entity;

import com.salvador.minhasfinancas.model.enums.StatusLancamento;
import com.salvador.minhasfinancas.model.enums.TipoLancamento;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento", schema = "financas")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "ano")
    private Integer ano;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "tipo")
    @Enumerated(EnumType.STRING)
    private TipoLancamento tipo;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusLancamento status;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
