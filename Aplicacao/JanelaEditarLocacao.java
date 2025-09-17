package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaEditarLocacao {
    private JPanel painel;
    private JList<Locacao> list1;
    private JButton botaoVoltar;
    private JButton botaoExcluir;
    private JButton botaoCarregar;
    private JButton botaoFinalizar;
    private JEditorPane editorPane1;

    private ACMERobots app;

    JanelaEditarLocacao(ACMERobots app, Locacao locacao){
        this.app = app;
        botaoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.setModel(criaModelListL());

            }
        });

        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locacao loc = (Locacao) list1.getSelectedValue();
                if(loc.getSituacao().equals(Status.FINALIZADA) ||loc.getSituacao().equals(Status.CANCELADA)){
                    editorPane1.setText("Locacao FINALIZADA ou CANCELADA nao podem ser alteradas");
                }
                else {
                    for(Robo r1 : loc.getRobos()){
                        r1.setStatusRobo(StatusRobo.DISPONIVEL);
                    }
                    loc.setSituacao(Status.CANCELADA);
                }
            }
        });

        botaoFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Locacao loc = (Locacao) list1.getSelectedValue();
                if(loc.getSituacao().equals(Status.FINALIZADA) ||loc.getSituacao().equals(Status.CANCELADA)){
                    editorPane1.setText("Locacao FINALIZADA ou CANCELADA nao podem ser alteradas");
                }
                else {
                    for (Robo r1 : loc.getRobos()) {
                        r1.setStatusRobo(StatusRobo.DISPONIVEL);
                    }
                    loc.setSituacao(Status.FINALIZADA);
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(14);
            }
        });

    }
    private DefaultListModel<Locacao> criaModelListL() {
        DefaultListModel<Locacao> listModelL = new DefaultListModel<>();
        for (Locacao l : app.locacoesCad) {
            listModelL.addElement(l);
        }
        return listModelL;
    }
    public JPanel getPainel() {
        return painel;
    }
}
