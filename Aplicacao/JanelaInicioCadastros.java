package Aplicacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Dados.*;

public class JanelaInicioCadastros {
    private JPanel painel;
    private JLabel textoInicio;
    private JButton botaoClientes;
    private JButton botaoRobos;
    private JButton botaoVoltar;

    public JanelaInicioCadastros(ACMERobots app, Robo robo, Cliente cliente){
        botaoClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(6);
            }
        });
        botaoRobos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(11);
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
