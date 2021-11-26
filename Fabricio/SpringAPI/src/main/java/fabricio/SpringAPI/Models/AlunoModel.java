package fabricio.SpringAPI.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class AlunoModel {

	@ApiModelProperty(notes = "É o ID do aluno, é autoincremento...", name = "id", required = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(notes = "Nome do aluno", name = "nome", required = true, value = "Nome do Aluno")
	@Column(nullable = false)
	private String nome;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "AlunoModel [id=" + id + ", nome=" + nome + "]";
	}
	
}