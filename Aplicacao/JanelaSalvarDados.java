package Aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaSalvarDados {
    private JPanel painel;
    private JLabel texto;
    private JLabel texto2;
    private JTextField campoNomeArquivo;
    private JLabel mensagem;
    private JButton botaoSalvar;
    private JButton botaoVoltar;
    private ACMERobots app;

    public JanelaSalvarDados(ACMERobots app) {
        this.app = app;
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //stream
                } catch (Exception i){
                    mensagem.setText("Falha ao salvar o arquivo, tente novamente.");
                    campoNomeArquivo.setText(" ");
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(11);
            }
        });

    }

    public JPanel getPainel (){
        return painel;
    }

}
