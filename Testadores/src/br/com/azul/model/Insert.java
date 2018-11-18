/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

//import br.com.azul.beans.BeansUsuario;
import br.com.azul.beans.TestadorBeans;
import br.com.azul.util.SessionUtil;
import br.com.azul.util.TempoUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author Aluno
 */
public class Insert {

    public static int insertLog(String texto) {
        //Armazena Query utilizada
        String sql = "INSERT INTO LOGUI(TEXTO, TEMPO, USUARIO_LOG) "
                + "VALUES (?,?,?)";

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
            stm.setString(1, texto);
            stm.setDate(2, TempoUtil.getCurrentDate());
            stm.setString(3, SessionUtil.getUsuario());

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

    public static int insertTestador(TestadorBeans tb) {

        //Armazena Query utilizada
        String sql = "INSERT INTO TESTADORES(NOME_TESTADOR, CPF, IDADE) "
                + "VALUES (?,?,?)";

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
            stm.setString(1, tb.getNome());
            stm.setString(2, tb.getCpf());
            stm.setInt(3, tb.getIdade());

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
