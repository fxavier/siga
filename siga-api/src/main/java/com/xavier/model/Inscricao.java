package com.xavier.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inscricao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ano_lectivo")
    private Integer anoLectivo;
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_inscricao")
    private StatusInscricao statusInscricao;
}
