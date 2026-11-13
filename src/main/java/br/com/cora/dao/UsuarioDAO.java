package br.com.cora.dao;

import br.com.cora.database.Conexao;
import br.com.cora.model.Usuario;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void inserir(Usuario usuario) throws SQLException, IOException {

        String sql = "INSERT INTO usuario (nome, email, telefone) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());

            stmt.executeUpdate();
        }
    }

    public List<Usuario> listarTodos() throws SQLException, IOException {

        String sql = "SELECT * FROM usuario";

        List<Usuario> usuarios = new ArrayList<>();

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                Usuario usuario = new Usuario(
                    resultado.getInt("id_usuario"),
                    resultado.getString("nome"),
                    resultado.getString("email"),
                    resultado.getString("telefone")
                );

                usuarios.add(usuario);
            }
        }

        return usuarios;
    }
}