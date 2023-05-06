public class Pessoa {
    protected String nome;
    private String cpf;

    public String pegarNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String pegarCpf() {
        return cpf;
    }

    public void definirCpf(String cpf) {
        this.cpf = cpf;
    }
}
