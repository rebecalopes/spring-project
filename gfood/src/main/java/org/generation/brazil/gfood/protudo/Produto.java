package org.generation.brazil.gfood.protudo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    @NotNull
    private String nome;
    @Column(name = "descricao")
    private String descricao;

    private BigDecimal preco;
}
