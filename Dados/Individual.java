package Dados;

public class Individual extends Cliente {
    private String cpf;

    public Individual(String nome, int codigo, String cpf) {
        super(nome, codigo);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public double calculaDesconto(int size) {

        if(size>=2){
            return 0.05;
        }
        return 0;
    }


    @Override
    public String toString() {
        return super.toString() +
                "cpf='" + cpf + '\'' +
                '}';
    }
}

