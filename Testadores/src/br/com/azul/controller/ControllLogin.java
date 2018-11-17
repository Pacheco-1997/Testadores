/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.controller;

import br.com.azul.beans.BeansLogin;
import br.com.azul.model.Select;

/**
 *
 * @author Aluno
 */
public class ControllLogin {

    /**
     * Método otimizado este método retorna um boolean true para select ok
     *
     * @param bl do tipo BeansLogin
     * @return
     */
    public static boolean logar(BeansLogin bl) {

        //Encaminha o Objeto para Model e retorna booleana                
        return Select.selectLogin(bl);
    }
}
