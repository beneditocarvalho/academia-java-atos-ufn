package AtosUFN.projeto1.Models;


public class PessoaModel 
{
	public PessoaModel(String nome, Integer idade)
	{
		this.nome = nome;
		this.idade = idade;
	}
	
	private String nome;

	private Integer idade;

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String toString() {
		return "Pessoa (Nome: " + this.nome+ ", Idade: " + this.idade + ")";
	}
}
