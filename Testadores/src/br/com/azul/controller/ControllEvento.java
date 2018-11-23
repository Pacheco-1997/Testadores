/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.controller;

import br.com.azul.beans.EventoBeans;
import br.com.azul.model.Delete;
import br.com.azul.model.Insert;
import br.com.azul.model.Select;
import br.com.azul.model.Update;

/**
 *
 * @author Aluno
 */
public class ControllEvento {

    public int Cadastro(EventoBeans EB) {
        if (EB.Nome.equals("")) {
            return -2;
        }
        if (EB.DataEvento.equals("")) {
            return -3;
        }
        return new Insert().insertEvento(EB);
    }

    public int Atualiza(EventoBeans EB) {
        if (EB.Nome.equals("")) {
            return -2;
        }
        return new Update().UpdateEvento(EB);
    }

    public String[] Busca(String nome) {
        System.out.println(nome);
        return new Select().SelectEvento(nome);
    }

    public EventoBeans BuscaId(int Id) {
        return new Select().SelectIdEvento(Id);
    }

    public int Exclui(int Id) {
        return new Delete().DeleteProduto(Id);
    }
}
