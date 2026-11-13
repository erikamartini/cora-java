
package br.com.cora.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento {

    private Integer idAgendamento;
    private LocalDate data;
    private LocalTime horario;
    private String descricao;
    private String status;
    private Integer idUsuario;
    private Integer idCliente;

    // Construtor vazio
    public Agendamento() {
    }

    // Construtor completo
    public Agendamento(Integer idAgendamento, LocalDate data,
                       LocalTime horario, String descricao,
                       String status, Integer idUsuario,
                       Integer idCliente) {

        this.idAgendamento = idAgendamento;
        this.data = data;
        this.horario = horario;
        this.descricao = descricao;
        this.status = status;
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
    }

    // Getters e Setters
    public Integer getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Integer idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
