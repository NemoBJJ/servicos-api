package com.gestex.servicos.repository;

import com.gestex.servicos.model.ServicoAgendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicoAgendamentoRepository extends JpaRepository<ServicoAgendamento, Long> {
    List<ServicoAgendamento> findAllByOrderByDataSolicitacaoDesc();
    List<ServicoAgendamento> findByStatus(String status);
}