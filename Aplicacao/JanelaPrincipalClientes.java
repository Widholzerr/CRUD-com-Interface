package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipalClientes {
    private JPanel painel;
    private JButton individualButton;
    private JButton empresarialButton;
    private JButton cadastros;
    private JButton botaoVoltar;

    public JanelaPrincipalClientes(ACMERobots app , Cliente cliente){


        individualButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(7);
            }
        });
        empresarialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(8);
            }
        });
        cadastros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(9);
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(10);
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
