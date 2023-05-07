import java.io.IOException;
import java.util.Scanner;
import java.lang.Thread;

public class CaixaEletronico {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);

        int tam = 5;

        Titular[] contasRegistradas = new Titular[tam];

        boolean aux = true;
        int opcao, contas = 0, i = 0;

        do {
            
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            System.out.println();
            System.out.printf("\t\tWENDERCAIXA");
            System.out.println("\n");
            
            System.out.printf("\tEscolha uma opção:");
            System.out.println("\n");
            System.out.printf("[1] - Criar conta\n[2] - Contas cadastradas\n[0] - Sair\n");
            System.out.println();
            
            System.out.printf("Decisão: ");
            opcao = Integer.parseInt(entrada.nextLine());

            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            switch(opcao){
                case 0:
                    try {
                        System.out.println("Encerrando...");
                        Thread.sleep(2000);

                    } catch (Exception e) {
                        System.out.println(e);

                    }

                    aux = false;
                    break;

                case 1:
                    if(contas < tam) {
                        contas++;

                        Titular titular = new Titular();

                        System.out.printf("Nome do Titular: ");
                        titular.definirNome(entrada.nextLine());
                        System.out.println();

                        System.out.printf("CPF do Titular: ");
                        titular.definirCpf(entrada.nextLine());
                        System.out.println();

                        titular.definirNumeroConta(contas);

                        System.out.println("Deseja fazer um depósito inicial?");
                        System.out.printf("[1] - Sim\n[2] - Não\n");
                        System.out.println();
                        System.out.printf("Decisão: ");
                        opcao = Integer.parseInt(entrada.nextLine());

                        if(opcao == 1) {
                            System.out.printf("Valor a ser depositado (R$): ");
                            titular.definirSaldo(Double.parseDouble(entrada.nextLine()));
                        }

                        System.out.println();

                        contasRegistradas[i] = titular;

                        i++;
                        
                        System.out.println("Conta cadastrada com sucesso!\n");

                        System.out.println("Pressione ENTER para continuar...");
                        entrada.nextLine();
                    
                    }else {
                        System.out.println("Memória insuficiente!\n");

                        System.out.println("Pressione ENTER para continuar...");
                        entrada.nextLine();
                    }
                    break;

                case 2:
                    for(int j = 0; j < tam; j++) {              
                        if(contasRegistradas[j] != null) {
                            System.out.printf("Titular: %s", contasRegistradas[j].pegarNome());
                            System.out.println();
                            System.out.printf("CPF: %s", contasRegistradas[j].pegarCpf());
                            System.out.println();
                            System.out.printf("Número da Conta: %d", contasRegistradas[j].pegarNumeroConta());
                            System.out.println();
                            System.out.printf("Saldo Atual: R$%.2f", contasRegistradas[j].pegarSaldo());
                            System.out.println("\n");
                        }
                    }

                    System.out.println("\n");
                    System.out.println("Pressione ENTER para continuar...");
                    entrada.nextLine();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    System.out.println("\n");
                    System.out.println("Pressione ENTER para continuar...");
                    entrada.nextLine();
                    break;
            }

        }while(aux);
        
        entrada.close();

    }

}