package Aplicacao;

import Dados.Domestico;
import Dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadDomestico {
    private JLabel cadastroId;
    private JTextField campoId;
    private JLabel cadastroModelo;
    private JTextField campoModelo;
    private JLabel cadastroValorD;
    private JTextField campoValorD;
    private JLabel cadastroNivel;
    private JTextField campoNivel;
    private JLabel mensagem;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JPanel painel;
    public JanelaCadDomestico(ACMERobots app, Robo robo){
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nivel = Integer.parseInt(campoNivel.getText());
                    String modelo = campoModelo.getText();
                    int id = Integer.parseInt(campoId.getText());
                    double valorD = Double.parseDouble(campoValorD.getText());
                    Domestico domestico = new Domestico(nivel, id, modelo, valorD);
                    if(app.adicionaRobo(domestico)) {
                        mensagem.setText("Cadastrado!");
                    }
                    else {
                        mensagem.setText("Codigo de robo ja utilizado");
                    }
                    campoModelo.setText("");
                    campoId.setText("");
                    campoNivel.setText("");
                    campoValorD.setText("");
                } catch (NumberFormatException i){
                    mensagem.setText("Erro: Id e Valor diario devem ser numéricos.");
                    campoModelo.setText("");
                    campoId.setText("");
                    campoNivel.setText("");
                    campoValorD.setText("");
                }
            }
        });
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoModelo.setText("");
                campoId.setText("");
                campoNivel.setText("");
                campoValorD.setText("");
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
