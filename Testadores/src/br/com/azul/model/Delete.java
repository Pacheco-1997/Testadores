/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Magno
 */
public class Delete {

    public int DeleteTestador(int id) {
        //Armazena Query utilizada
        String sql = "UPDATE TESTADORES"
                + " SET ATIVO  = FALSE"
                + " WHERE ID_TESTADOR = ?";

        //Obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //resultado armazena o retorno da executeUpdate
        int resultado = 0;

        //Atribui falso para evitar ponteiro nulo
        boolean ret = false;

        //Cria PreparedStatement
        PreparedStatement stm = null;

        //Tentar Executar o comando
        try {
            //Atribui valores do objeto a query
            stm = con.prepareStatement(sql);
            stm.setInt(1, id);

            //Executa o Comando            
            return resultado = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //Fecha a Conexão
            DB.getInstance().shutdown();
        }
        //Retorna a Booleana
        return resultado;
    }
}
