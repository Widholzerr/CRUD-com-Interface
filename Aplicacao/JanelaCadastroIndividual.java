package Aplicacao;

import Dados.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastroIndividual {
    private JPanel painel;
    private JLabel CadastroCodigo;
    private JTextField campoCodigo;
    private JLabel CadastroNome;
    private JTextField campoNome;
    private JLabel CadastroCPF;
    private JTextField campoCPF;
    private JButton botaoVoltar;
    private JButton botaoCadastrar;
    private JButton botaoLimpar;
    private JLabel campoMensagem;


    public JanelaCadastroIndividual(ACMERobots app, Cliente cliente){

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String aux1 = campoCodigo.getText();
                    int codigo = Integer.parseInt(campoCodigo.getText());
                    String nome = campoNome.getText();
                    String cpf = campoCPF.getText();
                    Dados.Individual individual = new Dados.Individual(nome,codigo,cpf);
                    if(app.adicionaCliente(individual)) {
                        campoMensagem.setText("Cadastrado!");
                    }
                    else{
                        campoMensagem.setText("Codigo ja utilizado");
                    }
                    campoCPF.setText("");
                    campoNome.setText("");
                    campoCodigo.setText("");
                }catch (NumberFormatException i){
                    campoMensagem.setText("Erro: Campo Codigo deve ser numéricos."+ i.getMessage());
                    campoCodigo.setText("");
                    campoCPF.setText("");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(6);
            }
        });
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoMensagem.setText("");
                campoNome.setText("");
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }
}
