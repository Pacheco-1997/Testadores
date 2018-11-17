/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.model;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Aluno
 */
public class DB {

    private static DB instance = null;
    private Connection connection = null;
    private int clients = 0;

    //Cria construtor privado - padrão Singleton
    private DB() {
        try {
            //Properties - usado para ler arquivos de texto
            Properties prop = new Properties();
            prop.load(new FileInputStream("../Testadores/src/br/com/azul/model/DB.properties"));
            String dbDriver = prop.getProperty("db.driver").trim();
            String dbUrl = prop.getProperty("db.url").trim();
            String dbUser = prop.getProperty("db.user").trim();
            String dbPwd = prop.getProperty("db.pwd").trim();
            Class.forName(dbDriver);
            if (dbUser.length() != 0) { //Para ter acesso com usuario e senha
                connection = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
            } else { //Para acesso sem usuario e senha
                connection = DriverManager.getConnection(dbUrl);
            }
            System.out.println("DB[conexao OK]");
        } catch (ClassNotFoundException | IOException | SQLException ex) {
            System.err.println(ex);            
        }
    }

    //Retorna uma instancia unica    
    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    //Retorna a conexão
    public Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("connection=null");
        }
        clients++;
        System.out.println("DB[conexao cliente]" + clients);
        return connection;
    }

    //Fecha a conexão
    public void shutdown() {
        System.out.println("DB[shutdown cliente]");
        clients--;
        if (clients > 0) {
            return;
        }
        try {
            connection.close();
            instance = null;
            System.out.println("DB[conexao fechada]");
            connection = null;
        } catch (SQLException sqle) {
            System.err.print(sqle);
        }
    }

}
