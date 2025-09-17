package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastroEmpresarial {
    private JLabel cadastroCodigo;
    private JTextField campoCodigo;
    private JLabel cadastroNome;
    private JTextField campoNome;
    private JLabel cadastroAno;
    private JTextField campoAno;
    private JLabel mensagem;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JPanel painel;

    public JanelaCadastroEmpresarial(ACMERobots app, Cliente cliente){
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(6);
            }
        });
        botaoCadastrar.addActionListener(e -> {
            try {
                int ano = Integer.parseInt(campoAno.getText());
                String nome = campoNome.getText();
                int codigo = Integer.parseInt(campoCodigo.getText());
                Dados.Empresarial emp = new Dados.Empresarial(nome, codigo, ano);

                if(app.adicionaCliente(emp)) {
                    mensagem.setText("Cadastrado!");
                }
                else{
                    mensagem.setText("Codigo ja utilizado");
                }
                campoAno.setText("");
                campoNome.setText("");
                campoCodigo.setText("");
            } catch (NumberFormatException i){
                mensagem.setText("Erro: Codigo e Ano diario devem ser numéricos.");
                campoCodigo.setText("");
                campoAno.setText("");
            }
        });
        botaoLimpar.addActionListener(e -> {
            campoNome.setText("");
            campoCodigo.setText("");
            campoAno.setText("");
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
