package com.gabriel.tarefas.api.repository;

import com.gabriel.tarefas.api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {}