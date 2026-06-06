package com.gestex.servicos.service;

import com.gestex.servicos.model.AgendamentoRequestDTO;
import com.gestex.servicos.model.ServicoAgendamento;
import com.gestex.servicos.repository.ServicoAgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ServicoAgendamentoService {

    @Autowired
    private ServicoAgendamentoRepository repository;

    public ServicoAgendamento criarAgendamento(AgendamentoRequestDTO dto) {
        ServicoAgendamento agendamento = new ServicoAgendamento();
        agendamento.setClienteNome(dto.getClienteNome());
        agendamento.setClienteEmail(dto.getClienteEmail());
        agendamento.setClienteTelefone(dto.getClienteTelefone());
        agendamento.setTipoServico(dto.getTipoServico());
        agendamento.setDataAgendamento(dto.getDataAgendamento());
        agendamento.setHoraAgendamento(dto.getHoraAgendamento());
        agendamento.setObservacao(dto.getObservacao());
        return repository.save(agendamento);
    }

    public List<ServicoAgendamento> listarTodos() {
        return repository.findAllByOrderByDataSolicitacaoDesc();
    }

    public List<ServicoAgendamento> listarPorStatus(String status) {
        return repository.findByStatus(status);
    }

    public ServicoAgendamento atualizarStatus(Long id, String novoStatus) {
        ServicoAgendamento agendamento = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));
        agendamento.setStatus(novoStatus);
        return repository.save(agendamento);
    }

    public Map<String, Long> obterEstatisticas() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("PENDENTE", (long) repository.findByStatus("PENDENTE").size());
        stats.put("CONFIRMADO", (long) repository.findByStatus("CONFIRMADO").size());
        stats.put("CONCLUIDO", (long) repository.findByStatus("CONCLUIDO").size());
        stats.put("CANCELADO", (long) repository.findByStatus("CANCELADO").size());
        return stats;
    }
}