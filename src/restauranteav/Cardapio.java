package restauranteav;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	private List<ItemCardapio> itens;
	
	public Cardapio() {
		this.itens = new ArrayList<>();
	}
	
	public void adicionarItem(ItemCardapio item) {
		itens.add(item);
	}
	
	public boolean removerItem(int codigo) {
		for (ItemCardapio item : itens) {
			if(item.getCodigo() == codigo) {
				itens.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public ItemCardapio buscarItem(int codigo) {
		for(ItemCardapio item : itens) {
			if (item.getCodigo() == codigo) {
				return item;
			}
		}
		return null;
	}
	
	public void listarItens() {
		for(ItemCardapio item : itens) {
			System.out.println(item);
		}
	}
}
