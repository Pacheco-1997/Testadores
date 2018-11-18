/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.controller;

import br.com.azul.model.Insert;

/**
 *
 * @author Magno
 */
public class ControllLog {
    public static void AdicionarLog(String texto){
        Insert.insertLog(texto);
    }
}
