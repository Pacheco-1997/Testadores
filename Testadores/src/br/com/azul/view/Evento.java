/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.azul.view;

import br.com.azul.beans.EnumsBeans.TipoForm;
import br.com.azul.beans.EventoBeans;
import br.com.azul.controller.ControllLog;
import br.com.azul.controller.ControllEvento;
import java.text.ParseException;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.ControllerEventListener;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Magno
 */
public class Evento extends javax.swing.JPanel {

    /**
     * Creates new form Testador
     */
    public Evento() {
        initComponents();
        ChangeTab(TipoForm.Consultar);
    }

    public void ChangeTab(TipoForm tipo) {
        //Usado para controlar o comportamento do Form
        switch (tipo) {
            case Consultar:
                InterfaceControl = TipoForm.Consultar;
                btnSalvar.setEnabled(false);
                btnVoltar.setText("Fechar");
                btnPesquisar.setEnabled(true);
                btnNovo.setEnabled(true);
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
                tabpane.setSelectedIndex(0);
                break;
            case Alterar:
                InterfaceControl = TipoForm.Alterar;
                btnSalvar.setEnabled(true);
                btnVoltar.setText("Voltar");
                btnPesquisar.setEnabled(false);
                btnNovo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                tabpane.setSelectedIndex(1);
                break;
            case Cadastrar:
                InterfaceControl = TipoForm.Cadastrar;
                btnSalvar.setEnabled(true);
                btnVoltar.setText("Voltar");
                btnPesquisar.setEnabled(false);
                btnNovo.setEnabled(false);
                btnEditar.setEnabled(false);
                btnExcluir.setEnabled(false);
                tabpane.setSelectedIndex(1);
                break;
            default:
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpane = new javax.swing.JTabbedPane();
        tabpane.enable(false);
        jpPesquisar = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        txtNomePesquisar = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTestadores = new javax.swing.JTable();
        jpDetalhar = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        txtNome = new java.awt.TextField();
        label3 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        label5 = new java.awt.Label();
        dtpDia = new org.jdesktop.swingx.JXDatePicker();
        btnPesquisar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        tabpane.setToolTipText("");
        tabpane.setName("tbDetalhar"); // NOI18N

        jpPesquisar.setName("tbPesquisar"); // NOI18N

        label1.setText("Nome:");

        jtTestadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Tempo"
            }
        ));
        jScrollPane1.setViewportView(jtTestadores);

        javax.swing.GroupLayout jpPesquisarLayout = new javax.swing.GroupLayout(jpPesquisar);
        jpPesquisar.setLayout(jpPesquisarLayout);
        jpPesquisarLayout.setHorizontalGroup(
            jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jpPesquisarLayout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 366, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpPesquisarLayout.setVerticalGroup(
            jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPesquisarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPesquisarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabpane.addTab("Pesquisar", jpPesquisar);

        jpDetalhar.setEnabled(false);

        label2.setText("Nome:");

        label3.setText("Dia");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Situação", "Observação"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        label5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        label5.setText("Produtos sendo testados:");

        javax.swing.GroupLayout jpDetalharLayout = new javax.swing.GroupLayout(jpDetalhar);
        jpDetalhar.setLayout(jpDetalharLayout);
        jpDetalharLayout.setHorizontalGroup(
            jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalharLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jpDetalharLayout.createSequentialGroup()
                        .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDetalharLayout.createSequentialGroup()
                                .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpDia, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(188, Short.MAX_VALUE))))
        );
        jpDetalharLayout.setVerticalGroup(
            jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetalharLayout.createSequentialGroup()
                .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jpDetalharLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabpane.addTab("Detalhar", jpDetalhar);

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_pesquisar.gif"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_incluir.gif"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_ok.gif"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_voltar.gif"))); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_editar.gif"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/azul/view/Imagens/novo_excluir.gif"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpane)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVoltar)
                .addGap(14, 14, 14)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabpane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(0, 65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        ChangeTab(TipoForm.Cadastrar);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        switch (InterfaceControl) {
            case Consultar:
                this.setVisible(false);
                break;
            case Alterar:
                ChangeTab(TipoForm.Consultar);
                break;
            case Cadastrar:
                ChangeTab(TipoForm.Consultar);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:

        //Seta valores no objeto
        EventoBeans EB = new EventoBeans();
        EB.setNome(txtNome.getText().trim());
        //EB.setDataEvento(dtpDia.get);

        //Armazena o retorno das operações
        int Retorno = 0;
        if (InterfaceControl == TipoForm.Cadastrar) {
            //Instanticia a Controller e manda objeto como parametro
            ControllEvento ConEven = new ControllEvento();
            Retorno = ConEven.Cadastro(EB);
        } else {
            //Armazena o valor do ID da linha selecionada e converte para Int
            String value = jtTestadores.getModel().getValueAt(jtTestadores.getSelectedRow(),
                    0).toString();
            //Converte para inteiro
            EB.setId(Integer.parseInt(value));
            //Instanticia a Controller e manda objeto como parametro
            ControllEvento ConEven = new ControllEvento();
            Retorno = ConEven.Atualiza(EB);
        }

        //Manda mensagem de acordo com o retorno
        switch (Retorno) {
            case 1:
                //Mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Evento salvo com"
                        + " sucesso!!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
                //Limpa Campos
                txtNome.setText("");

                //Informa no Log
                if (InterfaceControl == TipoForm.Cadastrar) {
                    ControllLog.AdicionarLog("Evento cadastrado Id:" + EB.getId());
                } else {
                    ControllLog.AdicionarLog("Evento alterado Id:" + EB.getId());
                }

                //Busca Eventos
                btnPesquisarActionPerformed(evt);
                ChangeTab(TipoForm.Consultar);

                break;
            case -2:
                JOptionPane.showMessageDialog(null, "Preencha o campo nome.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                break;
            case -3:
                JOptionPane.showMessageDialog(null, "Preencha o campo Dia.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:

        // cria variável do tipo DEfaultTableModel
        DefaultTableModel dtmLogin = (DefaultTableModel) jtTestadores.getModel();

        //limpa tabela
        dtmLogin.getDataVector().removeAllElements();

        //Realiza busca com o cpf digitado e armazena resultado no Array
        String[] res = new ControllEvento().Busca(txtNomePesquisar.getText());

        //tabela não editavel
        //jtTestadores.setEnabled(false);
        //imprimir tabela
        String codigo = "", nome = "", cpf = "", idade = "";
        if (res.length != 0) {
            for (int x = 0; x < res.length; x++) {
                codigo = res[x];
                nome = res[++x];
                cpf = res[++x];
                idade = res[++x];
                //imprime
                dtmLogin.addRow(new Object[]{codigo, nome, cpf, idade});
            }
        } else {
            //imprime
            dtmLogin.addRow(new Object[]{codigo, nome, cpf, idade});
            JOptionPane.showMessageDialog(null,
                    "Nenhum dado retornado na pesquisa", "Testador não encontrado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //Armazena o valor do ID da linha selecionada e converte para Int
        String value = jtTestadores.getModel().getValueAt(jtTestadores.getSelectedRow(),
                0).toString();

        //Converte para inteiro
        int Id = Integer.parseInt(value);

        //Objeto para receber a busca
        EventoBeans EB = new EventoBeans();

        //Realiza a busca das informações da linha selecionada e seta no objeto
        EB = new ControllEvento().BuscaId(Id);

        //Recebe a busca nos campos de texto
        txtNome.setText(EB.Nome);
        dtpDia.setDate(EB.DataEvento);        

        ChangeTab(TipoForm.Alterar);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //Armazena o retorno da Query        
        int retorno = 0;
        //Armazena Id selecionado
        String value = "";
        if (jtTestadores.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null,
                    "Selecione uma linha para realizar a exclusão!!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            //Solicia confirmação da exclusão
            int confirma = JOptionPane.showConfirmDialog(null, "Confirme a exclusão.",
                    "Escolha um", JOptionPane.YES_NO_OPTION);
            if (confirma == JOptionPane.NO_OPTION) {
                return;
            }
            //Armazena o valor do ID da linha selecionada e manda para a Controller
            value = jtTestadores.getModel().getValueAt(jtTestadores.getSelectedRow(),
                    0).toString();
            retorno = new ControllEvento().Exclui(Integer.parseInt(value));
        }
        if (retorno == 1) {
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Evento excluido com"
                    + " sucesso!!", "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
            ControllLog.AdicionarLog("Excluiu Testador Id:" + value);
            //Limpa Campos                
            txtNomePesquisar.setText("");

            //Busca testadores de novo
            btnPesquisarActionPerformed(evt);
            ChangeTab(TipoForm.Consultar);
        } else {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro!!", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    //Variaveis Customizadas
    //Manipula a interface
    TipoForm InterfaceControl;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private org.jdesktop.swingx.JXDatePicker dtpDia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel jpDetalhar;
    private javax.swing.JPanel jpPesquisar;
    private javax.swing.JTable jtTestadores;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label5;
    private javax.swing.JTabbedPane tabpane;
    private java.awt.TextField txtNome;
    private javax.swing.JFormattedTextField txtNomePesquisar;
    // End of variables declaration//GEN-END:variables
}
