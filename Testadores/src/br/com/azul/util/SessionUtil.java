/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.util;

/**
 *
 * @author Magno
 */
public class SessionUtil {
    //Sera armazenada o usuário logado no sistema, para guardar seu nome no Log
    public static String Usuario;

    public static String getUsuario() {
        return Usuario;
    }

    public static void setUsuario(String Usuario) {
        SessionUtil.Usuario = Usuario;
    }
    
}
