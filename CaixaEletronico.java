public class CaixaEletronico {
    public static void main(String[] args) {
        Titular Thiago = new Titular();

        Thiago.definirNome("Thiago Wender Gonsales");
        Thiago.definirCpf("123.456.789-00");
        Thiago.definirNumeroConta(1234567890);
        Thiago.definirSaldo(1320.00);

        Thiago.imprimir(Thiago.pegarNome(), Thiago.pegarCpf(), Thiago.pegarNumeroConta(), Thiago.pegarSaldo());

        System.out.println();

        Titular Joao = new Titular();

        Joao.definirNome("Joao Jose Caetano");
        Joao.definirCpf("987.654.321-00");
        Joao.definirNumeroConta(987654321);
        Joao.definirSaldo(2500.00);

        Joao.imprimir(Joao.pegarNome(), Joao.pegarCpf(), Joao.pegarNumeroConta(), Joao.pegarSaldo());

        Joao.sacar(Joao.pegarNome(), 1000.00);
        Thiago.depositar(Thiago.pegarNome(), 100.0);
        Thiago.tranferir(Thiago.pegarNome(), 15.45, Joao);

    }

}