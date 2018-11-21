/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.controller;

import br.com.azul.beans.ProdutoBeans;
import br.com.azul.beans.TestadorBeans;
import br.com.azul.model.Delete;
import br.com.azul.model.Insert;
import br.com.azul.model.Select;
import br.com.azul.model.Update;
import br.com.azul.util.CpfUtil;

/**
 *
 * @author Aluno
 */
public class ControllProduto {

    public int Cadastro(ProdutoBeans PB) {
        if (PB.Nome.equals("")) {
            return -2;
        }
        return new Insert().insertProduto(PB);
    }
    
    public int Atualiza(ProdutoBeans PB) {
        if (PB.Nome.equals("")) {
            return -2;
        }
        return new Update().UpdateProduto(PB);
    }
    public String[] Busca(String nome) {
        //cpf = new CpfUtil().removeContaMask(cpf);
        System.out.println(nome);
        return new Select().SelectProduto(nome);
    }
    
    public ProdutoBeans BuscaId(int Id){
        return new Select().SelectIdProduto(Id);
    }
    
    public int Exclui(int Id) {
        return new Delete().DeleteProduto(Id);
    }
}
