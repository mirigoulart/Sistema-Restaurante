package restauranteav;

public class ItemCardapio {
	
	private String nome;
	private int codigo;
	private double preco;
	private boolean disponivel;
	
	public ItemCardapio(String nome, int codigo, double preco, boolean disponivel) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.preco = preco;
		this.disponivel = disponivel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	 @Override
	    public String toString() {
	        return "Nome: " + nome + ", Código: " + codigo + ", Preço: R$ " + preco + ", Disponível: " + (disponivel ? "Sim" : "Não");
	    }
	}
