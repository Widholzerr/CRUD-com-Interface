package Aplicacao;

import Dados.Industrial;
import Dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadIndustrial {
    private JPanel painel;
    private JLabel cadastroId;
    private JTextField campoId;
    private JLabel cadastroModelo;
    private JTextField campoModelo;
    private JLabel cadastroValorD;
    private JTextField campoValorD;
    private JLabel cadastroSetor;
    private JTextField campoSetor;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JLabel mensagem;
    public JanelaCadIndustrial(ACMERobots app, Robo robo) {
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
                    String setor = campoSetor.getText();
                    int id = Integer.parseInt(campoId.getText());
                    String setorA = campoSetor.getText();
                    double valor = Double.parseDouble(campoValorD.getText());
                    Industrial industrial = new Industrial(setor, id, setorA, valor);
                    if(app.adicionaRobo(industrial)) {
                        mensagem.setText("Cadastrado!");
                    }
                    else {
                        mensagem.setText("Codigo de robo ja utilizado");
                    }
                    campoId.setText("");
                    campoModelo.setText("");
                    campoSetor.setText("");
                    campoValorD.setText("");
                }catch (NumberFormatException i){
                    mensagem.setText("Erro: Id e Valor diario devem ser numéricos.");
                    campoId.setText("");
                    campoModelo.setText("");
                    campoSetor.setText("");
                    campoValorD.setText("");
                }
            }

        });
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                        mensagem.setText("");
                        campoSetor.setText("");
                        campoId.setText("");
                        campoModelo.setText("");
                        campoValorD.setText("");
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
