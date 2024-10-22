package restauranteav;

public class Funcionario {
	
	private String nome;
	private int idFuncionario;
	private String cargo;
	private double totalVendas;
	
	public Funcionario(String nome, int idFuncionario, String cargo) {
		super();
		this.nome = nome;
		this.idFuncionario = idFuncionario;
		this.cargo = cargo;
		this.totalVendas = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getTotalVendas() {
		return totalVendas;
	}

	public void setTotalVendas(double totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	public void registrarVenda(double valorVenda) {
		if(cargo.equalsIgnoreCase("Garçom")) {
			totalVendas += valorVenda;
		}
	}

	@Override
    public String toString() {
        return "Nome: " + nome + ", ID: " + idFuncionario + ", Cargo: " + cargo + 
               (cargo.equalsIgnoreCase("Garçom") ? ", Total de Vendas: R$ " + totalVendas : "");
    }	
}	
	
	 

