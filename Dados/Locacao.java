package Dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locacao {
    private int numero;
    private Status situacao;
    private Date datainicio;
    private Date dataFim;

    private Cliente cliente;
    private ArrayList<Robo> robos;

    public Locacao(int numero, Status status, Date datainicio, Date dataFim, Cliente cliente, ArrayList<Robo> robos) {
        this.numero = numero;
        this.situacao = status;
        this.datainicio = datainicio;
        this.dataFim = dataFim;
        this.cliente = cliente;
        this.robos = robos;
    }

    public boolean adicionaRobo(Robo robo) {
        if (robos.isEmpty() || !robos.contains(robo)) {
            robos.add(robo);
            return true;
        }
        return false;
    }

    public double calculaValorFinal() {
        //Aq vai calcular tipo quanto tempo se passou entre as duas datas e fazer a logica baseada nisso
        long diferenca = dataFim.getTime() - datainicio.getTime();
        long dias = TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS) + 1;

        double valorTotal = 0;
        for (Robo robo : robos) {
            //Vai ficar num loop ate encerrar os robos alugados pelo cliente e calcular o valor iterando ele over e over ate o fim dos tempos (fim do array kk)
            valorTotal += robo.calculaLocacao() * robo.getValorDiario() * dias;
        }

        double desconto = cliente.calculaDesconto(robos.size());
        valorTotal = valorTotal - (valorTotal * desconto);

        return valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Status getSituacao() {
        return situacao;
    }

    public void setSituacao(Status situacao) {
        this.situacao = situacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Robo> getRobos() {
        return robos;
    }

    public void setRobos(ArrayList<Robo> robos) {
        this.robos = robos;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "numero=" + numero +
                ", situacao=" + situacao +
                ", datainicio=" + datainicio +
                ", dataFim=" + dataFim +
                ", cliente=" + cliente +
                ", robos=" + robos +
                '}';
    }
}
