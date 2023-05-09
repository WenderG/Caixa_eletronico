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
            System.out.printf("[1] - Criar conta\n[2] - Acessar uma conta\n[3] - Editar informações\n[4] - Excluir conta\n[0] - Sair\n");
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
                    if(contas == 0) {
                        System.out.println("Contas não encontradas ou inexistentes!");
                        
                    }else {
                        System.out.println("Número da conta: ");
                        opcao = Integer.parseInt(entrada.nextLine());
                        opcao--;      
    
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                        if(contasRegistradas[opcao] == null){
                            System.out.println("Conta não encontrada ou inexistente!");

                        }else if(opcao <= contas || contas >= 0 ) {
                            System.out.printf("Titular: %s", contasRegistradas[opcao].pegarNome());
                            System.out.println();
                            System.out.printf("CPF: %s", contasRegistradas[opcao].pegarCpf());
                            System.out.println();
                            System.out.printf("Número da Conta: %d", contasRegistradas[opcao].pegarNumeroConta());
                            System.out.println();
                            System.out.printf("Saldo Atual: R$%.2f", contasRegistradas[opcao].pegarSaldo());
                            System.out.println("\n");

                        } else {
                            System.out.println("Conta não encontrada ou inexistente!");

                        }
                    }

                    System.out.println("\n");
                    System.out.println("Pressione ENTER para continuar...");
                    entrada.nextLine();
                    break;
                

                case 3:
                    if(contas == 0){
                        System.out.println("Contas não encontrada ou inexistente!");
                        
                    }else {       
                        System.out.println("Número da conta: ");
                        opcao = Integer.parseInt(entrada.nextLine());
                        opcao--;

                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                        if(contasRegistradas[opcao] == null) {
                            System.out.println("Conta não encontrada ou inexistente!");

                        }else if(opcao <= contas || opcao >= 0) {

                            System.out.printf("[1] - Editar nome\n[2] - Editar CPF\n");
                            int opc = Integer.parseInt(entrada.nextLine());

                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                            if(opc == 1) {
                                System.out.printf("Nome do Titular atual: %s", contasRegistradas[opcao].pegarNome());
                                System.out.println();
                                System.out.printf("Nome do Titular novo: ");
                                contasRegistradas[opcao].definirNome(entrada.nextLine());
                                System.out.println();

                                System.out.println("Nome do Titular editado com sucesso!\n");

                            } else{
                                System.out.printf("CPF do Titular atual: %s", contasRegistradas[opcao].pegarCpf());
                                System.out.println();
                                System.out.printf("CPF do Titular novo: ");
                                contasRegistradas[opcao].definirCpf(entrada.nextLine());
                                System.out.println();

                                System.out.println("CPF do Titular editado com sucesso!\n");

                            }
                        } else {
                            System.out.println("Contas não encontradas ou inexistentes!");

                        }
                    }

                    System.out.println("\n");
                    System.out.println("Pressione ENTER para continuar...");
                    entrada.nextLine();
                    break;

                case 4:
                    if(contas == 0){
                        System.out.println("Contas não encontradas ou inexistentes!");
                        
                    }else {       
                        System.out.println("Número da conta: ");
                        opcao = Integer.parseInt(entrada.nextLine());
                        opcao--;

                        if(contasRegistradas[opcao] == null) {
                            System.out.println("Conta não encontrada ou inexistente!");

                        }else if(opcao <= contas || opcao >= 0) {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                            contasRegistradas[opcao] = null;

                            System.out.println("Conta deletada com sucesso!\n");

                            
                        } else {
                            System.out.println("Contas não encontradas ou inexistentes!");

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