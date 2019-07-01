package org.generation.brazil.gfood.cliente;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;
    private String endereco;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
