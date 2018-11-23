/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

import br.com.azul.beans.EventoBeans;
import br.com.azul.beans.TestadorBeans;
import br.com.azul.beans.ProdutoBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Magno
 */
public class Update {

    public int UpdateTestador(TestadorBeans TB) {
        //Armazena Query utilizada
        String sql = "UPDATE TESTADORES"
                + " SET NOME_TESTADOR  = ?,"
                + " CPF = ?,"
                + " IDADE = ?"
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
            stm.setString(1, TB.getNome());
            stm.setString(2, TB.getCpf());
            stm.setInt(3, TB.getIdade());
            stm.setInt(4, TB.getId());

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

    public int UpdateProduto(ProdutoBeans PB) {
        //Armazena Query utilizada
        String sql = "UPDATE PRODUTO"
                + " SET NOME_PRODUTO  = ?,"
                + " SITUACAO = ?,"
                + " OBS = ?"
                + " WHERE ID_PRODUTO = ?";

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
            stm.setString(1, PB.getNome());
            stm.setBoolean(2, PB.isSituacao());
            stm.setString(3, PB.getObservacao());
            stm.setInt(4, PB.getId());

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
    
    public int UpdateEvento(EventoBeans TB) {
        //Armazena Query utilizada
        String sql = "UPDATE EVENTOS"
                + " SET NOME_EVENTO  = ?,"
                + " TEMPO_EVENTO = ?,"
                + " WHERE ID_EVENTO = ?";

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
            stm.setString(1, TB.getNome());
            stm.setDate(2, TB.getDataEvento());
            stm.setInt(3, TB.getId());            

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
