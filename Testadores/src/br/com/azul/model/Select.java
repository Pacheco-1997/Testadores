/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

import br.com.azul.beans.BeansLogin;
import br.com.azul.beans.ProdutoBeans;
import br.com.azul.beans.TestadorBeans;
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
    // <editor-fold defaultstate="collapsed" desc="Login">
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
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Testador">
    public String[] SelectTestador(String cpf) {

        //variavel para retornar os resultados da pesquisa
        ArrayList<String> item = new ArrayList<>();

        //cria seção interativa SQL
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //Campo possui mascara por isso o teste é feito com pontos e traço
        if (cpf.equals("   .   .   -  ")) {
            //Se a pesquisa for vazia, traz todos os registros
            try {
                String sql = "SELECT ID_TESTADOR, NOME_TESTADOR, CPF, IDADE"
                        + " FROM TESTADORES"
                        + " WHERE ATIVO = TRUE";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //Pesquisa especifica
            String sql = "SELECT ID_TESTADOR, NOME_TESTADOR, CPF, IDADE"
                    + " FROM TESTADORES"
                    + " WHERE ATIVO = TRUE"
                    + " AND CPF = ?";
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, cpf);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Executa a Query
            try {
                rs = stmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        try {
            //Salva as propriedades do objeto ResultSet incluindo
            //columncount
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    item.add(rs.getString(i++));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Converte o array list em array
        String[] itemArr = new String[item.size()];
        itemArr = item.toArray(itemArr);

        //Encerra a pesquisa no banco e fecha a conexão
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DB.getInstance().shutdown();

        //Retorna o array da pesquisa
        return itemArr;
    }

    public TestadorBeans SelectId(int Id) {
        //Armazena Query utilizada
        String sql = "SELECT * FROM TESTADORES"
                + " WHERE ID_TESTADOR = ?";

        //variavel para retornar os resultados da pesquisa
        ArrayList<String> item = new ArrayList<>();

        //cria seção interativa SQL
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //Prepara
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Executa a Query
        try {
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //Salva as propriedades do objeto ResultSet incluindo
            //columncount
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    item.add(rs.getString(i++));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        TestadorBeans TB = new TestadorBeans();
        try {
            //Converte o array list em objeto do tipo TestadorBeans
            String[] itemArr = new String[item.size()];
            itemArr = item.toArray(itemArr);
            TB.setNome(item.get(1));
            TB.setCpf(item.get(2));
            TB.setIdade(Integer.parseInt(item.get(3)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Encerra a pesquisa no banco e fecha a conexão
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DB.getInstance().shutdown();

        //Retorna o array da pesquisa
        return TB;
    }
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Produto">
    public String[] SelectProduto(String nome) {

        //variavel para retornar os resultados da pesquisa
        ArrayList<String> item = new ArrayList<>();

        //cria seção interativa SQL
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //Campo possui mascara por isso o teste é feito com pontos e traço
        if (nome.equals("")) {
            //Se a pesquisa for vazia, traz todos os registros
            try {
                String sql = "SELECT ID_PRODUTO, NOME_PRODUTO, SITUACAO, OBS"
                        + " FROM PRODUTO"
                        + " WHERE ATIVO = TRUE";
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //Pesquisa especifica
            String sql = "SELECT ID_PRODUTO, NOME_PRODUTO, SITUACAO, OBS"
                    + " FROM PRODUTO"
                    + " WHERE ATIVO = TRUE"
                    + " AND NOME_PRODUTO = ?";
            try {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, nome);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //Executa a Query
            try {
                rs = stmt.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        try {
            //Salva as propriedades do objeto ResultSet incluindo
            //columncount
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    item.add(rs.getString(i++));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Converte o array list em array
        String[] itemArr = new String[item.size()];
        itemArr = item.toArray(itemArr);

        //Encerra a pesquisa no banco e fecha a conexão
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DB.getInstance().shutdown();

        //Retorna o array da pesquisa
        return itemArr;
    }

    public ProdutoBeans SelectIdProduto(int Id) {
        //Armazena Query utilizada
        String sql = "SELECT * FROM PRODUTO"
                + " WHERE ID_PRODUTO = ?";

        //variavel para retornar os resultados da pesquisa
        ArrayList<String> item = new ArrayList<>();

        //cria seção interativa SQL
        PreparedStatement stmt = null;
        ResultSet rs = null;

        //obtem a conexão
        Connection con = DB.getInstance().getConnection();

        //Prepara
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, Id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Executa a Query
        try {
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            //Salva as propriedades do objeto ResultSet incluindo
            //columncount
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (rs.next()) {
                int i = 1;
                while (i <= columnCount) {
                    item.add(rs.getString(i++));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ProdutoBeans PB = new ProdutoBeans();
        try {
            //Converte o array list em objeto do tipo ProdutoBeans
            String[] itemArr = new String[item.size()];
            itemArr = item.toArray(itemArr);
            PB.setNome(item.get(1));
            //gambiarra marota para converter direto de String
            if (item.get(2).equals("1")) {
                PB.setSituacao(true);
            } else {
                PB.setSituacao(false);
            }
                        
            PB.setObservacao(item.get(3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Encerra a pesquisa no banco e fecha a conexão
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DB.getInstance().shutdown();

        //Retorna o array da pesquisa
        return PB;
    }
    // </editor-fold>
}
