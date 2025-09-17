package Dados;

public class Agricola extends Robo {
    private double area;
    private String uso;

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public Agricola(double area, String uso, int id, String modelo, double valorDiario){
        super(id, modelo, valorDiario);
        this.area=area;
        this.uso = uso;
    }

    @Override
    public String toString() {
        return super.toString()  +
                "area=" + area +
                ", uso='" + uso + '\'' +
                '}';
    }

    @Override
    public double calculaLocacao() {
        return 0;
    }
}
