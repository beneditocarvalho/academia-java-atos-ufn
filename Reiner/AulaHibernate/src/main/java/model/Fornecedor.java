package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor {
	
	@Id
	private int id;
	private String nome;
	private String email;
	private String cidade;
	
	public Fornecedor(int id, String nome, String email, String cidade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cidade = cidade;
	}

	public Fornecedor() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nome=" + nome + ", email=" + email + ", cidade=" + cidade + "]";
	}

	
}