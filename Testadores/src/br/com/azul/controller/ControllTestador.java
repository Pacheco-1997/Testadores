/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.controller;

import br.com.azul.beans.TestadorBeans;
import br.com.azul.model.Delete;
import br.com.azul.model.Insert;
import br.com.azul.model.Select;
import br.com.azul.model.Update;
import br.com.azul.util.CpfUtil;
import java.util.InputMismatchException;

/**
 *
 * @author Magno
 */
public class ControllTestador {

    public int Cadastro(TestadorBeans TB) {
        if (TB.Nome.equals("")) {
            return -2;
        }
        if (TB.Cpf.equals("")) {
            return -3;
        }
        if (!new CpfUtil().isCPF(TB.Cpf)) {
            return -4;
        }
        if (TB.Idade < 18) {
            return -5;
        }
        return new Insert().insertTestador(TB);
    }

    public String[] Busca(String cpf) {
        //cpf = new CpfUtil().removeContaMask(cpf);
        System.out.println(cpf);
        return new Select().SelectTestador(cpf);
    }
    public TestadorBeans BuscaId(int Id){
        return new Select().SelectId(Id);
    }
    public int Atualiza(TestadorBeans TB) {
        if (TB.Nome.equals("")) {
            return -2;
        }
        if (TB.Cpf.equals("")) {
            return -3;
        }
        //Valida se o CPF é util em uma classe do pacote Util
        if (!new CpfUtil().isCPF(TB.Cpf)) {
            return -4;
        }
        if (TB.Idade < 18) {
            return -5;
        }
        return new Update().UpdateTestador(TB);
    }

    public int Exclui(int Id) {
        return new Delete().DeleteTestador(Id);
    }
}
