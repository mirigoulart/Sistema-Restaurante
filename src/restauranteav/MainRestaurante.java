package restauranteav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainRestaurante {
    
    public static void main(String[] args) {
        SistemaRestaurante sistema = new SistemaRestaurante();
        Scanner scan = new Scanner(System.in);
        int opcao; 
        
        do {
            System.out.println("\nMENU PRINCIPAL DO RESTAURANTE");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Cadastrar Mesa");
            System.out.println("3. Adicionar item ao Cardápio");
            System.out.println("4. Registrar Pedido");
            System.out.println("5. Fechar conta");
            System.out.println("6. Registrar Pagamento");
            System.out.println("7. Relatório de Faturamento Diário"); 
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            opcao = scan.nextInt();
            
            switch(opcao) {
                case 1: 
                    System.out.print("Nome do Funcionário: ");
                    scan.nextLine(); 
                    String nome = scan.nextLine();
                    System.out.print("ID do Funcionário: ");
                    int idFuncionario = scan.nextInt();
                    System.out.print("Cargo do Funcionário: ");
                    String cargo = scan.next();
                    sistema.cadastrarFuncionario(nome, idFuncionario, cargo);
                    break;
                    
                case 2:     
                    System.out.print("Número da Mesa: ");
                    int numeroMesa = scan.nextInt();
                    System.out.print("Capacidade da Mesa: ");
                    int capacidade = scan.nextInt();
                    sistema.cadastrarMesa(numeroMesa, capacidade); 
                    break;
                
                case 3: 
                    System.out.print("Nome do Item: ");
                    scan.nextLine();
                    String itemNome = scan.nextLine();
                    System.out.print("Código do Item: ");
                    int codigoItem = scan.nextInt();
                    System.out.print("Preço do Item: ");
                    double precoItem = scan.nextDouble();
                    System.out.print("Disponível? (true/false): ");
                    boolean disponivel = scan.nextBoolean();
                    sistema.adicionarItemCardapio(itemNome, codigoItem, precoItem, disponivel);
                    break;
                    
                case 4:
                    System.out.print("Número da Mesa: ");
                    int mesaNumero = scan.nextInt();
                    Mesa mesa = null;
                    for (Mesa m : sistema.mesas) {
                        if (m.getNumeroMesa() == mesaNumero) {
                            mesa = m; 
                            break;   
                        }
                    }
                    if (mesa != null) {
                        System.out.print("ID do Garçom: ");
                        int idGarcom = scan.nextInt();
                        Funcionario garcom = null;
                        for (Funcionario f : sistema.funcionarios) {
                            if (f.getIdFuncionario() == idGarcom) {
                                garcom = f; 
                                break;      
                            }
                        }
                        if (garcom != null) {
                            List<ItemCardapio> itensPedido = new ArrayList<>();
                            System.out.println("Digite o código dos itens (Digite -1 para sair): ");
                            while (true) {
                                int codigoPedido = scan.nextInt();
                                if (codigoPedido == -1) break;
                                ItemCardapio item = sistema.cardapio.buscarItem(codigoPedido);
                                if (item != null) {
                                    itensPedido.add(item);
                                } else {
                                    System.out.println("Item não encontrado!");
                                }
                            }
                            sistema.registrarPedido(mesa, garcom, itensPedido);
                        } else {
                            System.out.println("Garçom não encontrado!");
                        }
                    } else {
                        System.out.println("Mesa não encontrada!");
                    }
                    break;
                
                case 5: 
                    System.out.print("Número da Mesa para fechamento da conta: ");
                    int mesaNumeroFechamento = scan.nextInt();
                    Mesa mesaFechamento = null; 
                    for (Mesa m : sistema.mesas) {
                        if (m.getNumeroMesa() == mesaNumeroFechamento) {
                            mesaFechamento = m; 
                            break;   
                        }
                    }
                    if (mesaFechamento != null) { 
                        sistema.fecharConta(mesaFechamento);
                    } else {
                        System.out.println("Mesa não encontrada!");
                    }
                    break;

                case 6: 
                    System.out.print("Número da Mesa para registrar o pagamento: ");
                    int mesaNumeroPagamento = scan.nextInt();
                    Mesa mesaPagamento = null; 
                    for (Mesa m : sistema.mesas) {
                        if (m.getNumeroMesa() == mesaNumeroPagamento) {
                            mesaPagamento = m; 
                            break;   
                        }
                    }
                    if (mesaPagamento != null) { 
                        sistema.registrarPagamento(mesaPagamento);
                    } else {
                        System.out.println("Mesa não encontrada!");
                    }
                    break;
                
                case 7:
                    sistema.relatorioFaturamentoDiario();
                    break;
                
                case 0: 
                    System.out.println("Saindo do sistema...");
                    break;
                
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            } 
        } while (opcao != 0);
        
        scan.close();
    }
}


