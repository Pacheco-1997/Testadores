/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

import br.com.azul.beans.BeansLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Select {

    /**
     * Método selectLogin verifica se usuário e senha esta correto e retorna um
     * boolean true quando encontra usuario e senha e false em caso de falha
     *
     * @param bl tipo BeaansLogin
     * @return
     */
    public static boolean selectLogin(BeansLogin bl) {

        //Obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //cria seção interativa SQL
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //ResultSet armazena retorno da executeQuery
        ResultSet rs = null;

        //Atribui falso para evitar ponteiro nulo
        boolean ret = false;

        //Tentar fazer o comando
        try {
            //Comando SQL
            //Executa query
            rs = stm.executeQuery("SELECT * FROM " + bl.getTabela()
                    + " WHERE usuario='" + bl.getUsuario()
                    + "' AND senha='" + bl.getSenha() + "'");

            //Caso tenha retorno da query retorna true
            ret = rs.next();

            //Abre a conexão
            DB.getInstance().getConnection();

            //Retorna a booleana
            return ret;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Fecha a Conexão
        DB.getInstance().shutdown();

        //Retorna Booleana
        return ret;
    }

//    public String[] SelectPesquisarUsuario(BeansPesquisarUsuario bpl) {
//        //Variavel que recebe o conteudo da pesquisa
//        String Usuario = bpl.getUsuario();
//
//        //variavel para retornar os resultados da pesquisa
//        ArrayList<String> item = new ArrayList<>();
//
//        //cria seção interativa SQL
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        //obtem a conexão
//        Connection con = DB.getInstance().getConnection();
//
//        if (Usuario.equals("")) {
//            //Se a pesquisa for vazia, traz todos os registros
//            try {
//                String sql = "SELECT ID, USUARIO, SENHA, ATIVO"
//                        + " FROM TB_USUARIO";
//                stmt = con.prepareStatement(sql);
//                rs = stmt.executeQuery(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } else {
//            //Pesquisa especifica
//            String sql = "SELECT ID, USUARIO, SENHA, ATIVO"
//                    + " FROM TB_USUARIO"
//                    + " WHERE USUARIO LIKE ?";
//            try {
//                stmt = con.prepareStatement(sql);
//                stmt.setString(1, "%" + Usuario + "%");
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//            //Executa a Query
//            try {
//                rs = stmt.executeQuery();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        try {
//            //Salva as propriedades do objeto ResultSet incluindo
//            //columncount
//            ResultSetMetaData rsmd = rs.getMetaData();
//            int columnCount = rsmd.getColumnCount();
//            while (rs.next()) {
//                int i = 1;
//                while (i <= columnCount) {
//                    item.add(rs.getString(i++));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        //Converte o array list em array
//        String[] itemArr = new String[item.size()];
//        itemArr = item.toArray(itemArr);
//
//        //Encerra a pesquisa no banco e fecha a conexão
//        try {
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            stmt.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        DB.getInstance().shutdown();
//
//        //Retorna o array da pesquisa
//        return itemArr;
//    }
}
