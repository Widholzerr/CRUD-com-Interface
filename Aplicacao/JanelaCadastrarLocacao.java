package Aplicacao;

import Dados.Cliente;
import Dados.Locacao;
import Dados.Robo;
import Dados.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JanelaCadastrarLocacao {
    private JPanel painel;
    private JLabel texto;
    private JLabel textoNumero;
    private JTextField campoNumLocacao;
    private JLabel textoCliente;
    private JTextArea AreaClientes;
    private JLabel textoRobos;
    private JButton botaoCadastrar;
    private JButton botaoVoltar;
    private JTextArea areaRobos;
    private JLabel mensagem;
    private JLabel textoDataFim;
    private JTextField campoDataFim;
    private JList<Cliente> campoClientes;
    private JList<Robo> listaR;
    private JButton botaoCarrega;
    private ACMERobots app;

    public JanelaCadastrarLocacao(ACMERobots app, Locacao locacao){
        this.app = app;



        botaoCarrega.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoClientes.setModel(criaModelListC());
                listaR.setModel(criaModelListR());
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(14);
            }
        });
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    String formato = "dd/MM/yyyy";
                    SimpleDateFormat sdf = new SimpleDateFormat(formato);
                    Date data = new Date();
                    int numero = Integer.parseInt(campoNumLocacao.getText());
                    Date dataFim = sdf.parse(campoDataFim.getText());
                    Cliente cliente = (Cliente) campoClientes.getSelectedValue();
                    ArrayList<Robo> robos = new ArrayList<>(listaR.getSelectedValuesList());
                    Locacao novaLocacao = new Locacao(numero, Status.CADASTRADA, data, dataFim, cliente, robos);
                    app.addFila(novaLocacao);
                    mensagem.setText("Locação cadastrada com sucesso.");
                } catch (NumberFormatException z){
                    mensagem.setText("Data do final da locação em formato inválido ou número da locação inválido, por favor digite novamente.");
                    campoNumLocacao.setText("");
                    campoDataFim.setText("");
                } catch (Exception i){
                    mensagem.setText("Erro ao cadastrar a locação, por favor digite novamente.");
                }
            }
        });
    }
    private DefaultListModel<Cliente> criaModelListC(){
        DefaultListModel<Cliente> listModelC = new DefaultListModel<>();
        for(Cliente c : app.clientes){
            listModelC.addElement(c);
        }
        return listModelC;
    }
    private DefaultListModel<Robo> criaModelListR(){
        DefaultListModel<Robo> listModelR = new DefaultListModel<>();
        for(Robo r : app.robos){
            listModelR.addElement(r);
        }
        return listModelR;
    }
    public JPanel getPainel(){
        return painel;
    }
}
