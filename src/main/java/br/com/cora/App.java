
package br.com.cora;

import java.sql.Connection;

import br.com.cora.database.Conexao;

public class App {

    public static void main(String[] args) {

        try (Connection conexao = Conexao.conectar()) {

            if (conexao.isValid(5)) {
                System.out.println(
                    "Conexao com PostgreSQL realizada com sucesso!"
                );
            }

        } catch (Exception e) {
            System.out.println("Erro na conexao:");
            e.printStackTrace();
        }
    }
}
