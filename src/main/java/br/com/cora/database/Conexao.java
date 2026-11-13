package br.com.cora.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    public static Connection conectar() throws IOException, SQLException {

        Properties propriedades = new Properties();

        try (InputStream arquivo = Conexao.class
                .getClassLoader()
                .getResourceAsStream("database/db.properties")) {

            if (arquivo == null) {
                throw new FileNotFoundException(
                    "Arquivo db.properties não encontrado."
                );
            }

            propriedades.load(arquivo);
        }

        String url = propriedades.getProperty("db.url");
        String usuario = propriedades.getProperty("user");
        String senha = propriedades.getProperty("password");

        return DriverManager.getConnection(url, usuario, senha);
    }
}