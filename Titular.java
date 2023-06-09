public class Titular extends Pessoa {
    private int numeroConta;
    private double saldo = 0;
    private int senha;

    public int pegarNumeroConta() {
        return numeroConta;
    }

    public void definirNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }


    public double pegarSaldo() {
        return saldo;
    }

    public void definirSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(String nome, double deposito) {

        this.saldo += deposito;

        System.out.println();
        System.out.printf("Titular %s depositou R$%.2f.", nome, deposito);
        System.out.println();
        System.out.printf("Saldo Atual: R$%.2f", saldo);
        System.out.println("\n");

    }

    public void sacar(String nome, double saque) {

        this.saldo -= saque;

        System.out.println();
        System.out.printf("Titular %s retirou R$%.2f.", nome, saque);
        System.out.println();
        System.out.printf("Saldo Atual: R$%.2f", this.saldo);
        System.out.println("\n");
        
    }

    public void tranferir(String nome, double transferencia, Titular conta) {

        this.saldo -= transferencia;

        System.out.println();
        System.out.printf("Titular %s transferiu R$%.2f para a conta #%d.", nome, transferencia, conta.pegarNumeroConta());
        System.out.println();
        System.out.printf("Saldo Atual: R$%.2f", this.saldo);
        System.out.println();

        double receber = conta.pegarSaldo() + transferencia;

        conta.definirSaldo(receber);

        System.out.println("\n");
       
        
    }

    public int pegarSenha() {
        return senha;
    }

    public void definirSenha(int senha) {
        this.senha = senha;
    }
}

