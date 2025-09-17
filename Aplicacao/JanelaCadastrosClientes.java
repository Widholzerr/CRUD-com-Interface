package Aplicacao;

import Dados.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastrosClientes {
    private JPanel painel;
    private JLabel clientesCadastrados;
    private JButton botaoMostrar;
    private JTextPane arrayClientes;
    private JButton botaoVoltar;
    private ACMERobots app;

    public JanelaCadastrosClientes(ACMERobots app, Cliente cliente) {
        this.app = app;

        botaoMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arrayClientes.setText("");
                if (app.clientes.isEmpty()) {
                    arrayClientes.setText("Não há nenhum cliente cadastrado.");
                } else {
                    listaCliente();
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(6);
            }
        });
    }

    public void listaCliente(){
        StringBuilder sb = new StringBuilder();
        for(Cliente c : app.clientes){
            sb.append(c.toString()).append("\n");
        }
        arrayClientes.setText(sb.toString());
    }

    public JPanel getPainel(){
        return painel;
    }
}
