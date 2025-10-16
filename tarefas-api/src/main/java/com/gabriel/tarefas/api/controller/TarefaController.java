package com.gabriel.tarefas.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabriel.tarefas.api.model.Tarefa;
import com.gabriel.tarefas.api.repository.TarefaRepository;

@RestController
@RequestMapping("/api")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    @PostMapping("/tarefas")
    public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
        Tarefa salva = tarefaRepository.save(tarefa);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(salva.getId()).toUri();
        return ResponseEntity.created(location).body(salva);
    }

    @GetMapping("/tarefas")
    public ResponseEntity<List<Tarefa>> listarTarefas() {
        List<Tarefa> lista = tarefaRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> obterTarefa(@PathVariable Long id) {
        Optional<Tarefa> opt = tarefaRepository.findById(id);
        return opt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa dados) {
        Optional<Tarefa> opt = tarefaRepository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Tarefa existente = opt.get();
        existente.setDescricao(dados.getDescricao());
        existente.setResponsavel(dados.getResponsavel());
        existente.setDataEntrega(dados.getDataEntrega());
        Tarefa atualizado = tarefaRepository.save(existente);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity<Void> excluirTarefa(@PathVariable Long id) {
        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        tarefaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
