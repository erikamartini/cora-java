package br.com.cora;

import br.com.cora.dao.AgendamentoDAO;
import br.com.cora.model.Agendamento;

import java.time.LocalDate;
import java.time.LocalTime;

public class App {

    public static void main(String[] args) {

        try {
            AgendamentoDAO dao = new AgendamentoDAO();

            Agendamento agendamento = new Agendamento(
                null,
                LocalDate.of(2026, 11, 20),
                LocalTime.of(14, 30),
                "Sessao de teste",
                "PENDENTE",
                1,
                1
            );

            dao.inserir(agendamento);

            System.out.println("Agendamento cadastrado com sucesso!");

            System.out.println("\nAgendamentos cadastrados:");

            for (Agendamento a : dao.listarTodos()) {
                System.out.println(
                    a.getIdAgendamento() + " - " +
                    a.getData() + " - " +
                    a.getHorario() + " - " +
                    a.getDescricao() + " - " +
                    a.getStatus()
                );
            }

        } catch (Exception e) {
            System.out.println("Erro ao executar o teste:");
            e.printStackTrace();
        }
    }
}