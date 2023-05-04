public class CaixaEletronico {
    public static void main(String[] args) {
        Titular Thiago = new Titular();

        Thiago.setNomeTitular("Thiago Wender Gonsales");
        Thiago.setNumeroConta(1234567890);
        Thiago.setSaldo(1320.00);

        System.out.printf("Titular: %s", Thiago.getNomeTitular());
        System.out.println();
        System.out.printf("Numero da Conta: %d", Thiago.getNumeroConta());
        System.out.println();
        System.out.printf("Saldo Atual: %.2f", Thiago.getSaldo());
        System.out.println();
    }
}
