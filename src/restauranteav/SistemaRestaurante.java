package restauranteav;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaRestaurante {
    public List<Funcionario> funcionarios;
    public List<Mesa> mesas;
    public Cardapio cardapio;
    public List<Pedido> pedidos;

    public SistemaRestaurante() {
        funcionarios = new ArrayList<>();
        mesas = new ArrayList<>();
        cardapio = new Cardapio();
        pedidos = new ArrayList<>();
    }

    public void cadastrarFuncionario(String nome, int idFuncionario, String cargo) {
        Funcionario funcionario = new Funcionario(nome, idFuncionario, cargo);
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    public void cadastrarMesa(int numeroMesa, int capacidade) {
        Mesa mesa = new Mesa(numeroMesa, capacidade);
        mesas.add(mesa);
        System.out.println("Mesa cadastrada com sucesso!"); 
    }

    public void adicionarItemCardapio(String nome, int codigo, double preco, boolean disponivel) {
        ItemCardapio item = new ItemCardapio(nome, codigo, preco, disponivel);
        cardapio.adicionarItem(item);
        System.out.println("Item adicionado ao cardápio com sucesso!");
    }

    public void registrarPedido(Mesa mesa, Funcionario garcom, List<ItemCardapio> itens) {
        double valorTotal = 0;
        for (ItemCardapio item : itens) {
            valorTotal += item.getPreco();
        }
        Pedido pedido = new Pedido(mesa, garcom, itens, valorTotal);
        pedidos.add(pedido);
        garcom.registrarVenda(valorTotal);
        System.out.println("Pedido registrado com sucesso");
    }

    public void fecharConta(Mesa mesa) {
        Pedido pedido = pedidos.stream()
                .filter(p -> p.getMesa().getNumeroMesa() == mesa.getNumeroMesa())
                .findFirst()
                .orElse(null);

        if (pedido != null) {
            System.out.println("Valor total da conta: R$ " + pedido.getValorTotal());
        } else {
            System.out.println("Não há pedidos registrados para esta mesa.");
        }
    }

    public void registrarPagamento(Mesa mesa) {
        fecharConta(mesa);
        System.out.print("Registrar pagamento (digite qualquer tecla para confirmar): ");
        new Scanner(System.in).nextLine(); 
        mesa.setOcupada(false);
        System.out.println("Pagamento registrado. Mesa " + mesa.getNumeroMesa() + " liberada.");
    }

    public void relatorioFaturamentoDiario() {
        double totalVendasDia = 0;
        System.out.println("Relatório de Faturamento Diário:");
        for (Pedido pedido : pedidos) {
            totalVendasDia += pedido.getValorTotal();
        }
        System.out.println("Total de vendas realizadas no dia: R$ " + totalVendasDia); 
        
        System.out.println("\nTotal de venda por mesa: ");
        for (Mesa mesa : mesas) {
            double totalPorMesa = 0;
            for (Pedido pedido : pedidos) {
                if (pedido.getMesa().getNumeroMesa() == mesa.getNumeroMesa()) {
                    totalPorMesa += pedido.getValorTotal();
                }
            }
            System.out.println("Mesa " + mesa.getNumeroMesa() + ": R$ " + totalPorMesa);
        }
        System.out.println("\nTotal de vendas por funcionário:");
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase("Garçom")) {
                System.out.println(funcionario.getNome() + ": R$ " + funcionario.getTotalVendas());
            }
        }
    }
}
