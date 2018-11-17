/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.beans;

/**
 *
 * @author Magno
 */
public class SessionBeans {
    //Sera armazenada o usuário logado no sistema, para guardar seu nome no Log
    public static String Usuario;

    public static String getUsuario() {
        return Usuario;
    }

    public static void setUsuario(String Usuario) {
        SessionBeans.Usuario = Usuario;
    }
    
}
