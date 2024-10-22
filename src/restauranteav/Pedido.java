package restauranteav;

import java.util.List;

public class Pedido {
	
	private Mesa mesa;
	private Funcionario garcom;
	private List<ItemCardapio> itensPedidos;
	private double valorTotal;
	
	public Pedido(Mesa mesa, Funcionario garcom, List<ItemCardapio> itensPedidos, double valorTotal) {
		super();
		this.mesa = mesa;
		this.garcom = garcom;
		this.itensPedidos = itensPedidos;
		this.valorTotal = valorTotal;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Funcionario getGarcom() {
		return garcom;
	}

	public void setGarcom(Funcionario garcom) {
		this.garcom = garcom;
	}

	public List<ItemCardapio> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemCardapio> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	 @Override
	    public String toString() {
	        return "Pedido para a mesa " + mesa.getNumeroMesa() + ", Garçom: " + garcom.getNome() + ", Valor Total: R$ " + valorTotal;
	    }
}
