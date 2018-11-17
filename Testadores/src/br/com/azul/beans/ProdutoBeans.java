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
public class ProdutoBeans {
    public int Id;
    public String Nome;
    public boolean Situacao;
    public String Observacao;

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

    public boolean isSituacao() {
        return Situacao;
    }

    public void setSituacao(boolean Situacao) {
        this.Situacao = Situacao;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }
}
