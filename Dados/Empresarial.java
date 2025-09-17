package Dados;

public class Empresarial extends Cliente {
    private int ano;

    public Empresarial(String nome, int codigo, int ano) {
        super(nome, codigo);
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public double calculaDesconto(int size) {

        if(size>=2 && size<=9){
            return 0.03;
        } else if (size>=10) {
            return 0.07;
            
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                "ano=" + ano +
                '}';
    }
}
