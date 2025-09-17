package Dados;

public class Industrial extends Robo {
    private String setor;

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Industrial(String setor, int id, String modelo, double valorDiario){
        super(id, modelo, valorDiario);
        this.setor = setor;
    }

    @Override
    public String toString() {
        return super.toString() +
                "setor='" + setor + '\'' +
                '}';
    }

    @Override
    public double calculaLocacao() {
        return 90.00;
    }
}
