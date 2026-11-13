package br.com.cora.dao;

import br.com.cora.database.Conexao;
import br.com.cora.model.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void inserir(Cliente cliente) throws SQLException, IOException {

        String sql = "INSERT INTO cliente "
                + "(nome, telefone, email, observacoes, id_usuario) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getObservacoes());
            stmt.setInt(5, cliente.getIdUsuario());

            stmt.executeUpdate();
        }
    }

    public List<Cliente> listarTodos() throws SQLException, IOException {

        String sql = "SELECT * FROM cliente";

        List<Cliente> clientes = new ArrayList<>();

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Cliente cliente = new Cliente(
                    resultado.getInt("id_cliente"),
                    resultado.getString("nome"),
                    resultado.getString("telefone"),
                    resultado.getString("email"),
                    resultado.getString("observacoes"),
                    resultado.getInt("id_usuario")
                );

                clientes.add(cliente);
            }
        }

        return clientes;
    }
}