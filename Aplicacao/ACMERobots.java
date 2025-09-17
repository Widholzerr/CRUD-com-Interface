package Aplicacao;

import Dados.Cliente;
import Dados.Locacao;
import Dados.Robo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ACMERobots extends JFrame {
        private final JanelaInicioSistema jInicioSistema;
        private final JanelaInicioCadastros jInicioCadastro;
        private final JanelaPrincipal jInicioRobos;
        private final JanelaCadAgricola jCadAgricola;
        private final JanelaCadDomestico jCadDomestico;
        private final JanelaCadIndustrial jCadIndustrial;
        private final JanelaCadastrosRobos jRobosCadastrados;
        private final JanelaPrincipalClientes jPrincipalClientes;
        private final JanelaCadastroIndividual jCadIndividual;
        private final JanelaCadastroEmpresarial jCadEmpresarial;
        private final JanelaCadastrosClientes jCadstroCliente;
        private final JanelaCarregarDados jCarregarDados;
        private final JanelaSalvarDados jSalvarDados;
        private final JanelaLocacoes jLocacoes;
        private final JanelaCadastrarLocacao jCadastrarLocacao;
        private final JanelaConsultaLocacao jConsultaLocacao;
        private final JanelaEditarLocacao janelaEditarLocacao;
        private Cliente cliente;
        private Robo robo;
        private Locacao locacao;
        ArrayList<Robo> robos ;
        ArrayList<Cliente> clientes ;
        ArrayList<Locacao> locacoesCad ;
        Queue<Locacao> fila;

        public ACMERobots(){
            super();
            this.robo = robo;
            this.cliente = cliente;
            this.locacao = locacao;
            this.robos = new ArrayList<>();
            this.clientes=new ArrayList<>();
            this.locacoesCad = new ArrayList<>();
            this.fila = new LinkedList<>();
            jInicioCadastro = new JanelaInicioCadastros(this, robo, cliente);
            jInicioSistema = new JanelaInicioSistema(this, robo, cliente);
            jCarregarDados = new JanelaCarregarDados(this);
            jLocacoes = new JanelaLocacoes(this, locacao);
            jSalvarDados = new JanelaSalvarDados(this);
            jInicioRobos = new JanelaPrincipal(this, robo);
            jCadAgricola = new JanelaCadAgricola(this, robo);
            jCadDomestico = new JanelaCadDomestico(this, robo);
            jCadIndustrial = new JanelaCadIndustrial(this, robo);
            jRobosCadastrados = new JanelaCadastrosRobos(this, robo);
            jPrincipalClientes = new JanelaPrincipalClientes(this, cliente);
            jCadIndividual = new JanelaCadastroIndividual(this, cliente);
            jCadEmpresarial = new JanelaCadastroEmpresarial(this, cliente);
            jCadstroCliente = new JanelaCadastrosClientes(this, cliente);
            jCadastrarLocacao = new JanelaCadastrarLocacao(this, locacao);
            jConsultaLocacao = new JanelaConsultaLocacao(this, locacao);
            janelaEditarLocacao = new JanelaEditarLocacao(this, locacao);
            this.setContentPane(jInicioSistema.getPainel());
            this.setTitle("Sistema de Gestão de Locações");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.pack();
            this.setSize(700,500);
            this.setVisible(true);
        }


        public boolean adicionaRobo(Robo robo){
            if(robos.isEmpty()){
                robos.add(robo);
                return true;
            }
            for(Robo c : robos){
                if(c.getId() == robo.getId()){
                    return false;
                }
            }
            for(int i =0; i<robos.size();i++){
                if(robo.getId()< robo.getId()){
                    robos.add(i,robo);
                    return true;
                }
            }
            robos.add(robo);
            return true;
        }

        public ArrayList<Robo> getRobos(){
            return robos;
        }

        public boolean adicionaCliente(Cliente cliente){
            if(clientes.isEmpty()){
                clientes.add(cliente);
                return true;
            }
            for(Cliente c : clientes){
                if(c.getCodigo() == cliente.getCodigo()){
                    return false;
                }
            }
            for(int i =0; i<clientes.size();i++){
                if(cliente.getCodigo()< cliente.getCodigo()){
                    clientes.add(i,cliente);
                    return true;
                }
            }
            clientes.add(cliente);
            return true;
        }

        public ArrayList<Cliente> getClientes(){
            return clientes;
        }


        public void adicionaLocacao(Locacao l){
            locacoesCad.add(l);
        }
        public boolean adicionaLocacaFila(Locacao l){
            if(locacoesCad.isEmpty()){
                fila.add(l);
                return true;
            }
            for (Locacao aux: locacoesCad){
                if(aux.getNumero()==l.getNumero()){
                    return false;
                }
            }
            fila.add(l);
            return true;
        }
        public void addFila(Locacao l){
            fila.add(l);
        }


        public ArrayList<Robo> getRobo(){
            return robos;
        }
        public Queue<Locacao> getFila(){
        return fila;
    }

        public void mudaPainel(int painel) {
            switch(painel) {
                case 1:
                    this.setContentPane(jInicioRobos.getPainel());
                    this.pack();
                    this.setSize(700,500);
                    break;
                case 2:
                    this.setContentPane(jCadAgricola.getPainel());
                    this.pack();
                    this.setSize(700,500);
                    break;
                case 3:
                    this.setContentPane(jCadDomestico.getPainel());
                    this.pack();
                    this.setSize(700,500);
                    break;
                case 4:
                    this.setContentPane(jCadIndustrial.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 5:
                    this.setContentPane(jRobosCadastrados.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 6:
                    this.setContentPane(jPrincipalClientes.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 7:
                    this.setContentPane(jCadIndividual.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 8:
                    this.setContentPane(jCadEmpresarial.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 9:
                    this.setContentPane(jCadstroCliente.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 10:
                    this.setContentPane(jInicioCadastro.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 11:
                    this.setContentPane(jInicioSistema.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 12:
                    this.setContentPane(jCarregarDados.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 13:
                    this.setContentPane(jSalvarDados.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 14:
                    this.setContentPane(jLocacoes.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 15:
                    this.setContentPane(jCadastrarLocacao.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 16:
                    this.setContentPane(jConsultaLocacao.getPainel());
                    this.pack();
                    this.setSize(700, 500);
                    break;
                case 17:
                    this.setContentPane(janelaEditarLocacao.getPainel());
                    this.pack();
                    this.setSize(700,500);
                    break;
            }
        }
    }
