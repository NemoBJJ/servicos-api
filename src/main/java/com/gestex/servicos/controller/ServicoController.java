package com.gestex.servicos.controller;

import com.gestex.servicos.model.AgendamentoRequestDTO;
import com.gestex.servicos.model.ServicoAgendamento;
import com.gestex.servicos.service.ServicoAgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/servicos")
@CrossOrigin(origins = {"http://localhost:3002", "http://localhost:3003"})
public class ServicoController {

    @Autowired
    private ServicoAgendamentoService service;

    @PostMapping("/agendar")
    public ResponseEntity<ServicoAgendamento> agendar(@RequestBody AgendamentoRequestDTO dto) {
        return ResponseEntity.ok(service.criarAgendamento(dto));
    }

    @GetMapping("/agendamentos")
    public ResponseEntity<List<ServicoAgendamento>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/agendamentos/status/{status}")
    public ResponseEntity<List<ServicoAgendamento>> listarPorStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.listarPorStatus(status));
    }

    @PutMapping("/agendamentos/{id}/status")
    public ResponseEntity<ServicoAgendamento> atualizarStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        return ResponseEntity.ok(service.atualizarStatus(id, body.get("status")));
    }

    @GetMapping("/estatisticas")
    public ResponseEntity<Map<String, Long>> obterEstatisticas() {
        return ResponseEntity.ok(service.obterEstatisticas());
    }
}