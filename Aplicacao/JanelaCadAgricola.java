package Aplicacao;

import Dados.Agricola;
import Dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadAgricola {
    private JPanel painel;
    private JLabel CadastroId;
    private JTextField campoId;
    private JLabel CadastroModelo;
    private JTextField campoModelo;
    private JLabel CadastroValor;
    private JTextField campoValor;
    private JLabel CadastroArea;
    private JTextField campoArea;
    private JLabel CadastroUso;
    private JTextField campoUso;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JLabel campoMensagem;

    public JanelaCadAgricola(ACMERobots app, Robo robo){
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double area = Double.parseDouble(campoArea.getText());
                    String uso = campoUso.getText();
                    int id = Integer.parseInt(campoId.getText());
                    String modelo = campoModelo.getText();
                    double valor = Double.parseDouble(campoValor.getText());
                    Agricola agricola = new Agricola(area, uso, id, modelo, valor);
                    if(app.adicionaRobo(agricola)) {
                        campoMensagem.setText("Cadastrado!");
                    }
                    else {
                        campoMensagem.setText("Codigo de robo ja utilizado");
                    }
                    campoId.setText("");
                    campoValor.setText("");
                    campoArea.setText("");
                    campoModelo.setText("");
                    campoUso.setText("");
                }catch (NumberFormatException i){
                    campoMensagem.setText("Erro: Área, Id e Valor diario devem ser numéricos.");
                    campoId.setText("");
                    campoValor.setText("");
                    campoArea.setText("");
                    campoModelo.setText("");
                    campoUso.setText("");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoMensagem.setText("");
                campoArea.setText("");
                campoId.setText("");
                campoModelo.setText("");
                campoUso.setText("");
                campoValor.setText("");
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
