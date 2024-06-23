package com.xavier.repository;

import com.xavier.model.Aluno;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {
    
}
