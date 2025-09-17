package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaInicioSistema {
    private JPanel painel;
    private JLabel textoInicial;
    private JButton botaoAreaCadastros;
    private JButton botaoConsultarLocacoes;
    private JButton botaoCarregarDados;
    private JButton botaoSalvarDados;
    private JButton botaoFinalizar;
    private ACMERobots app;
    private Robo robo;
    private Cliente cliente;

    public JanelaInicioSistema(ACMERobots app, Robo robo, Cliente cliente){
        this.app = app;
        this.robo = robo;
        this.cliente = cliente;
        botaoAreaCadastros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(10);
            }
        });
        botaoCarregarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(12);
            }
        });
        botaoSalvarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(13);
            }
        });
        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        botaoConsultarLocacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(14);
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }

}
