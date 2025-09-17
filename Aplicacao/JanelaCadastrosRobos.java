package Aplicacao;

import Dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JanelaCadastrosRobos {
    private JPanel painel;
    private JLabel robosCadastrados;
    private JButton botaoMostrar;
    private JTextPane arrayRobos;
    private JButton botaoVoltar;
    private ACMERobots app;
    private Robo robo;

    public JanelaCadastrosRobos(ACMERobots app, Robo robo) {
        this.robo = robo;
        this.app = app;

        botaoMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrayRobos.setText("");
                if (app.robos.isEmpty()) {
                    arrayRobos.setText("Não há nenhum robo cadastrado. Por favor Cadastre robos.");
                } else {
                    listaRobos();
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                arrayRobos.setText("");
                app.mudaPainel(1);
            }
        });
    }

    public void listaRobos(){
        ArrayList<Robo> robosC = app.getRobos();
        StringBuilder sb = new StringBuilder();
        for(Robo r : robosC){
            sb.append(r.toString()).append("\n");
        }
        arrayRobos.setText(sb.toString());
    }

    public JPanel getPainel(){
        return painel;
    }


}
