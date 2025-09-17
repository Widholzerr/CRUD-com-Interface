package Dados;

public class Domestico extends Robo{
    private int nivel;

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Domestico(int nivel, int id, String modelo, double valorDiario){
        super(id, modelo, valorDiario);
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "nivel=" + nivel +
                '}';
    }

    @Override
    public double calculaLocacao() {
        if (this.getNivel() == 1){
            return 10.00;
        } else if (this.getNivel() == 2){
            return 20.00;
        }
        return 50.00;
    }
}
