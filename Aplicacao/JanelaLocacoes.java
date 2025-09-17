package Aplicacao;

import Dados.Locacao;
import Dados.Robo;
import Dados.Status;
import Dados.StatusRobo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;

public class JanelaLocacoes {
    private JPanel panel1;
    private JLabel texto;
    private JButton botaoCadastrarLocacao;
    private JButton botaoEditarLocacao;
    private JButton botaoConsultarLocacao;
    private JButton botaoVoltar;
    private JButton botaoProcessaLocacao;
    private ACMERobots app;
    private Locacao locacao;

    public JanelaLocacoes(ACMERobots app, Locacao locacao){
        this.app = app;
        this.locacao = locacao;


        botaoProcessaLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Queue<Locacao> aux = app.getFila();
                try {


                    while (!aux.isEmpty()) {
                        Locacao l = aux.poll();
                        ArrayList<Robo> aux1 = l.getRobos();
                        boolean v = true;
                        for (Locacao l1 : app.locacoesCad) {
                            if (l.getNumero() == l1.getNumero()) {
                                v = false;
                            }
                        }
                        for (Robo r : aux1) {
                            if (r.getStatusRobo().equals(StatusRobo.ALOCADO)) {
                                v = false;
                            }
                        }
                        if (v) {
                            for (Robo r1 : aux1) {
                                r1.setStatusRobo(StatusRobo.ALOCADO);
                            }
                            l.setSituacao(Status.EXECUTANDO);
                            app.adicionaLocacao(l);
                        }
                    }
                }catch (Exception i){
                    texto.setText(i.getMessage());
                }

            }
        });
        botaoCadastrarLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(15);
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(11);
            }
        });
        botaoConsultarLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(16);
            }
        });

        botaoEditarLocacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(17);
            }
        });
    }
    public JPanel getPainel(){
        return panel1;
    }
}
