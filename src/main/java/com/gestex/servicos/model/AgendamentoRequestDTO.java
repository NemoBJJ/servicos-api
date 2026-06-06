package com.gestex.servicos.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendamentoRequestDTO {
    private String clienteNome;
    private String clienteEmail;
    private String clienteTelefone;
    private String tipoServico;
    private LocalDate dataAgendamento;
    private LocalTime horaAgendamento;
    private String observacao;

    public String getClienteNome() { return clienteNome; }
    public void setClienteNome(String clienteNome) { this.clienteNome = clienteNome; }
    public String getClienteEmail() { return clienteEmail; }
    public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }
    public String getClienteTelefone() { return clienteTelefone; }
    public void setClienteTelefone(String clienteTelefone) { this.clienteTelefone = clienteTelefone; }
    public String getTipoServico() { return tipoServico; }
    public void setTipoServico(String tipoServico) { this.tipoServico = tipoServico; }
    public LocalDate getDataAgendamento() { return dataAgendamento; }
    public void setDataAgendamento(LocalDate dataAgendamento) { this.dataAgendamento = dataAgendamento; }
    public LocalTime getHoraAgendamento() { return horaAgendamento; }
    public void setHoraAgendamento(LocalTime horaAgendamento) { this.horaAgendamento = horaAgendamento; }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}