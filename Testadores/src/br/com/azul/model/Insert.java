/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

//import br.com.azul.beans.BeansUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Insert {

//    public static int cadastrarUsuario(BeansUsuario bu) {
//
//        //Armazena Query utilizada
//        String sql = "INSERT INTO TB_USUARIO(NOME, EMAIL, USUARIO, "
//                + "SENHA) VALUES (?,?,?,?)";
//
//        //Obtem a conexão
//        Connection con = DB.getInstance().getConnection();
//        
//        //resultado armazena o retorno da executeUpdate
//        int resultado=0;
//
//        //Atribui falso para evitar ponteiro nulo
//        boolean ret = false;
//
//        //Cria PreparedStatement
//        PreparedStatement stm = null;
//
//        //Tentar Executar o comando
//        try {
//            //Atribui valores do objeto a query
//            stm = con.prepareStatement(sql);
//            stm.setString(1, bu.getNome());
//            stm.setString(2, bu.getEmail());
//            stm.setString(3, bu.getUsuario());
//            stm.setString(4, bu.getSenha());
//
//            //Executa o Comando            
//            return resultado = stm.executeUpdate();
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            //Fecha a Conexão
//            DB.getInstance().shutdown();
//        }
//        //Retorna a Booleana
//        return resultado;
//    }
}
