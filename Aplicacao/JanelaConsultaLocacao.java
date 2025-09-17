package Aplicacao;

import Dados.Cliente;
import Dados.Locacao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaConsultaLocacao {
    private JPanel painel;
    private JLabel textoLocacao;
    private JButton botaoConsultar;
    private JButton botaoVoltar;
    private JTextArea areaLocacao;
    private ACMERobots app;
    private Locacao locacao;

    public JanelaConsultaLocacao(ACMERobots app, Locacao locacao){
        this.app = app;
        this.locacao = locacao;

        botaoConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaLocacoes();
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(14);
            }
        });
    }

    public void listaLocacoes(){
        StringBuilder sb = new StringBuilder();
        for(Locacao l : app.locacoesCad){
            sb.append(l.toString()).append("\n");
        }
        areaLocacao.setText(sb.toString());
    }

    public JPanel getPainel(){
        return painel;
    }
}
