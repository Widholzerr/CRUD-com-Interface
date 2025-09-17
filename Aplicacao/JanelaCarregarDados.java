package Aplicacao;

import Dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class JanelaCarregarDados {
    private Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private JPanel painel;
    private JLabel texto;
    private JLabel texto2;
    private JTextField campoArquivo;
    private JLabel mensagem;
    private JButton botaoCarregar;
    private JButton botaoVoltar;
    private JButton botaoCarregarInicial;
    private ACMERobots app;

    public JanelaCarregarDados(ACMERobots app){
        this.app = app;


        botaoCarregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path path1 = Paths.get("");
                try {
                    //carregar stream
                //}catch (IOException z){
                }catch (Exception i){
                    mensagem.setText("Erro ao carregar o aquivo, tente novamente. ");
                    campoArquivo.setText("");
                }
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(11);
            }
        });
        botaoCarregarInicial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carregarDados();
            }
        });
    }

    public JPanel getPainel(){
        return painel;
    }

    public void carregarDados() {
        try (BufferedReader streamEntrada = new BufferedReader(new FileReader("EXEMPLO-ROBOS.CSV"));
             Scanner entrada = new Scanner(streamEntrada)) {

            // Processa os dados dos robôs
            String linha;
            if (entrada.hasNextLine()) {
                entrada.nextLine(); // Pula a linha de cabeçalho
            }
            while (entrada.hasNextLine()) {
                linha = entrada.nextLine();
                if (linha.equals("-1")) break;

                String[] colunas = linha.split(";");
                String tipo = colunas[0];
                switch (tipo) {
                    case "A":
                        int id = Integer.parseInt(colunas[1]);
                        String modelo = colunas[2];
                        String uso = colunas[5];
                        String nivelAreaSetor = colunas[4];
                        double valor = Double.parseDouble(colunas[6]);
                        Agricola a = new Agricola(Double.parseDouble(nivelAreaSetor), uso, id, modelo, valor);
                        app.robos.add(a);
                        break;
                    case "I":
                        int idI = Integer.parseInt(colunas[1]);
                        String modeloI = colunas[2];
                        double valorI = Double.parseDouble(colunas[5]);
                        String nivelAreaSetorI = colunas[4];
                        Industrial i = new Industrial(nivelAreaSetorI, idI, modeloI, valorI);
                        app.robos.add(i);
                        break;
                    case "D":
                        int idD = Integer.parseInt(colunas[1]);
                        String modeloD = colunas[2];
                        double valorD = Double.parseDouble(colunas[5]);
                        String nivelAreaSetorD = colunas[4];
                        Domestico d = new Domestico(Integer.parseInt(nivelAreaSetorD), idD, modeloD, valorD);
                        app.robos.add(d);
                        break;
                }
            }

            // Processa os dados dos clientes
            if (entrada.hasNextLine()) {
                entrada.nextLine(); // Pula a linha de cabeçalho dos clientes
            }
            while (entrada.hasNextLine()) {
                linha = entrada.nextLine();
                if (linha.equals("-1")) break;

                String[] colunas = linha.split(";");
                String tipo = colunas[0];

                switch (tipo) {
                    case "E":
                        int codigo = Integer.parseInt(colunas[1]);
                        String nome = colunas[2];
                        String tipoCliente = colunas[3];
                        String cpfAno = colunas[4];
                        Empresarial e = new Empresarial(nome, codigo, Integer.parseInt(cpfAno));
                        app.clientes.add(e);
                        break;
                    case "I":
                        int codigoI = Integer.parseInt(colunas[1]);
                        String nomeI = colunas[2];
                        String cpfAnoI = colunas[4];
                        Individual i = new Individual(nomeI, codigoI, cpfAnoI);
                        app.clientes.add(i);
                        break;
                }
                if (entrada.hasNextLine()) {
                  linha =   entrada.nextLine(); // Pula a linha de cabeçalho dos clientes
                }
                while (entrada.hasNextLine()) {

                    if (linha.equals("-1")) break;
                    String[] colunasL = linha.split(";");

                    int numero = Integer.parseInt(colunasL[0]);
                    String format = "dd/MM/yyyy";
                    SimpleDateFormat sdf = new SimpleDateFormat(format);
                    Date data = new Date();
                    Date inicio = sdf.parse(colunasL[1]);
                    Date fim = sdf.parse(colunasL[2]);
                    int codCliente = Integer.parseInt(colunasL[3]);
                    Cliente c1 = null;
                    for (Cliente c : app.clientes) {
                        if (c.getCodigo() == codCliente) {
                            c1 = c;
                        }
                    }
                    int codR = Integer.parseInt(colunasL[4]);
                    ArrayList<Robo> robos = new ArrayList<>();
                    for (int i = 4; i < colunasL.length - 1; i++) {
                        for (Robo r : app.robos) {
                            if (r.getId() == codR) {
                                robos.add(r);
                            }
                        }
                    }
                    Locacao l = new Locacao(numero, Status.EXECUTANDO, inicio, fim, c1, robos);
                    app.locacoesCad.add(l);
                    linha = entrada.nextLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter dados: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }
    }

