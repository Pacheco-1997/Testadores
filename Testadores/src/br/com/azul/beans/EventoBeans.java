/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.beans;

import java.util.Calendar;

/**
 *
 * @author Magno
 */
public class EventoBeans {
    public int Id;
    public String Nome;
    public Calendar DataEvento; //Tipo Date foi depreciado

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Calendar getDataEvento() {
        return DataEvento;
    }

    public void setDataEvento(Calendar DataEvento) {
        this.DataEvento = DataEvento;
    }
}
