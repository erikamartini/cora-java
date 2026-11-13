package br.com.cora.dao;

import br.com.cora.database.Conexao;
import br.com.cora.model.Agendamento;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAO {

    public void inserir(Agendamento agendamento) throws SQLException, IOException {

        String sql = "INSERT INTO agendamento "
                + "(data, horario, descricao, status, id_usuario, id_cliente) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(agendamento.getData()));
            stmt.setTime(2, java.sql.Time.valueOf(agendamento.getHorario()));
            stmt.setString(3, agendamento.getDescricao());
            stmt.setString(4, agendamento.getStatus());
            stmt.setInt(5, agendamento.getIdUsuario());
            stmt.setInt(6, agendamento.getIdCliente());

            stmt.executeUpdate();
        }
    }

    public List<Agendamento> listarTodos() throws SQLException, IOException {

        String sql = "SELECT * FROM agendamento";

        List<Agendamento> agendamentos = new ArrayList<>();

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Agendamento agendamento = new Agendamento(
                    resultado.getInt("id_agendamento"),
                    resultado.getDate("data").toLocalDate(),
                    resultado.getTime("horario").toLocalTime(),
                    resultado.getString("descricao"),
                    resultado.getString("status"),
                    resultado.getInt("id_usuario"),
                    resultado.getInt("id_cliente")
                );

                agendamentos.add(agendamento);
            }
        }

        return agendamentos;
    }
}
